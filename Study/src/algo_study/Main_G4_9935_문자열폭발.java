package algo_study;

import java.io.*;
import java.util.*;

public class Main_G4_9935_문자열폭발 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		char[] bomb = br.readLine().toCharArray();
		
		ArrayDeque<Character> stack = new ArrayDeque<>();
		Stack<Character> tempStack;
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int len = bomb.length - 1;
			if(ch == bomb[len]) { // 스택에서 빼면서 비교해야함
				int k = 0;
				tempStack = new Stack<>();
				stack.offerLast(ch);
				if(stack.size() >= len + 1) {
					while(!stack.isEmpty()) {
						if(k > len) { // 다 일치해서 뺐다!
							break;
						}
						
						if(stack.peekLast() == bomb[len - k]) { // 문자열 일치하니까 계속 빼줌
							tempStack.push(stack.pollLast()); // 임시 스택에 넣어둠
							k++;
						}else { // 그동안 뺐던거 다시 넣어줘야함
							while(!tempStack.isEmpty()) {
								stack.offerLast(tempStack.pop());
							}
							break;
						}
					}
				}
			}else {
				stack.offerLast(ch);
			}
		}
		
		if(stack.isEmpty()) {
			sb.append("FRULA");
		}else {
			for(int i = 0, size = stack.size(); i < size; i++) {
				sb.append(stack.pollFirst());
			}			
		}
		
		System.out.println(sb);
	}
}
