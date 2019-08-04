package com.wh.datastructure.avl;

import com.wh.datastructure.avl.TreeNode;

public class AVLTree {
	private TreeNode root;
	// ��ӽ��
	public void add(TreeNode node) {
		if (root == null) {
			root = node;
		}else {
			add(root, node);
			// ����ת
			if (getRightHeight()-getLeftHeight() > 1) {
				// ������������������ĸ߶ȴ������������ĸ߶ȣ�����Ҫ����˫��ת
				if (root.rightChild != null && getHeight(root.rightChild.leftChild) > getHeight(root.rightChild.rightChild)) {
					// ����������������ת
					rightRotate(root.rightChild);
					leftRotate();
				}else {
					leftRotate();
				}
				return;
			}
			if (getLeftHeight() - getRightHeight() > 1) {
				// ������������������ĸ߶ȴ������������ĸ߶�
				if (root.leftChild != null && getHeight(root.leftChild.rightChild) > getHeight(root.leftChild.leftChild)) {
					// ����������������ת
					leftRotate(root.leftChild);
					rightRotate();
				}else {
					leftRotate();
				}
			}
		}
	}
	private void add(TreeNode root,TreeNode node) {
		if (node.value < root.value) {
			if (root.leftChild == null) {
				root.leftChild = node;
			}else {
				add(root.leftChild, node);
			}
		}else {
			if (root.rightChild == null) {
				root.rightChild = node;
			}else {
				add(root.rightChild, node);
			}
		}
	}
	// �������
	public void inOrder() {
		if (root != null) {
			inOrder(root);
		}else {
			System.out.println("������Ϊ�գ����ܱ���");
		}
	}
	public void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.leftChild);
			System.out.print(root.value + " ");
			inOrder(root.rightChild);
		}
	}
	// ����
	public TreeNode search(int key) {
		return search(root, key);
	}
	private TreeNode search(TreeNode root,int key) {
		if (root == null) {
			return null;
		}
		if (root.value == key) {
			return root;
		}else if (root.value > key) {
			return search(root.leftChild, key);
		}else {
			return search(root.rightChild, key);
		}
	}
	// ����ĳ���ĸ����
	public TreeNode searchParent(int key) {
		return searchParent(root, key);
	}
	private TreeNode searchParent(TreeNode root,int key) {
		if (root == null || root.value == key) {
			return null;
		}
		if (root.leftChild != null && root.leftChild.value == key ||
				root.rightChild != null && root.rightChild.value == key) {
			return root;
		}else if (root.value > key) {
			return searchParent(root.leftChild, key);
		}else {
			return searchParent(root.rightChild, key);
		}
	}
	// ����С���
	public int searchMin(TreeNode node) {
		TreeNode temp = node;
		while(temp.leftChild != null) {
			temp = temp.leftChild;
		}
		return temp.value;
	}
	// �����ĸ߶�
	public int getHeight() {
		return getHeight(root);
	}
	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(root.leftChild == null?0:getHeight(root.leftChild), root.rightChild == null?0:getHeight(root.rightChild))+1;
	}
	// ���������ĸ߶�
	public int getLeftHeight() {
		if (root.leftChild == null) {
			return 0;
		}
		return getHeight(root.leftChild);
	}
	// ���������ĸ߶�
	public int getRightHeight() {
		if (root.rightChild == null) {
			return 0;
		}
		return getHeight(root.rightChild);
	}
	// ����ת
	public void leftRotate() {
		leftRotate(root);
	}
	private void leftRotate(TreeNode root) {
		// �½�һ�����ʹ��ֵ����ڵ��ֵ��ͬ
		TreeNode newNode = new TreeNode(root.value);
		// ʹ�½������ӽ��ָ����������ӽ��
		newNode.leftChild = root.leftChild;
		// ʹ�½������ӽ��ָ������������������ӽ��
		newNode.rightChild = root.rightChild.leftChild;
		// ʹ������ֵ��Ϊ�����ӽ���ֵ
		root.value = root.rightChild.value;
		// ʹ���������ӽ��ָ���½��
		root.leftChild = newNode;
		// ʹ���������ӽ��ָ�������������ӽ��
		root.rightChild = root.rightChild.rightChild;
	}
	// ����ת
	public void rightRotate() {
		rightRotate(root);
	}
	private void rightRotate(TreeNode root) {
		TreeNode newNode = new TreeNode(root.value);
		newNode.rightChild = root.rightChild;
		newNode.leftChild = root.leftChild.rightChild;
		root.value = root.leftChild.value;
		root.leftChild = root.leftChild.leftChild;
		root.rightChild = newNode;
	}
}
