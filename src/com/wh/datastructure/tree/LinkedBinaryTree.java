package com.wh.datastructure.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedBinaryTree implements BinaryTree{
	private Node root;
	
	
	
	public LinkedBinaryTree() {
		super();
	}
	
	
	public LinkedBinaryTree(Node root) {
		super();
		this.root = root;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return root==null;
	}

	//返回节点数量
	public int size() {
		System.out.println("二叉树节点的数量是：");
		return this.size(root);
	}
	
	private int size(Node node) {
		if (node == null) {
			return 0;
		}else {
			//计算左子树的高度
			int al = this.size(node.leftChild);
			
			//计算右子树的高度
			int ar = this.size(node.rightChild);
			
			//取左子树和右子树高度的最大值+1
			return al + ar +1;
		}
	}

	@Override
	public int getheight() {
		System.out.println("二叉树的高度为：");
		return this.getheight(root);
	}
	
	private int getheight(Node node) {
		if (node==null) {
			return 0;
		}else {
			//计算左子树的高度
			int al = this.getheight(node.leftChild);
			
			//计算右子树的高度
			int ar = this.getheight(node.rightChild);
			
			//取左子树和右子树高度的最大值+1
			return al > ar ? al+1:ar+1;
		}
	}

	@Override
	public Node findKey(int value) {
		return this.findKey(value, root);
	}
	
	private Node findKey(Object value,Node root) {
		if (root==null) {//递归结束条件1：节点为空，可能是整个树的根节点，也可能是递归调用中叶子节点中的左孩子和右孩子
			return null;
		}else if (root!=null && root.value == value) {//递归结束的条件2：找到了
			return root;
		}else {//递归体
			Node node1 = this.findKey(value, root.leftChild);
			Node node2 = this.findKey(value, root.rightChild);
			if (node1 != null && node1.value == value) {
				return node1;
			}else if (node2 != null && node2.value == value) {
				return node2;
			}else {
				return null;
			}
		}
	}
	
	
	//先序遍历
	public void preOrderTraverse() {
		//输出根节点的值
		if (root!=null) {
			System.out.print(root.value+" ");
			//对左子树进行先序遍历
			BinaryTree leftTree = new LinkedBinaryTree(root.leftChild);
			leftTree.preOrderTraverse();
			
			//对右子树进行先序遍历
			BinaryTree rightTree = new LinkedBinaryTree(root.rightChild);
			rightTree.preOrderTraverse();
		}	
	}

	//中序遍历
	public void midOrderTraverse() {
		System.out.println("中序遍历");
		this.midOrderTraverse(root);
		System.out.println();
	}
	
	private void midOrderTraverse(Node root) {
		if (root!=null) {
			//对左子树进行中序遍历
		this.midOrderTraverse(root.leftChild);
		
		//输出根节点的值
		System.out.print(root.value+" ");
		
		//对右子树进行中序遍历
		this.midOrderTraverse(root.rightChild);
		}
		
	}

	
	//后序遍历
	public void postOrderTraverse() {
		System.out.println("后序遍历");
		this.postOrderTraverse(root);
		System.out.println();
	}
	
	private void postOrderTraverse(Node node) {
		if (node!=null) {
			//对左子树进行后序遍历
		this.postOrderTraverse(node.leftChild);
		
		//对右子树进行后序遍历
		this.postOrderTraverse(node.rightChild);
		
		//输出根节点的值
		System.out.print(node.value+" ");
		}
	}

	//中序遍历（借助栈）
	public void inOrderByStack() {
		System.out.println("利用栈进行中序遍历");
		//创建栈
		Deque<Node> stack = new LinkedList<>();
		Node current = root;
		while(root != null || !stack.isEmpty()) {
			while(current != null) {
				stack.push(current);
				current = current.leftChild;
			}
			
			if (!stack.isEmpty()) {
				current = stack.pop();
				System.out.print(current.value + " ");
				current = current.rightChild;
			}
		}
		System.out.println();
	}

	@Override
	public void preOrderByStack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postOrderByStack() {
		// TODO Auto-generated method stub
		
	}

	//按照层次进行遍历
	public void levelOrderByStack() {
		System.out.println("按照层次遍历二叉树");
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList();
		queue.add(root);
		while(queue.size()!=0) {
			int len = queue.size();
			for(int i=0;i<len;i++) {
				Node temp = queue.poll();
				System.out.print(temp.value+" ");
				if (temp.leftChild != null) {
					queue.add(temp.leftChild);
				}
				if (temp.rightChild != null) {
					queue.add(temp.rightChild);
				}
			}
		}
		System.out.println();
	}
	
	//测试代码：中序遍历
	public void midOrder(Node root) {
		if (root != null) {
			//对左子树进行中序遍历
			midOrder(root.leftChild);
			
			//输出根结点的值
			System.out.println(root.value);
			
			//对右子树进行中序遍历
			midOrder(root.rightChild);
		}
	}
	
	public void test() {
		//非递归后序遍历
		//创建栈
		Deque<Node> stack = new LinkedList<>();
		Node rNode = null;
		Node current = root;
		while(current != null || !stack.isEmpty()) {
			while(current != null) {
				stack.push(current);
				current = current.leftChild;
			}
			current = stack.pop();
			while(current != null && (current.rightChild == null || current.rightChild == rNode)) {
				System.out.print(current.value + "");
				rNode = current;
				if (stack.isEmpty()) {
					System.out.println();
					return;
				}
				current = stack.pop();
			}
			stack.push(current);
			current = current.rightChild;
		}
	}
}
