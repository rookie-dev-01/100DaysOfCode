package Day1;

import java.util.HashMap;
import java.util.Map;


/**
 * https://leetcode.com/problems/two-sum/submissions/
 * works with the concept of finding a number's complement
 * @author amjain
 *
 */
public class TwoSums {
	public static int[] twoSum(int[] nums, int target) {
		int[] resultArr = new int[2];
		for(int i=0 ; i<nums.length ; i++){
			for(int j=i+1 ; j<nums.length ; j++){
				if(nums[i] + nums[j] == target){
					resultArr[0] = i;
					resultArr[1] = j;
					return resultArr;
				}
			}
		}
		return resultArr;
	}

	public static int[] optimized(int[] nums, int target) {
		 Map<Integer,Integer> eleMap = new HashMap<Integer,Integer>();
	        int complement = 0;
	        for(int i=0 ; i<nums.length ; i++){
	               complement = target - nums[i];
	                if(eleMap.containsKey(complement)){
	                    return new int[] {i,eleMap.get(complement)};
	                }
	            eleMap.put(nums[i],i);
	         }
	        return new int[]{};
	}
	
	public static void main(String args[]) {
		int[] nums = {2,2};
		int[] result = new int[2];
		result = twoSum(nums,4);
		System.out.println(result[0]+" "+result[1]);
		result = optimized(nums,4);
		System.out.println(result[0]+" "+result[1]);
	}
}
