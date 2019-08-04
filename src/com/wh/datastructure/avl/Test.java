package com.wh.datastructure.avl;

public class Test {
	public static void main(String[] args) {
//		int[] arr = {4,3,6,5,7,8};
		int[] arr = {10,11,7,6,8,9};
		AVLTree avlTree = new AVLTree();
		// 添加结点
		for(int i = 0;i < arr.length;i++) {
			avlTree.add(new TreeNode(arr[i]));
		}
		System.out.println("中序遍历");
		avlTree.inOrder();
		System.out.println("平衡处理后");
		System.out.println("树的高度：" + avlTree.getHeight());
		System.out.println("左子树的高度：" + avlTree.getLeftHeight());
		System.out.println("右子树的高度：" + avlTree.getRightHeight());
	}
}
