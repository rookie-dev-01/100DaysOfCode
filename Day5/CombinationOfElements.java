package Day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationOfElements {

	
	public static void removeDuplicated() {
		Set<List<Integer>> theset = new HashSet<>();
		List<Integer> set1 = new ArrayList<>(); set1.add(1); set1.add(2); set1.add(3);
		List<Integer> set2 = new ArrayList<>(); set2.add(1); set2.add(2); set2.add(3);
		theset.add(set1); theset.add(set2);
		System.out.println(theset.size());
		
	}
	
	/**
	 * 	
	 *	 index <= (r-1) if r = 3; index shouldn't exceed 2 result[0,1,2]
	 */
	public static void kSum(int[] arr,int[] data,int start,int end,int index, int k, Set<List<Integer>> resultList) {
		if (index == k) 
		{
			List<Integer> list = new ArrayList<>();
			if(data[0]+data[1]+data[2] == 0) {
				list.add(data[0]); list.add(data[1]); list.add(data[2]);
				Collections.sort(list);
				resultList.add(list);
			}
			return; 
		}
		
		for(int i=start ; i<=end && end-i+1 >= k-index;i++) {
			data[index] = arr[i];
			kSum(arr,data,i+1,end,index+1,k,resultList);
		}
		
	}
	
	static void combinationUtil(int arr[], int data[], int start, 
			int end, int index, int r) 
	{ 
		// Current combination is ready to be printed, print it 
		if (index == r) 
		{ 
			for (int j=0; j<r; j++) 
				System.out.print(data[j]+" "); 
			System.out.println(""); 
			return; 
		} 

		// replace index with all possible elements. The condition 
		// "end-i+1 >= r-index" makes sure that including one element 
		// at index will make a combination with remaining elements 
		// at remaining positions 
		for (int i=start; i<=end && end-i+1 >= r-index; i++) 
		{ 
			data[index] = arr[i]; 
			combinationUtil(arr, data, i+1, end, index+1, r); 
		}
	} 

	// The main function that prints all combinations of size r 
	// in arr[] of size n. This function mainly uses combinationUtil() 
	static List<List<Integer>> printCombination(int arr[], int n, int r) 
	{ 
		// A temporary array to store all combination one by one 
		int data[]=new int[r]; 

		// Print all combination using temprary array 'data[]' 
//		combinationUtil(arr, data, 0, n-1, 0, r);
		
		Set<List<Integer>> result = new HashSet<>();
		kSum(arr, data, 0, n-1, 0, r,result);
		List<List<Integer>> resultList = new ArrayList<>(result);
		for(List<Integer> l1:resultList) {
			for(Integer l:l1) {
				System.out.print(" "+l);
			}
			System.out.println();
		}
		System.out.println();
		return resultList;
	}

	/*Driver function to check for above function*/
	public static void main (String[] args) { 
//		int arr[] = {-1,0,1,2,-1,-4};
		int arr[] = {3,0,-2,-1,1,2};
		int r = 3; 
		int n = arr.length;
//		removeDuplicated();
		printCombination(arr, n, r); 
	} 
} 
