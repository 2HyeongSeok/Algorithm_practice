package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218_괄호짝짓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (int t = 1; t <= 10; t++) {
			boolean okFlag = true;
			sb.append("#").append(t).append(" ");

			int len = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();
			for (int i = 0; i < len; i++) {
				if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{' || arr[i] == '<')
					stack.push(arr[i]);
				else {
					if(!stack.isEmpty() && arr[i] == ')') {
						if(stack.peek() == '(') stack.pop();
						else {
							okFlag = false;
							break;
						}
					}else if(!stack.isEmpty() && arr[i] == ']') {
						if(stack.peek() == '[') stack.pop();
						else {
							okFlag = false;
							break;
						}
					}else if(!stack.isEmpty() && arr[i] == '}') {
						if(stack.peek() == '{') stack.pop();
						else {
							okFlag = false;
							break;
						}
					}else if(!stack.isEmpty() && arr[i] == '>') {
						if(stack.peek() == '<') stack.pop();
						else {
							okFlag = false;
							break;
						}
					}
				}
			}
			if(okFlag) {
				sb.append(1).append("\n");
			}else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}
}
