package com.wh.datastructure.tree;
/**
 * �������Ľӿ�
 * @author DELL
 *
 */
public interface BinaryTree {
		//�Ƿ��ǿ���
		public boolean isEmpty();
		//���Ľ��ĸ���
		public int size();
		//��ȡ��ĸ߶�
		public int getheight();
		//��ѯָ��ֵ�Ľ��
		public Node findKey(int value);
		//ǰ�����������
		public void preOrderTraverse();	
		//�������������
		public void midOrderTraverse();
		//�������������
		public void postOrderTraverse();	
		//���������Ҷ�ӽ��ĸ���
		public void inOrderByStack();
		//��������ǵݹ�
		public void preOrderByStack();
		//��������ǵݹ�
		public void postOrderByStack();
		//���ղ�α���������
		public void levelOrderByStack();
		//����
		public void test();

}
