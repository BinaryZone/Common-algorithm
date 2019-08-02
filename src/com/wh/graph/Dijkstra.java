package com.wh.graph;

import java.util.Arrays;

public class Dijkstra {
	public void dijkstra(Graph graph,int v) {
		int n = graph.getSize();
		// 出发点到各顶点的最短距离
		int[] minPath = new int[n];
		// 各顶点的前驱节点下标
		int[] preNode = new int[n];
		// 是否已找到初始顶点到各顶点的最短路径，0表示未找到，1表示已找到。
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
			// 这里为了方便用10000表示无穷大
			min = 10000;
			// 在未找出最小路径的结点中找出路径最小的结点，将其作为初始结点，进行层序遍历，找出最短路径。
			for(int j = 0;j < n;j++) {
				if (finded[j] == 0 && minPath[j] < min) {
					k = j;
					min = minPath[j];
				}
			}
			// 将结点k标记为已找到
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
