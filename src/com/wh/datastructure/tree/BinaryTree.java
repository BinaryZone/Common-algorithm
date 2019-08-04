package com.wh.datastructure.tree;
/**
 * 二叉树的接口
 * @author DELL
 *
 */
public interface BinaryTree {
		//是否是空树
		public boolean isEmpty();
		//树的结点的个数
		public int size();
		//获取输的高度
		public int getheight();
		//查询指定值的结点
		public Node findKey(int value);
		//前序遍历二叉树
		public void preOrderTraverse();	
		//中序遍历二叉树
		public void midOrderTraverse();
		//后序遍历二叉树
		public void postOrderTraverse();	
		//求二叉树中叶子结点的个数
		public void inOrderByStack();
		//中序遍历非递归
		public void preOrderByStack();
		//后序遍历非递归
		public void postOrderByStack();
		//按照层次遍历二叉树
		public void levelOrderByStack();
		//测试
		public void test();

}
