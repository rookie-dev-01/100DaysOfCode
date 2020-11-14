package day11;

import java.util.Scanner;

public class ArrayElement {
	public static void main(String[] args) {
		int [] Array = new int[10];
		int index;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 10 elements:");
		for (int i = 0; i<10; i++){
			Array[i] = input.nextInt();
		}
		System.out.print("Enter an index you want to retrieve: ");
		index = input.nextInt();
		
		System.out.print("Element at index "+index+" is "+Array[index]);
	}
}
