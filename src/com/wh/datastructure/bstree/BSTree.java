package com.wh.datastructure.bstree;

public class BSTree {
	private TreeNode root;
	// 添加结点
	public void add(TreeNode node) {
		if (root == null) {
			root = node;
		}else {
			root.add(node);
		}
	}
	// 中序遍历
	public void inOrder() {
		if (root != null) {
			root.inOrder();
		}else {
			System.out.println("二叉树为空，不能遍历");
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
	// 删除结点
	public void delNode(int key) {
		if (root == null) {
			return;
		}
		// 找到待删除的结点
		TreeNode targetNode = search(key);
		if (targetNode == null) {
			return;
		}
		// 如果找到并且只有根结点
		if (root.leftChild == null && root.rightChild == null) {
			root = null;
		}
		System.out.println(root);
		TreeNode parentNode = searchParent(key);
		// 如果删除的是叶子结点
		if (targetNode.leftChild == null && targetNode.rightChild == null) {
			if (parentNode != null) {
				if (parentNode.leftChild != null && parentNode.leftChild.value == key) {
					parentNode.leftChild = null;
				}else if (parentNode.rightChild != null && parentNode.rightChild.value == key) {
					parentNode.rightChild = null;
				}
			}else {
				targetNode = null;
			}			
		}else if (targetNode.leftChild != null && targetNode.rightChild != null) { // 如果删除的结点有两颗子树
			int min = searchMin(targetNode.rightChild);
			delNode(min);
			targetNode.value = min;
		}else { // 如果删除的结点只有一颗子树
			if (targetNode.leftChild != null) {
				if (parentNode != null) {
					if (parentNode.leftChild != null && parentNode.leftChild.value == key) {
						parentNode.leftChild = targetNode.leftChild;
					}else if (parentNode.rightChild != null && parentNode.rightChild.value == key) {
						parentNode.rightChild = targetNode.leftChild;
					}
				}else {
					root = targetNode.leftChild;
				}				
			}else {
				if (parentNode != null) {
					if (parentNode.leftChild != null && parentNode.leftChild.value == key) {
						parentNode.leftChild = targetNode.rightChild;
					}else if (parentNode.rightChild != null && parentNode.rightChild.value == key) {
						parentNode.rightChild = targetNode.rightChild;
					}
				}else {
					root = targetNode.rightChild;
				}				
			}
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
}
