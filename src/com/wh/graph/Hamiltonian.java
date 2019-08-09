package com.wh.graph;

import java.util.Scanner;

public class Hamiltonian {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int m = 1<<(n-1);
		int[][] dp = new int[n][m];
		// ³õÊ¼×´Ì¬
		for(int i = 0;i < n;i++) {
			dp[i][0] = map[0][i];
		}
		for(int j = 1;j < m;j++) {
			for(int i = 0;i < n;i++) {
				dp[i][j] = 0x7ffff;
				for(int k = 1;k < n;k++) {
					if ((j >> (k-1) & 1) == 0) {
						continue;
					}
					if (map[i][k] + dp[k][j^(1 << (k-1))] < dp[i][j]) {
						dp[i][j] = map[i][k] + dp[k][j^(1 << (k-1))];
					}
				}
			}
		}
		System.out.println(dp[0][m-1]);
	}
}
