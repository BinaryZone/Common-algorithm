package com.wh.datastructure.sort;

import java.util.Arrays;

/**
 * ������
 * T(n) = O(nlogn)
 * S(n) = O(1)
 * �ȶ��ԣ����ȶ�
 * @author DELL
 *
 */
public class HeapSort {
	static int len;
	public static int[] heapSort(int[] array) {
		len = array.length;
		if (len<1) return array;
		//1.����һ������
		buildMaxHeap(array);
		//2.ѭ����������λ��ĩλ������Ȼ���ٵ�������
		while(len>0) {
			swap(array, 0, len-1);
			len--;
			adjustHeap(array, 0);
		}
		//3.�����ź��������
		return array;
	}
	
	/**
	 * ��������
	 * @param array
	 */
	public static void buildMaxHeap(int[] array) {
		//�����һ����Ҷ�ӽڵ㿪ʼ���Ϲ�������
		for(int i = (len-2)/2;i>=0;i--) {
			adjustHeap(array,i);
		}
	}
	
	public static void adjustHeap(int[] array,int i) {
		int maxindex = i;
		//������������������������ڸ��ڵ㣬�����ָ��ָ��������
		if (i*2+1<len && array[i*2+1]>array[maxindex]) {
			maxindex = 2*i+1;
		}
		
		//������������������������ڸ��ڵ㣬�����ָ��ָ��������
		if (i*2+2<len && array[i*2+2]>array[maxindex] ) {
			maxindex = 2*i+2;
		}
		//������ڵ㲻�����ֵ���򽫸��ڵ������ֵ���������ҵݹ�����븸�ڵ㽻����λ��
		if (maxindex != i) {
			swap(array,maxindex,i);
			adjustHeap(array, maxindex);
		}
		
	}
	
	public static void swap(int[] arr,int a,int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public static void main(String[] args) {
		int[] arr = {5,3,6,1,4,7,9};
		heapSort(arr);
		System.out.println(Arrays.toString(heapSort(arr)));
	}
}
