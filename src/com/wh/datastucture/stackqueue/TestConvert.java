package com.wh.datastucture.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 十进制转化成二进制(利用栈)
 * @author DELL
 *
 */
public class TestConvert {
	public static void main(String[] args) {
		//给定一个十进制数
		int n = 13;
		//给定被除数
		int t = n;
		//String str = "";	
		Deque stack = new LinkedList();
		//转换
		do {
			
			//确定除以2的余数
			int mod = t%2;
			//输出余数
			//System.out.println(mod);
			//str = mod + str;
			stack.push(mod);
			//确定商
			t = t/2;
		} while (t>0);//商>0
		
		//输出二进制数
		System.out.print(n+"----->");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}
