package com.wh.datastructure.sort;

import java.util.Arrays;

public class QuickSort {
	public static int[] quickSort(int[] arr) {
		if (arr.length == 0) {
			return arr;
		}
		//指定指针
		int low = 0;
		int high = arr.length-1;
		
		//进行快排
		quickSort(arr, low, high);
		return arr;
	}
	
	private static void quickSort(int[] arr,int low,int high) {
		if (low<high) {
			// 分区
		int mid = partition(arr,low,high);
		//对左半区进行快排
		quickSort(arr, low, mid-1);
		//对右半区进行快排
		quickSort(arr, mid+1, high);
		}
		
	}
	
	private static int partition(int[] arr,int low,int high) {
		//确定i,j指针
		int i = low;
		int j = high;
		//找定基准值并挖坑
		int x = arr[low];
		while(i<j) {
			//从右往左遍历数组，找到第一个小于基准值的数，填入坑中
			while(arr[j]>x && i<j) {
				j--;
			}
			arr[i] = arr[j];
			
			
			//从左往右遍历数组，找到第一个大于基准值的树，填入坑中
			while(arr[i]<x && i<j) {
				i++;
			}
			arr[j] = arr[i];
		}
		
		//使用基准值填坑
		arr[i] = x;
		
		return i;
	}
	
	public static void main(String[] args) {
		int[] array = {3,7,1,4,6,10,8,5,2,9};
		System.out.println(Arrays.toString(quickSort(array)));
		
	}
}
