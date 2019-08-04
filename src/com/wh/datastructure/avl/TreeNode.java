package com.wh.datastructure.avl;


public class TreeNode {
	int value;
	TreeNode leftChild;
	TreeNode rightChild;
	public TreeNode(int value, TreeNode leftChild, TreeNode rightChild) {
		super();
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	public TreeNode(int value) {
		super();
		this.value = value;
	}
	@Override
	public String toString() {
		return "TreeNode [value=" + value + "]";
	}
}
