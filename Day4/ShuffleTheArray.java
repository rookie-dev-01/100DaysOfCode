package Day4;


/**
 * https://leetcode.com/problems/shuffle-the-array/
 * @author amjain
 *
 */
public class ShuffleTheArray {
	
    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int j=n;
        int k=1;
        ans[0] = nums[0];
     for(int i=1;i<(2*n);i++){
         if(i%2 != 0){
             ans[i] = nums[j];
             j++;
        }else{
             ans[i] = nums[k];
             k++;
         }
    }
        return ans;
    }
    
    public static void main(String args[]) {
    	int[] nums = {2,5,1,3,4,7};
    	int n = 3;
    		shuffle(nums,n);
    }
    
    
}