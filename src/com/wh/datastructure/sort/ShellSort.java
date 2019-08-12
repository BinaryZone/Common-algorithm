package com.wh.datastructure.sort;

import java.util.Arrays;

public class ShellSort {
	public static void shellSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int gap = arr.length / 2;
		while(gap > 0) {
			for(int i = gap;i < arr.length;i++) {
				int current = arr[i];
				int preIndex = i - gap;
				while(preIndex >= 0 && current < arr[preIndex]) {
					arr[preIndex+gap] = arr[preIndex];
					preIndex -= gap;
				}
				arr[preIndex+gap] = current;
			}
			gap /= 2;
		}
	}
	public static void main(String[] args) {
		int arr[] = {72,6,57,88,60,42,83,73,48,85};
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
