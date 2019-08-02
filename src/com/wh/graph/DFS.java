package com.wh.graph;

public class DFS {
	// ������ȱ���
	// ��ʼ���i = 0
	private void dfs(Graph graph,boolean[] isVisited,int i) {
		// ���������ʼ���
		System.out.print(graph.getByIndex(i) + " ");
		// ���������Ϊ�ѷ���
		isVisited[i] = true;
		// ���ҽ��i�ĵ�һ���ڽӽ��
		int w = graph.getFirstNeighbor(i);
		while(w != -1) {
			if (!isVisited[w]) {
				dfs(graph,isVisited, w);
			}
			w = graph.getNextNeighbor(i, w);
		}
		
	}
	
	// ��dfs����һ�����أ������������еĽ�㣬������dfs
	public void dfs(Graph graph) {
		boolean[] isVisited = new boolean[graph.getSize()];
		// �������еĽ�㣬����dfs(����)
		for(int i = 0;i < graph.getSize();i++) {
			if (!isVisited[i]) {
				dfs(graph,isVisited,i);
			}
		}
	}
	
}
