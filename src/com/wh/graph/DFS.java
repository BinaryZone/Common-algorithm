package com.wh.graph;

public class DFS {
	// 深度优先遍历
	// 初始结点i = 0
	private void dfs(Graph graph,boolean[] isVisited,int i) {
		// 首先输出初始结点
		System.out.print(graph.getByIndex(i) + " ");
		// 将结点设置为已访问
		isVisited[i] = true;
		// 查找结点i的第一个邻接结点
		int w = graph.getFirstNeighbor(i);
		while(w != -1) {
			if (!isVisited[w]) {
				dfs(graph,isVisited, w);
			}
			w = graph.getNextNeighbor(i, w);
		}
		
	}
	
	// 对dfs进行一个重载，遍历我们所有的结点，并进行dfs
	public void dfs(Graph graph) {
		boolean[] isVisited = new boolean[graph.getSize()];
		// 遍历所有的结点，进行dfs(回溯)
		for(int i = 0;i < graph.getSize();i++) {
			if (!isVisited[i]) {
				dfs(graph,isVisited,i);
			}
		}
	}
	
}
