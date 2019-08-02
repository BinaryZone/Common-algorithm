package com.wh.graph;

public class Prim {
	public void prim(Graph graph,int v) {
		int[] isVisited = new int[graph.getSize()];
		isVisited[v] = 1;
		// 
		int h1 = -1;
		int h2 = -1;
		int minWeight = 10000;
		for(int k = 1;k < graph.getSize();k++) {
			for(int i = 0;i < graph.getSize();i++) {
				for(int j = 0;j < graph.getSize();j++) {
					if (isVisited[i] == 1 && isVisited[j] == 0 && graph.getWeight(i, j) < minWeight) {
						minWeight = graph.getWeight(i, j);
						h1 = i;
						h2 = j;
					}
				}
			}
			System.out.println("±ß<"+graph.getByIndex(h1)+","+graph.getByIndex(h2)+">È¨Öµ£º"+minWeight);
			isVisited[h2] = 1;
			minWeight = 10000;
		}
	}
}
