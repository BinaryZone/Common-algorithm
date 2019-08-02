package com.wh.datastructure.sort;

import java.util.Arrays;

/**
 * 直接插入排序
 * T(n) = O(n**2)
 * S(n) = O(1)
 * @author DELL
 *
 */
public class TestInsertionSort {
	public static void main(String[] args) {
		//给出乱序数组
		int arr[] = {72,6,57,88,60,42,83,73,48,85};
		
		//输出乱序数组
		System.out.println(Arrays.toString(arr));
		
		//直接插入排序
		int[] arr1 = insertionSort(arr);
		
		
		//输出排好序的数组
		System.out.println(Arrays.toString(arr1));
		
	}

	private static int[] insertionSort(int[] arr) {
		if (arr.length == 0) {
			return arr;
		}
		int current;
		
		for(int i = 0;i<arr.length-1;i++) {
			current = arr[i+1];
			int preindex = i;
			while(preindex>=0 && current < arr[preindex]) {
				arr[preindex+1] = arr[preindex];
				preindex--;
				}
			arr[preindex+1] = current;
		}
		return arr;
	}
}
