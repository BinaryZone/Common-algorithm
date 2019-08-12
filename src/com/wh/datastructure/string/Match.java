package com.wh.datastructure.string;

public class Match {
	public static int match(String s,String t) {
		int i = 0;
		int j = 0;
		while(i < s.length() && j < t.length()) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
			}else {
				i = i-j+1;
				j = 0;
			}
		}
		if (j >= t.length()) {
			return i-t.length();
		}else {
			return -1;
		}
	}
	public static void main(String[] args) {
		System.out.println(match("rqqfqfqeqetqet", "fqfq"));
	}
}
