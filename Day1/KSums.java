package Day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/submissions/
 * @author amjain
 * input : [1 , 0 , -1 , 0 , -2 , 2]
 */
public class KSums {

	public static List<Integer> findKSums(int target, int[] nums, int stIndex , int eleCount) {
		List<Integer> res = new ArrayList<>();
		if(eleCount>2) {
			int nextTarget = target - nums[stIndex];
			List<Integer> subRes = findKSums(nextTarget , nums , stIndex+1 , eleCount-1);
			if(subRes.size()==(eleCount-1)) {
				res.add(nums[stIndex]);
				res.addAll(subRes);
			}
		}
		if(eleCount==2) { return find2Sums(target,nums,stIndex); }
		return res;
	}
	
	public static List<Integer> find2Sums(int target, int[] nums,int stIndex){
		List<Integer> res = new ArrayList<>();
		Map<Integer,Integer> eleMap = new HashMap<>();
		int complement;
		for(int i=stIndex ; i<nums.length ; i++){
			complement = target - nums[i];
			if(eleMap.containsKey(complement)){
				res.add(nums[i]);
				res.add(complement);
				return res;
			}
			eleMap.put(nums[i],i);
		}
		return res;
	}
	
	public static void main(String args[]) {
		int target = 0;
		int eleCount = 4;
//		int[] nums = {1 , 0 , -1 , 0 , -2 , 2};
		
		eleCount = 3;
		int[] nums = {-1,0,1,2,-1,-4};
		
		Arrays.sort(nums);
		
		List<List<Integer>> res = new ArrayList<>(); 
		eleCount-=1;
		for(int index=0; index<nums.length-eleCount ; index++) {
			target = (-nums[index]);
			for(int j=index+1; j<=nums.length-eleCount ;j++) {
				
				if(index>0 && nums[index] == nums[index-1]) { continue; } // to avoid duplicates
				
				List<Integer> validRes = findKSums(target,nums,j,eleCount);
				
				if(validRes.size()==eleCount) {
					validRes.add(nums[index]); res.add(validRes); 
				}
			}
		}
		
		target = 0;
		eleCount+=1;
		for(int index=0; index<nums.length-eleCount ; index++) {
			
			if(index>0 && nums[index] == nums[index-1]) { continue; } // to avoid duplicates
			
			List<Integer> validRes = findKSums(target,nums,index,eleCount);
			
			if(validRes.size()==eleCount) {
				res.add(validRes); 
			}
		}
		
		for(List<Integer> val:res) {
				System.out.println(val.toString());
		}
	}
}
