package com.wh.datastructure.sort;

public class BubbleSort2 {
	public static void bubbleSort2(int[] arr) {	
		if (arr == null || arr.length == 0) {
			return;
		}
		boolean flag;
		for(int i = 0;i < arr.length;i++) {
			flag = false;
			for(int j = 0;j < arr.length - i - 1;j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = true;
				}			
			}
			if (!flag) {
				break;
			}
		}
	}
	public static void main(String[] args) {
		int[] array = {3,7,1,4,6,10,8,5,2,9};
		bubbleSort2(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
