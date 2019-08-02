package com.wh.datastructure.sort;

import java.util.Arrays;

/**
 * 堆排序
 * T(n) = O(nlogn)
 * S(n) = O(1)
 * 稳定性：不稳定
 * @author DELL
 *
 */
public class HeapSort {
	static int len;
	public static int[] heapSort(int[] array) {
		len = array.length;
		if (len<1) return array;
		//1.创建一个最大堆
		buildMaxHeap(array);
		//2.循环将最大堆首位与末位交换，然后再调整最大堆
		while(len>0) {
			swap(array, 0, len-1);
			len--;
			adjustHeap(array, 0);
		}
		//3.返回排好序的数组
		return array;
	}
	
	/**
	 * 建立最大堆
	 * @param array
	 */
	public static void buildMaxHeap(int[] array) {
		//从最后一个非叶子节点开始向上构造最大堆
		for(int i = (len-2)/2;i>=0;i--) {
			adjustHeap(array,i);
		}
	}
	
	public static void adjustHeap(int[] array,int i) {
		int maxindex = i;
		//如果有左子树，且左子树大于父节点，则将最大指针指向左子树
		if (i*2+1<len && array[i*2+1]>array[maxindex]) {
			maxindex = 2*i+1;
		}
		
		//如果有右子树，且右子树大于父节点，则将最大指针指向右子树
		if (i*2+2<len && array[i*2+2]>array[maxindex] ) {
			maxindex = 2*i+2;
		}
		//如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置
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
