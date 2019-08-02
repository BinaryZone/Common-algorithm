package com.wh.graph;

public class Test {
	public static void main(String[] args) {
//		Graph graph = new Graph(8);
//		String[] s = {"1","2","3","4","5","6","7","8"};
//		for(String str:s) {
//			graph.insertVertex(str);
//		}
//		graph.insertEdge(0, 1, 1);
//		graph.insertEdge(0, 2, 1);
//		graph.insertEdge(1, 3, 1);
//		graph.insertEdge(1, 4, 1);
//		graph.insertEdge(3, 7, 1);
//		graph.insertEdge(4, 7, 1);
//		graph.insertEdge(2, 5, 1);
//		graph.insertEdge(2, 6, 1);
//		graph.insertEdge(5, 6, 1);
//		System.out.println("…Ó∂»±È¿˙£∫");
//		new BFS().bfs(graph);
//		new DFS().dfs(graph);
		String[] s = {"A","B","C","D","E","F","G"};
		int[][] weight = new int[][] {
			{10000,5,7,10000,10000,10000,2},
			{5,10000,10000,9,10000,10000,3},
			{7,10000,10000,10000,8,10000,10000},
			{10000,9,10000,10000,10000,4,10000},
			{10000,10000,8,10000,10000,5,4},
			{10000,10000,10000,4,5,10000,6},
			{2,3,10000,10000,4,6,10000},
		};
		Graph graph  = new Graph(7, weight, s);
		graph.showGraph();
//		System.out.println(graph.getPosition("G"));
//		new Prim().prim(graph, 0);
//		new Kruskal().kruskal(graph);
		new Dijkstra().dijkstra(graph, 0);
		new Floyd().floyd(graph);
 	}
}
