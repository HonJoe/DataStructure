package com.sort;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={7,8,2,1,13,6,20,11};
		printArray(a);
		
		BubbleSort.sort(a);	
//		SelectSort.sort(a);
//		SelectSort.sort(a);
//		MergingSort.sort2(a);
//		QuitSort.sort(a);
		printArray(a);
	}
	
	public static void printArray(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
	}

}
