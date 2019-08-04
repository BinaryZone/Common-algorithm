package com.wh.datastructure.bstree;

public class Test {
	public static void main(String[] args) {
		int[] arr = {62,58,88,47,73,99,35,51,93,37};
		BSTree bsTree = new BSTree();
		for(int i = 0;i < arr.length;i++) {
			bsTree.add(new TreeNode(arr[i]));
		}
		bsTree.inOrder();
		System.out.println();
//		System.out.println(bsTree.search(1));
//		System.out.println(bsTree.searchParent(73));
		bsTree.delNode(62);
		bsTree.delNode(58);
		bsTree.delNode(88);
		bsTree.delNode(47);
		bsTree.delNode(73);
		bsTree.delNode(99);
		bsTree.delNode(35);
		bsTree.delNode(51);
		bsTree.delNode(93);
		bsTree.delNode(37);
		bsTree.inOrder();

	}
}
