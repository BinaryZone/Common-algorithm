package com.wh.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	// bfs
	private void bfs(Graph graph,boolean[] isVisited,int i) {
		int u; // ��ʾ����ͷ���
		int w; // ��ʾ�ڽӽ��
		Queue<Integer> queue = new LinkedList<>();
		System.out.println(graph.getByIndex(i));
		isVisited[i] = true;
		queue.add(i);
		while(!queue.isEmpty()) {
			u = queue.poll();
			w = graph.getFirstNeighbor(u);
			while(w != -1) {
				if (!isVisited[w]) {
					System.out.print(graph.getByIndex(w) + " ");
					isVisited[w] = true;
					queue.add(w);
				}
				w = graph.getNextNeighbor(u, w);
			}
		}
	}
	public void bfs(Graph graph) {
		boolean[] isVisited = new boolean[graph.getSize()];
		for(int i = 0;i < graph.getSize();i++) {
			if (!isVisited[i]) {
				bfs(graph, isVisited,i);
			}
		}
	}
}
