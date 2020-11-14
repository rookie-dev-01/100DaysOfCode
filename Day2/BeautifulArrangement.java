package Day2;

/**
 * https://leetcode.com/problems/beautiful-arrangement-ii/
 * @author amjain
 */

public class BeautifulArrangement {
    public static int[] constructArray(int n, int k) {

        int num = 1;
        int[] arr = new int[n];
        int distVal = 0;
        for(int i=0;i<n;i++){
            if(k>1 && i%2!=0 && (k>2?(distVal<k-2):(distVal<1))){
                arr[i] = n-distVal; distVal++;
            }else{
                arr[i] = num; num++;
            }
        }
        return arr;
    }
    
	public static void main(String args[]) {
		int n=7;
		int k=3;
		int[] arr = constructArray(n,k);
		System.out.print("[ ");
		for(int aa:arr) {
			System.out.print(aa+" ,");
		}
		System.out.print("]");
	}
}