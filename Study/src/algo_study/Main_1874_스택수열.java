package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1874_스택수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		int[] inputs = new int[N];
		for(int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(br.readLine());
		}
		
		int i = 1;
		int index = 0;
		while(index <= N - 1) {
			if(stack.isEmpty()) {
				stack.push(i++); // 비어있다면 해당 인덱스 넣어주고 1 더함
				sb.append("+").append("\n");
			}
			else {
				if(stack.peek() == inputs[index]) {
					// 스택의 마지막 값이 수열과 일치하므로 빼야함
					stack.pop();
					sb.append("-").append("\n");
					index++;
				}else {
					// 다르면 더하거나 불가능한지 판별해야함
					if(stack.peek() < inputs[index]) {
						// 더할 수 있음
						stack.push(i++);
						sb.append("+").append("\n");
					}else {
						// 불가능한 상태
						System.out.println("NO");
						return;
					}
				}
			}
		}
		System.out.println(sb);
	}
}
