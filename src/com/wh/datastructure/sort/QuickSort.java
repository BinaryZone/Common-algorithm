package com.wh.datastructure.sort;

import java.util.Arrays;

public class QuickSort {
	public static int[] quickSort(int[] arr) {
		if (arr.length == 0) {
			return arr;
		}
		//ָ��ָ��
		int low = 0;
		int high = arr.length-1;
		
		//���п���
		quickSort(arr, low, high);
		return arr;
	}
	
	private static void quickSort(int[] arr,int low,int high) {
		if (low<high) {
			// ����
		int mid = partition(arr,low,high);
		//����������п���
		quickSort(arr, low, mid-1);
		//���Ұ������п���
		quickSort(arr, mid+1, high);
		}
		
	}
	
	private static int partition(int[] arr,int low,int high) {
		//ȷ��i,jָ��
		int i = low;
		int j = high;
		//�Ҷ���׼ֵ���ڿ�
		int x = arr[low];
		while(i<j) {
			//��������������飬�ҵ���һ��С�ڻ�׼ֵ�������������
			while(arr[j]>x && i<j) {
				j--;
			}
			arr[i] = arr[j];
			
			
			//�������ұ������飬�ҵ���һ�����ڻ�׼ֵ�������������
			while(arr[i]<x && i<j) {
				i++;
			}
			arr[j] = arr[i];
		}
		
		//ʹ�û�׼ֵ���
		arr[i] = x;
		
		return i;
	}
	
	public static void main(String[] args) {
		int[] array = {3,7,1,4,6,10,8,5,2,9};
		System.out.println(Arrays.toString(quickSort(array)));
		
	}
}
