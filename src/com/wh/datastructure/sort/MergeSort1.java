package com.wh.datastructure.sort;

import java.util.Arrays;

// 归并排序非递归实现（自底向上）
public class MergeSort1 {
	public void mergeSort1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int k = 1;
		while(k < arr.length) {
			mergePass(arr, k);
			k = k*2;
		}
	}
	public void mergePass(int[] arr,int k) {
		int start = 0;
		while(start + 2*k - 1 < arr.length) {
			int mid = start + k -1;
			int high = start + 2*k - 1;
			merge(arr, start, mid, high);
			start = start + 2*k;
		}
		if (start + k - 1 < arr.length) {
			merge(arr, start, start + k - 1, arr.length - 1);
		}
	}
	public static void merge(int[] arr,int low,int mid,int high) {
		int[] temp = new int[high-low+1];
		int i = low;
		int j = mid+1;
		int m = 0;
		while(i <= mid && j<=high) {
			if (arr[i] <= arr[j]) {
				temp[m++] = arr[i++];
			}else {
				temp[m++] = arr[j++];
			}
		}
		while(i <= mid) {
			temp[m++] = arr[i++];
		}
		while(j <= high) {
			temp[m++] = arr[j++];
		}
		for(int k = 0;k < temp.length;k++) {
			arr[k+low] = temp[k];
		}
	}
	public static void main(String[] args) {
		int[] arr = {5,7,3,6,1,8,2,4,0};
		new MergeSort1().mergeSort1(arr);
		System.out.println(Arrays.toString(arr));
	}
}
