package com.wh.datastructure.sort;
/**
 * √∞≈›≈≈–Ú
 * T(n) = O(n**2)
 * S(n) = O(1)
 * Œ»∂®
 * @author DELL
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] array = {3,7,1,4,6,10,8,5,2,9};
		array = bubbleSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}
	public static int[] bubbleSort(int[] array) {
		if (array.length == 0) {
			return array;
		}
		for(int i = 0;i < array.length;i++) {
			for(int j = 0;j < array.length-i-1;j++) {
				if (array[j+1]<array[j]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}
}
