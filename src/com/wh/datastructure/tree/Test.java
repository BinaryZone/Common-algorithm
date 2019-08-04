package com.wh.datastructure.tree;

public class Test {
	public static void main(String[] args) {
		//����һ��������
		Node node5 = new Node(5, null, null);
		Node node4 = new Node(4, null, node5);
		Node node7 = new Node(7, null, null);
		Node node6 = new Node(6, null, node7);
		Node node3 = new Node(3, null, null);
		Node node2 = new Node(2, node3, node6);
		Node node1 = new Node(1, node4, node2);
		
		BinaryTree btree = new LinkedBinaryTree(node1);
		//BinaryTree btree = new LinkedBinaryTree();
		
		//�ж϶������Ƿ�Ϊ��
		System.out.println(btree.isEmpty());
		
		//��������ݹ� 1452367
		System.out.println("�������");
		btree.preOrderTraverse();
		System.out.println();
		
		//��������ݹ� 4513267
		btree.midOrderTraverse();
		
		//��������ݹ� 5437621
		btree.postOrderTraverse();
		
		//��������ǵݹ飨����ջ��
		btree.inOrderByStack();
		
		btree.test();
		
		//���ղ�α������������У� 1425367
		btree.levelOrderByStack();
		
		//�ڶ������в���ĳ��ֵ
		System.out.println(btree.findKey(1));
		
		//�������ĸ߶�
		System.out.println(btree.getheight());
		
		//�������Ľڵ�����
		System.out.println(btree.size());
		
		btree.test();
	}
}
