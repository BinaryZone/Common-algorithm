package com.wh.datastucture.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ʮ����ת���ɶ�����(����ջ)
 * @author DELL
 *
 */
public class TestConvert {
	public static void main(String[] args) {
		//����һ��ʮ������
		int n = 13;
		//����������
		int t = n;
		//String str = "";	
		Deque stack = new LinkedList();
		//ת��
		do {
			
			//ȷ������2������
			int mod = t%2;
			//�������
			//System.out.println(mod);
			//str = mod + str;
			stack.push(mod);
			//ȷ����
			t = t/2;
		} while (t>0);//��>0
		
		//�����������
		System.out.print(n+"----->");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}
