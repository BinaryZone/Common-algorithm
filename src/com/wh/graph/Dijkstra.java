package com.wh.graph;

import java.util.Arrays;

public class Dijkstra {
	public void dijkstra(Graph graph,int v) {
		int n = graph.getSize();
		// �����㵽���������̾���
		int[] minPath = new int[n];
		// �������ǰ���ڵ��±�
		int[] preNode = new int[n];
		// �Ƿ����ҵ���ʼ���㵽����������·����0��ʾδ�ҵ���1��ʾ���ҵ���
		int[] finded = new int[n];
		for(int i = 0;i < n;i++) {
			finded[i] = 0;
			minPath[i] = graph.getWeight(v, i);
			preNode[i] = 0;
		}
		minPath[v] = 0;
		finded[v] = 1;
		int k = 0;
		int min = 10000;
		for(int i = 1;i < n;i++) {
			// ����Ϊ�˷�����10000��ʾ�����
			min = 10000;
			// ��δ�ҳ���С·���Ľ�����ҳ�·����С�Ľ�㣬������Ϊ��ʼ��㣬���в���������ҳ����·����
			for(int j = 0;j < n;j++) {
				if (finded[j] == 0 && minPath[j] < min) {
					k = j;
					min = minPath[j];
				}
			}
			// �����k���Ϊ���ҵ�
			finded[k] = 1;
			for(int j = 0;j < n;j++) {
				if (finded[j] == 0 && (min+graph.getWeight(k, j)) < minPath[j]) {
					minPath[j] = min+graph.getWeight(k, j);
					preNode[j] = k;
				}
			}
		}
		System.out.println(Arrays.toString(minPath));
	}
}
