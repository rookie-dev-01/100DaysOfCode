package day13;

import java.util.ArrayList;
import java.util.List;

public class BinaryOperations {
/**
 * Binary operations deal with BITS - 0s and 1s 
 *  basic operations : 
 *  
 *   A & B - and
 *   A | B - or
 *   A ^ B - xor 
 *   !A    - not 
 *   
 *   A << k - left shift A by k digits. 
 * 	 A << k = A x (2^k)
 * 
 *   Example : A = 1 ; k = 4
 *   0001 << 4 = 10000 (A = 1 became A = 16 )  
 *   
 *   A >> k - right shift A by k digits.
 *   A >> k = A / (2^k) 
 *   
 *   Example : A = 10000 (16) ; k = 4
 *   100000 >> 4 = 1 (A = 16 became A = 1 )
 * 
 * 
 */
	
/** 
 *  Problem Statement : 
 *  There are N<=5000 workers. Each is available during some days of this month. 
 *  Find two workers with maximum intersection of their schedules.  
 *   ex: 
 *   w1 : {2,3,5,6,8}
 *   w2 : {2,4,5,8}
 *   w3 : {1,2,10,12,14,16}
 *   
 *   the intersection of w1 and w2 is : 3
 *   the intersection of w2 and w3 is : 1
 *   the intersection of w1 and w3 is : 1
 */
	
	public static void andOp() {
		
		List<Integer> wew = new ArrayList<>();
//		int[] as = new i[1];
//		as = wew.toArray(as);
		System.out.println(1 << 2);
		System.out.println(8 & (1 << 2));
		
	}
	
	public static int getTotalSetBits(int num) {
		int setBitCount = 0;
			for(int i=30;i>0;i--) {
				if((num & (1<<i))!=0) {
					setBitCount++;
				}
			}
			return setBitCount;
	}
	
	public static void printBits(int num) {
		for(int i=30;i>=0;i--) {
			if((num & (1<<i))!=0) {
				System.out.print("1");
			}else {
				System.out.print("0");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		andOp();
		
		int[][] workerDays = {{2,3,5,6,8},{2,4,5,8},{1,2,10,12,14,16}};
		int[] workerBits = new int[workerDays.length];
		
		for(int i=0;i<workerDays.length;i++) {
			int eachWorkerBit = 0;
			for(int j=0;j<workerDays[i].length;j++) {
				int workDay = workerDays[i][j];
				int bitToSet = (1 << workDay); // this will give us the bit to set ex : day 2 will give 100
				eachWorkerBit = (eachWorkerBit | bitToSet); // this will set the worker's day bit 
				printBits(eachWorkerBit);
			}
			workerBits[i] = eachWorkerBit;
		}
		
		int maxIntersection = 0;
		for(int i=0;i<workerBits.length;i++) {
			for(int j=i+1;j<workerBits.length;j++) {
				int workersInersection = (workerBits[i]&workerBits[j]);
				System.out.println("the intersection of worker "+i+" and worker "+j+" is "+workersInersection);
				maxIntersection = Math.max(maxIntersection, getTotalSetBits(workersInersection));
			}
		}
		System.out.println("the max intersection is "+maxIntersection);
	}
}
