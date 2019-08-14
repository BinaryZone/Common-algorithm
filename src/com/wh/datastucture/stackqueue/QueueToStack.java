package com.wh.datastucture.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
	//利用两个队列实现一个栈
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	public void push(int data) {
		if (q1.isEmpty() && q2.isEmpty()) {
			q1.add(data);
		}
		if (q1.isEmpty()) {
			q2.add(data);
		}
		if (q2.isEmpty()) {
			q1.add(data);
		}
	}
	public int pop() {
		if (q1.isEmpty() && q2.isEmpty()) {
			throw new RuntimeException("栈为空！");
		}
		if (q1.isEmpty()) {
			while(q2.size() > 1) {
				q1.add(q2.poll());
			}
			return q2.poll();
		}else {
			while(q1.size() > 1) {
				q2.add(q1.poll());
			}
			return q1.poll();
		}
	}
}
