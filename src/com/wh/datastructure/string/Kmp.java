package com.wh.datastructure.string;

// 理解kmp首先要明白主串的指针i是不需要回溯的
// 其次需要通过求匹配串的最大公共前后缀的长度求出j的下一步的位置，这是难点
public class Kmp {
	// 本质为求最大公共前后缀的长度
	public static int[] getNextArray(char[] t) {
		int[] next = new int[t.length];
		next[0] = -1;
		next[1] = 0;
		int k;
		// 理解难点
		for(int j=2;j<t.length;j++) {
			// 前一个位置的最大公共前后缀长度
			k = next[j-1];
			while(k != -1) {
				if (t[j-1] == t[k]) {
					next[j] = k + 1;
					break;
				}else {
					// 核心难点
					k = next[k];
				}
			}
			next[j] = 0;
		}
		return next;
	}
	public static int kmpMatch(String s,String t) {
		char[] s_arr = s.toCharArray();
		char[] t_arr = t.toCharArray();
		int[] next = getNextArray(t_arr);
		int i = 0;
		int j = 0;
		while(i<s_arr.length && j<t_arr.length) {
			if (j == -1 || s_arr[i] == t_arr[j]) {
				i++;
				j++;
			}else {
				j = next[j];
			}
		}
		if (j == t_arr.length) {
			return i - j;
		}else {
			return -1;
		}
	}
	public static void main(String[] args) {
		String s = "abcacasdasjffsa";
		String t = "sjff";
		System.out.println(kmpMatch(s, t));
	}
}
