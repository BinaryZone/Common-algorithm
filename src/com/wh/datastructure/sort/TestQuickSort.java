package com.wh.datastructure.sort;

import java.util.Arrays;

/**
 * ��������
 * T(n) = O(n**2)
 * S(n) = O(logn)
 * @author DELL
 *
 */
public class TestQuickSort {
	public static void main(String[] args) {
		//������������
		int arr[] = {72,6,57,88,60,42,83,73,48,85};
		
		//�����������
		System.out.println(Arrays.toString(arr));
		//��������
		quickSort(arr);
		
		//�����������
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		quickSort(arr,low,high);
		
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low<high) {
			//�����������������Ϊ���������������ط�����������
		int index = partition(arr,low,high);
		
		//���������������
		quickSort(arr, low, index-1);
		
		//���ҷ�����������
		quickSort(arr, index+1, high);
		}
		
		
	}

	private static int partition(int[] arr, int low, int high) {
		// ָ����ָ��i����ָ��j
		int i = low;
		int j = high;
		
		// ����һ��ֵ��Ϊ��׼ֵ���ڿ�
		int x = arr[low];
		
		// ʹ��ѭ��ʵ�ַ�������
		while(i<j) {
			//���������ƶ�j���ҵ���һ��С�ڻ�׼ֵ��ֵarr[j]
			while(arr[j]>=x && i<j) {
				j--;
			}
			//���Ҳ��ҵ�С�ڻ�׼����ֵ���뵽��ߵĿ�λ�ã���ָ�����м��ƶ�һ��λ��i++
			if (i<j) {
				arr[i] = arr[j];
				i++;
			}
			
			//���������ƶ�i���ҵ���һ�����ڵ��ڻ�׼ֵ��ֵarr[i]
			while(arr[i]<x && i<j) {
				i++;
			}
			
			//������ҵ��Ĵ��ڵ��ڻ�׼ֵ��ֵ���뵽�ұߵĿ��У���ָ�����м��ƶ�һ��λ�ã�j--
			if (i<j) {
				arr[j] = arr[i];
				j--;
			}
		}
		
		// ʹ�û�׼ֵ��ӣ�����ǻ�׼ֵ������λ��
		arr[i] = x; //arr[j] = y;
		
		//���ػ�׼ֵ��λ������
		return i;  //return j;
		
	}
}
