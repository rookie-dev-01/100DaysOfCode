package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarPooling {

	 public static boolean carPooling(int[][] trips, int capacity) {
	        if(trips.length==0 || capacity==0) return false;
	        List<Integer> allStops = new ArrayList<>();
	        Map<Integer,Integer> passPickMap = new HashMap<>();
	        Map<Integer,Integer> passDropMap = new HashMap<>();
	        for(int i=0;i<trips.length;i++){
	            int pass = trips[i][0];
	            int start = trips[i][1];
	            int end = trips[i][2];
	            
	            if(!allStops.contains(start)) { allStops.add(start); }
	            
	            if(!allStops.contains(end)) { allStops.add(end); }
	            
	            if(passPickMap.containsKey(start))
	            {
	                passPickMap.put(start,(passPickMap.get(start)+pass));
	            }else{
	                passPickMap.put(start,pass);
	            }
	            
	            if(passDropMap.containsKey(end))
	            {
	                passDropMap.put(end,(passDropMap.get(end)+pass));
	            }else{
	                passDropMap.put(end,pass);
	            }
	        }
	        int currCap=0;
	        Collections.sort(allStops);
	        for(Integer stops:allStops){
	            if(currCap>capacity) return false;
	            if(passPickMap.containsKey(stops)) { currCap+=passPickMap.get(stops); }
	            if(passDropMap.containsKey(stops)) {currCap-=passDropMap.get(stops); }
	        }
	        return true;
	    }
	
	public static void main(String[] args) {
		int[][] arr = {{2,1,5},{3,3,7}};
		System.out.println(carPooling(arr,4));
		
		int[][] arr1 = {{2,1,5},{3,3,7}};
		System.out.println(carPooling(arr1,5));
		
		int[][] arr2 = {{2,1,5},{3,5,7}};
		System.out.println(carPooling(arr2,3));
		
		int[][] arr3 = {{3,2,7},{3,7,9},{8,3,9}};
		System.out.println(carPooling(arr3,11));
	}

}
