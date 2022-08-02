package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main_4949_균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack;
		boolean isBalanced;

		while (true) {
			String[] lines = br.readLine().split("");
			int len = lines.length;

			// .이 들어오면 끝!
			if (lines[0].equals("."))
				break;

			isBalanced = true;
			stack = new Stack<>();
			for (int i = 0; i < len; i++) {
				if (lines[i].equals("(") || lines[i].equals("["))
					stack.push(lines[i]);
				else if (lines[i].equals(")")) {
					if (stack.isEmpty() || !stack.peek().equals("(")) {
						// 스택이 비거나 [가 들어있으면
						isBalanced = false;
						break;
					} else {
						stack.pop();
					}
				} else if (lines[i].equals("]")) {
					if (stack.isEmpty() || !stack.peek().equals("[")) {
						// 스택이 비거나 (가 들어있으면
						isBalanced = false;
						break;
					} else {
						stack.pop();
					}
				}
			}
			if (stack.isEmpty() && isBalanced)
				sb.append("yes").append("\n");
			else
				sb.append("no").append("\n");
		}
		System.out.println(sb);
	}
}