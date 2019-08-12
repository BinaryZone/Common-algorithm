package com.wh.datastructure.sort;

import java.util.Arrays;

/**
 * ѡ������
 * T(n) = O(n**2)
 * S(n) = O(1)
 * �ȶ��ԣ����ȶ�
 * @author DELL
 *
 */
public class SelectionSort {
	public static int[] selectionSort(int[] array) {
		for(int i = 0;i < array.length;i++) {
			//ָ����СԪ��ָ��
			int minindex = i;
			//������СԪ��ָ��
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
