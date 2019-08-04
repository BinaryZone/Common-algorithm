package com.wh.datastructure.bstree;

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
	// 添加结点方法
	public void add(TreeNode node) {
		if (node == null) {
			return;
		}
		if (node.value < this.value) {
			if (this.leftChild == null) {
				this.leftChild = node;
			}else {
				this.leftChild.add(node);
			}
		}else {
			if (this.rightChild == null) {
				this.rightChild = node;
			}else {
				this.rightChild.add(node);
			}
		}
	}
	@Override
	public String toString() {
		return "TreeNode [value=" + value + "]";
	}
	// 中序遍历
	public void inOrder() {
		if (this.leftChild != null) {
			this.leftChild.inOrder();
		}
		System.out.print(this + " ");
		if (this.rightChild != null) {
			this.rightChild.inOrder();
		}
	}
}
