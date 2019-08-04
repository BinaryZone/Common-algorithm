package com.wh.datastructure.bstree;

public class BSTree {
	private TreeNode root;
	// ��ӽ��
	public void add(TreeNode node) {
		if (root == null) {
			root = node;
		}else {
			root.add(node);
		}
	}
	// �������
	public void inOrder() {
		if (root != null) {
			root.inOrder();
		}else {
			System.out.println("������Ϊ�գ����ܱ���");
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
	// ɾ�����
	public void delNode(int key) {
		if (root == null) {
			return;
		}
		// �ҵ���ɾ���Ľ��
		TreeNode targetNode = search(key);
		if (targetNode == null) {
			return;
		}
		// ����ҵ�����ֻ�и����
		if (root.leftChild == null && root.rightChild == null) {
			root = null;
		}
		System.out.println(root);
		TreeNode parentNode = searchParent(key);
		// ���ɾ������Ҷ�ӽ��
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
		}else if (targetNode.leftChild != null && targetNode.rightChild != null) { // ���ɾ���Ľ������������
			int min = searchMin(targetNode.rightChild);
			delNode(min);
			targetNode.value = min;
		}else { // ���ɾ���Ľ��ֻ��һ������
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
	// ����С���
	public int searchMin(TreeNode node) {
		TreeNode temp = node;
		while(temp.leftChild != null) {
			temp = temp.leftChild;
		}
		return temp.value;
	}
}
