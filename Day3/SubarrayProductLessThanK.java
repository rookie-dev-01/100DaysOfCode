package Day3;

public class SubarrayProductLessThanK {

	
	//using sliding window to solve this
	public int slidingwindow(int[] nums, int k) {
        if (k <= 1) return 0;
       int prod = 1, ans = 0, left = 0;
       for (int right = 0; right < nums.length; right++) {
           prod *= nums[right];
           while (prod >= k) prod /= nums[left++];
           ans += right - left + 1;
       }
       return ans;
   }
	
	
	//this gave TLE 
	    public static int numSubarrayProductLessThanK(int[] nums, int k) {
	        int counter=0;
	     for(int i=0;i<nums.length;i++)   {
	         if(nums[i]<k){
	             counter++;
	         }else{
	             //if the num[i] is greater than or equal to k, anu multiplication would be greater
	             continue;
	         }
	         
	         int val = nums[i];
	         for(int j=i-1;j>=0;j--){
//	        	 System.out.println(val+" * "+nums[j]+"= "+(val * nums[j]));
	             val = (val * nums[j]);
	             if(val < k){
	                 counter++;
	             }else {
	            	    break;
	             }
	         }
	     }
	        return counter;
	    }
	    
	    public static void main(String args[]) {
	    	int[] arr = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
	    	 System.out.println("counter "+numSubarrayProductLessThanK(arr,19));
	    }
}
