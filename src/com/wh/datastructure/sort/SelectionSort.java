package com.wh.datastructure.sort;

import java.util.Arrays;

/**
 * 选择排序
 * T(n) = O(n**2)
 * S(n) = O(1)
 * 稳定性：不稳定
 * @author DELL
 *
 */
public class SelectionSort {
	public static int[] selectionSort(int[] array) {
		for(int i = 0;i < array.length;i++) {
			//指定最小元素指针
			int minindex = i;
			//调整最小元素指针
			for(int j=i+1;j<array.length;j++) {
				if (array[j]<array[minindex]) {
					minindex = j;
				}
			}
			int temp = array[i];
			array[i] = array[minindex];
			array[minindex] = temp;
		}
		return array;
	}
	
	public static void main(String[] args) {
		int arr[] = {72,6,57,88,60,42,83,73,48,85};
		System.out.println(Arrays.toString(arr));	
	}
}
