package com.wh.datastructure.avl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
//		int[] arr = {4,3,6,5,7,8};
		int[] arr = {10,11,7,6,8,9};
		AVLTree avlTree = new AVLTree();
		// ��ӽ��
		for(int i = 0;i < arr.length;i++) {
			avlTree.add(new TreeNode(arr[i]));
		}
		System.out.println("�������");
		avlTree.inOrder();
		System.out.println("ƽ�⴦���");
		System.out.println("���ĸ߶ȣ�" + avlTree.getHeight());
		System.out.println("�������ĸ߶ȣ�" + avlTree.getLeftHeight());
		System.out.println("�������ĸ߶ȣ�" + avlTree.getRightHeight());	
	}
}
