package com.wh.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
	// �洢���㼯��
	private ArrayList<String> vertexList;
	// �洢ͼ��Ӧ���ڽӾ���
	private int[][] edges;
	// ��ʾ�ߵ���Ŀ
	private int numOfEdges;
	// ������
	public Graph(int n) {
		vertexList = new ArrayList<>(n);
		edges = new int[n][n];
		numOfEdges = 0;
	}
	// ������
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
	// �õ���һ���ڽӽ����±�w
	public int getFirstNeighbor(int index) {
		for(int j = 0;j < vertexList.size();j++) {
			if (edges[index][j] > 0) {
				return j;
			}
		}
		return -1;
	}
	// ����ǰһ���ڽӽ����±�����ȡ��һ���ڽӽ��
	public int getNextNeighbor(int v1,int v2) {
		for(int j = v2+1;j < vertexList.size();j++) {
			if (edges[v1][j] > 0) {
				return j;
			}
		}
		return -1;
	}
	// ����ڵ�
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}
	// ��ӱ�
	public void insertEdge(int v1,int v2,int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}
	// ��ȡ�����
	public int getSize() {
		return vertexList.size();
	}
	// ��ȡ�ߵĸ���
	public int getNumOfedges() {
		return numOfEdges;
	}
	// ��õ�i���ڵ��ֵ
	public String getByIndex(int i) {
		return vertexList.get(i);
	}
	// ��ȡȨֵ
	public int getWeight(int i,int j) {
		return edges[i][j];
	}
	// ��ʾ�ڽӾ���
	public void showGraph() {
		for(int[] link:edges) {
			System.out.println(Arrays.toString(link));
		}
	}
	// ��ȡ����Ӧ�յ�Ķ�Ӧ�±�
	public int getEnd(int[] ends,int i) {
		while (ends[i] > 0) {
			i = ends[i];
		}
		return i;
	}
	// ��ȡ���бߵļ���
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
	// ��ͼ�����б߰�Ȩֵ��С�����������
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
	// ���ݽ���ֵ��ȡ��Ӧ���±�
	public int getPosition(String s) {
		for(int i = 0;i < vertexList.size();i++) {
			if (vertexList.get(i) == s) {
				return i;
			}
		}
		return -1;
	}
}
// EData������ʾһ����Ȩ�ı�
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