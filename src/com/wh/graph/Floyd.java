package com.wh.graph;

import java.util.Arrays;

public class Floyd {
	public void floyd(Graph graph) {
		int n = graph.getSize();
		// ���·�����Ⱦ���
		int[][] minPath = new int[n][n];
		// ���·��ǰ��������
		int[][] preNode = new int[n][n];
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < n;j++) {
				minPath[i][j] = graph.getWeight(i, j);
				preNode[i][j] = j;
			}
		}
		for(int k = 0;k < n;k++) {
			for(int i = 0;i < n;i++) {
				for(int j = 0;j < n;j++) {
					if (minPath[i][j] > minPath[i][k] + minPath[k][j]) {
						minPath[i][j] = minPath[i][k] + minPath[k][j];
						preNode[i][j] = k;
					}
				}
			}
		}
		System.out.println("���·������");
		for(int[] link:minPath) {
			System.out.println(Arrays.toString(link));
		}
		System.out.println("���·��ǰ��������");
		for(int[] link:preNode) {
			System.out.println(Arrays.toString(link));
		}
	}
}
