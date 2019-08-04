package com.wh.datastructure.avl;

import com.wh.datastructure.avl.TreeNode;

public class AVLTree {
	private TreeNode root;
	// 添加结点
	public void add(TreeNode node) {
		if (root == null) {
			root = node;
		}else {
			add(root, node);
			// 左旋转
			if (getRightHeight()-getLeftHeight() > 1) {
				// 如果右子树的左子树的高度大于其右子树的高度，则需要进行双旋转
				if (root.rightChild != null && getHeight(root.rightChild.leftChild) > getHeight(root.rightChild.rightChild)) {
					// 对右子树进行右旋转
					rightRotate(root.rightChild);
					leftRotate();
				}else {
					leftRotate();
				}
				return;
			}
			if (getLeftHeight() - getRightHeight() > 1) {
				// 如果左子树的右子树的高度大于其左子树的高度
				if (root.leftChild != null && getHeight(root.leftChild.rightChild) > getHeight(root.leftChild.leftChild)) {
					// 对左子树进行左旋转
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
	// 中序遍历
	public void inOrder() {
		if (root != null) {
			inOrder(root);
		}else {
			System.out.println("二叉树为空，不能遍历");
		}
	}
	public void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.leftChild);
			System.out.print(root.value + " ");
			inOrder(root.rightChild);
		}
	}
	// 查找
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
	// 查找某结点的父结点
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
	// 找最小结点
	public int searchMin(TreeNode node) {
		TreeNode temp = node;
		while(temp.leftChild != null) {
			temp = temp.leftChild;
		}
		return temp.value;
	}
	// 求树的高度
	public int getHeight() {
		return getHeight(root);
	}
	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(root.leftChild == null?0:getHeight(root.leftChild), root.rightChild == null?0:getHeight(root.rightChild))+1;
	}
	// 求左子树的高度
	public int getLeftHeight() {
		if (root.leftChild == null) {
			return 0;
		}
		return getHeight(root.leftChild);
	}
	// 求右子树的高度
	public int getRightHeight() {
		if (root.rightChild == null) {
			return 0;
		}
		return getHeight(root.rightChild);
	}
	// 左旋转
	public void leftRotate() {
		leftRotate(root);
	}
	private void leftRotate(TreeNode root) {
		// 新建一个结点使其值与根节点的值相同
		TreeNode newNode = new TreeNode(root.value);
		// 使新结点的左子结点指向根结点的左子结点
		newNode.leftChild = root.leftChild;
		// 使新结点的右子结点指向根结点的右子树的左子结点
		newNode.rightChild = root.rightChild.leftChild;
		// 使根结点的值变为其右子结点的值
		root.value = root.rightChild.value;
		// 使根结点的左子结点指向新结点
		root.leftChild = newNode;
		// 使根结点的右子结点指向右子树的右子结点
		root.rightChild = root.rightChild.rightChild;
	}
	// 右旋转
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
