package com.wh.datastructure.sort;

import java.util.Arrays;

/**
 * 2Â·¹é²¢ÅÅÐò
 * @author DELL
 *
 */
public class MergeSort {
	public static void mergeSort(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		split(arr, low, high);
	}
	public static void split(int[] arr,int low,int high) {
		if (low < high) {
			int mid = (low + high)/2;
			split(arr, low, mid);
			split(arr, mid+1, high);
			merge(arr, low, mid, high);
		}
	}
	public static void merge(int [] arr,int low,int mid,int high) {
		int[] temp = new int[high - low + 1];
		int k = 0;
		int i = low;
		int j = mid + 1;
		while(i <= mid && j <= high) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			}else {
				temp[k++] = arr[j++];
			}
		}
		while(i <= mid) {
			temp[k++] = arr[i++];
		}
		while(j <= high) {
			temp[k++] = arr[j++];
		}
		for(int l = low;l <= high;l++) {
			arr[l] = temp[l-low];
		}
	}
	public static void main(String[] args) {
		int[] arr = {14,12,15,13,11,16};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
