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

	//���ؽڵ�����
	public int size() {
		System.out.println("�������ڵ�������ǣ�");
		return this.size(root);
	}
	
	private int size(Node node) {
		if (node == null) {
			return 0;
		}else {
			//�����������ĸ߶�
			int al = this.size(node.leftChild);
			
			//�����������ĸ߶�
			int ar = this.size(node.rightChild);
			
			//ȡ���������������߶ȵ����ֵ+1
			return al + ar +1;
		}
	}

	@Override
	public int getheight() {
		System.out.println("�������ĸ߶�Ϊ��");
		return this.getheight(root);
	}
	
	private int getheight(Node node) {
		if (node==null) {
			return 0;
		}else {
			//�����������ĸ߶�
			int al = this.getheight(node.leftChild);
			
			//�����������ĸ߶�
			int ar = this.getheight(node.rightChild);
			
			//ȡ���������������߶ȵ����ֵ+1
			return al > ar ? al+1:ar+1;
		}
	}

	@Override
	public Node findKey(int value) {
		return this.findKey(value, root);
	}
	
	private Node findKey(Object value,Node root) {
		if (root==null) {//�ݹ��������1���ڵ�Ϊ�գ��������������ĸ��ڵ㣬Ҳ�����ǵݹ������Ҷ�ӽڵ��е����Ӻ��Һ���
			return null;
		}else if (root!=null && root.value == value) {//�ݹ����������2���ҵ���
			return root;
		}else {//�ݹ���
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
	
	
	//�������
	public void preOrderTraverse() {
		//������ڵ��ֵ
		if (root!=null) {
			System.out.print(root.value+" ");
			//�������������������
			BinaryTree leftTree = new LinkedBinaryTree(root.leftChild);
			leftTree.preOrderTraverse();
			
			//�������������������
			BinaryTree rightTree = new LinkedBinaryTree(root.rightChild);
			rightTree.preOrderTraverse();
		}	
	}

	//�������
	public void midOrderTraverse() {
		System.out.println("�������");
		this.midOrderTraverse(root);
		System.out.println();
	}
	
	private void midOrderTraverse(Node root) {
		if (root!=null) {
			//�������������������
		this.midOrderTraverse(root.leftChild);
		
		//������ڵ��ֵ
		System.out.print(root.value+" ");
		
		//�������������������
		this.midOrderTraverse(root.rightChild);
		}
		
	}

	
	//�������
	public void postOrderTraverse() {
		System.out.println("�������");
		this.postOrderTraverse(root);
		System.out.println();
	}
	
	private void postOrderTraverse(Node node) {
		if (node!=null) {
			//�����������к������
		this.postOrderTraverse(node.leftChild);
		
		//�����������к������
		this.postOrderTraverse(node.rightChild);
		
		//������ڵ��ֵ
		System.out.print(node.value+" ");
		}
	}

	//�������������ջ��
	public void inOrderByStack() {
		System.out.println("����ջ�����������");
		//����ջ
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

	//���ղ�ν��б���
	public void levelOrderByStack() {
		System.out.println("���ղ�α���������");
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
	
	//���Դ��룺�������
	public void midOrder(Node root) {
		if (root != null) {
			//�������������������
			midOrder(root.leftChild);
			
			//���������ֵ
			System.out.println(root.value);
			
			//�������������������
			midOrder(root.rightChild);
		}
	}
	
	public void test() {
		//�ǵݹ�������
		//����ջ
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
