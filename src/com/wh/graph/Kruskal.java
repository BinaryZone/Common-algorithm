package com.wh.graph;

import java.util.Arrays;

public class Kruskal {
	public void kruskal(Graph graph) {
		int index = 0;
		int[] ends = new int[graph.getSize()];
		EData[] result = new EData[graph.getSize()-1];
		
		EData[] edges = graph.getEdges();
		System.out.println("图的边的集合"+Arrays.toString(edges));
		graph.sortEdges(edges);
		System.out.println("排序后边的集合："+Arrays.toString(edges));
		for(int i = 0;i < graph.getNumOfedges();i++) {
			int p1 = graph.getPosition(edges[i].start);
			int p2 = graph.getPosition(edges[i].end);
			int m = graph.getEnd(ends, p1);
			int n = graph.getEnd(ends, p2);
			System.out.println("m:"+m+" n:" + n);
			if (m != n) {
				result[index++] = edges[i];
				ends[m] = n;
			}
		}
		System.out.println(Arrays.toString(ends));
		System.out.println("kruskal:"+Arrays.toString(result));
	}
}
