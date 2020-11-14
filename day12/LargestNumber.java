package day12;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static String largestNumber(int[] nums) {
		if(nums.length==0) return "0";
		String[] nums1 = new String[nums.length];
		for(int i=0;i<nums.length;i++) {
			nums1[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(nums1,new Comparator<String>() {
			public int compare(String a, String b) {
				String o1 = a+b;
				String o2 = b+a;
				return o2.compareTo(o1);
			}
		});
		if(nums1[0].equals("0")) return "0";
		StringBuilder builder = new StringBuilder();
		for(String num:nums1) {
			builder.append(num);
		}
		return builder.toString();
	}
	
	public static void main(String args[]) {
		int[] arr = {1,2,3,4,5};
		System.out.println(largestNumber(arr));
	}
}
