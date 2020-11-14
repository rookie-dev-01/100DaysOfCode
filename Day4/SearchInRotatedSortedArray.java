package Day4;


/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * @author amjain
 *
 */
public class SearchInRotatedSortedArray {
	
	 public static int search(int[] nums, int target) {
	        int pivotIndex = 0;
	        for(int i=1;i<nums.length;i++){
	            if(nums[i-1]>nums[i]){
	                pivotIndex = i;
	                break;
	            }
	        }
	        int startIndex = 0; 
	        int endIndex = nums.length-1;
	        if(target == nums[pivotIndex]) { return pivotIndex; }
	        if((pivotIndex+1 < nums.length) && target == nums[pivotIndex+1]) { return pivotIndex+1; }
	        if((pivotIndex-1 >=0) && target == nums[pivotIndex-1]) { return pivotIndex-1; }
	        if(pivotIndex==0) { return searchAlgo(nums,0,nums.length-1,target); }

	        if((target >= nums[0]) && target <= nums[pivotIndex-1]) {
	        		endIndex = pivotIndex-1;
	        }else {
	        		startIndex = pivotIndex;
	        }
//	        System.out.println(startIndex+" "+endIndex);
	        return searchAlgo(nums,startIndex,endIndex,target);
	    }
	 
	 public static int searchAlgo(int[] arr,int sIndex,int endIndex,int target) {
		 int midIndex = (endIndex + sIndex)/2;
		 if(endIndex==sIndex) return -1;
		 if(target == arr[midIndex]) {
			 return midIndex;
		 }else if(target < arr[midIndex]) {
			 return searchAlgo(arr,sIndex,midIndex,target);
		 }else if(target == arr[midIndex+1]) {
			 return midIndex+1;
		 }else if(target > arr[midIndex]) {
			 return searchAlgo(arr,midIndex+1,endIndex,target);
		 }
		 return -1;
	 }
	        
	 public static void main(String args[]) {
//		 int[] nums = {4,5,6,7,0,1,2};
		 int[] nums = {3,1};
//		 [4,5,6,7,0,1,2]
//				 3
		 int target = 3;
		 System.out.println(search(nums,target));
	 }
    
    
}