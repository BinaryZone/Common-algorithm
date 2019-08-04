package com.wh.datastructure.tree;
/**
 * 二叉树的节点
 * @author DELL
 *
 */
public class Node {
	Object value;//节点值
	Node leftChild;//左子树
	Node rightChild;//右子树
	
	public Node(Object value) {
		super();
		this.value = value;
	}

	public Node(Object value, Node leftChild, Node rightChild) {
		super();
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}
	
	
	
	
}
