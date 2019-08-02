package com.wh.datastructure.search;
/**
 * ǰ�᣺˳��ṹ�����չؼ�������
 * @author DELL
 *
 */
public class BinarySearch {
	/**
	 * ��ʹ�õݹ�
	 * T(n) = O(logn)
	 * S(n) = O(1)
	 * @param array
	 * @param key
	 * @return
	 */
	public static int binarySearch(int [] array,int key) {
		//����low��high
		int low = 0;
		int high = array.length-1;
		while(low<=high) {
			//���mid
			int mid = (low+high)/2;
			//��������жԱ�
			if (array[mid]==key) {
				return mid;
			}else if (array[mid]>key) {
				high = mid-1;
			}else {
				low = mid + 1;
			}
		}
		
		return -1;	
	}
	/**
	 * ʹ�õݹ�
	 * T(n) = O(logn)
	 * S(n) = O(logn)
	 * @param array
	 * @param key
	 * @return
	 */
	public static int binarySearch1(int [] array,int key) {
		//����low��high
		int low = 0;
		int high = array.length - 1;
		return binarySearch1(array, key, low, high);
		}
	
	public static int binarySearch1(int [] array,int key,int low,int high) {
		//�ݹ��������
		if(low>high) {
			return -1;
		}
		int mid = (low+high)/2;
		if(array[mid] == key) {
			return mid;
		}else if (array[mid] > key) {
			return binarySearch1(array, key, low, mid-1);
		}else {
			return binarySearch1(array, key, mid+1, high);
		}
	}
}
