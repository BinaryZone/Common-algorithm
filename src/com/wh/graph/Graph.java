package com.wh.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
	// 存储定点集合
	private ArrayList<String> vertexList;
	// 存储图对应的邻接矩阵
	private int[][] edges;
	// 表示边的数目
	private int numOfEdges;
	// 构造器
	public Graph(int n) {
		vertexList = new ArrayList<>(n);
		edges = new int[n][n];
		numOfEdges = 0;
	}
	// 构造器
	public Graph(int n,int[][] weight,String[] s) {
		vertexList = new ArrayList<>(n);
		edges = new int[n][n];
		for(int i = 0;i < n;i++) {
			this.insertVertex(s[i]);
			for(int j = 0;j < n;j++) {
				edges[i][j] = weight[i][j];
			}
		}
		for(int i = 0;i < n;i++) {
			for(int j = i+1;j < n;j++) {
				if (edges[i][j] < 10000) {
					numOfEdges++;
				}
			}
		}
	}
	// 得到第一个邻接结点的下标w
	public int getFirstNeighbor(int index) {
		for(int j = 0;j < vertexList.size();j++) {
			if (edges[index][j] > 0) {
				return j;
			}
		}
		return -1;
	}
	// 根据前一个邻接结点的下标来获取下一个邻接结点
	public int getNextNeighbor(int v1,int v2) {
		for(int j = v2+1;j < vertexList.size();j++) {
			if (edges[v1][j] > 0) {
				return j;
			}
		}
		return -1;
	}
	// 插入节点
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}
	// 添加边
	public void insertEdge(int v1,int v2,int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}
	// 获取结点数
	public int getSize() {
		return vertexList.size();
	}
	// 获取边的个数
	public int getNumOfedges() {
		return numOfEdges;
	}
	// 获得第i个节点的值
	public String getByIndex(int i) {
		return vertexList.get(i);
	}
	// 获取权值
	public int getWeight(int i,int j) {
		return edges[i][j];
	}
	// 显示邻接矩阵
	public void showGraph() {
		for(int[] link:edges) {
			System.out.println(Arrays.toString(link));
		}
	}
	// 获取结点对应终点的对应下标
	public int getEnd(int[] ends,int i) {
		while (ends[i] > 0) {
			i = ends[i];
		}
		return i;
	}
	// 获取所有边的集合
	public EData[] getEdges() {
		int index = 0;
		EData[] eDatas = new EData[numOfEdges];
		for(int i = 0;i < vertexList.size();i++) {
			for(int j = i+1;j < vertexList.size();j++) {
				if (edges[i][j] < 10000) {
					eDatas[index++] = new EData(vertexList.get(i), vertexList.get(j), edges[i][j]);
				}
			}
		}
		return eDatas;
	}
	// 对图的所有边按权值从小到大进行排序
	public void sortEdges(EData[] eDatas) {
		for(int i = 0;i < eDatas.length;i++) {
			for(int j = 0;j < eDatas.length - i - 1;j++) {
				if (eDatas[j+1].weight < eDatas[j].weight) {
					EData temp = eDatas[j];
					eDatas[j] = eDatas[j+1];
					eDatas[j+1] = temp;
				}
			}
		}
	}
	// 根据结点的值获取对应的下标
	public int getPosition(String s) {
		for(int i = 0;i < vertexList.size();i++) {
			if (vertexList.get(i) == s) {
				return i;
			}
		}
		return -1;
	}
}
// EData用来表示一条带权的边
class EData{
	String start;
	String end;
	int weight;
	public EData(String start,String end,int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "EData [<" + start + ", " + end + "> " + weight + "]";
	}
	
}