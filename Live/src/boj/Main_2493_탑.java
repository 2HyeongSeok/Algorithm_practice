package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");

		int[] nums = new int[N+1];
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		// 몇번째 인덱스의 탑이 수신했는지 저장하는 배열
		int[] isReceived = new int[N + 1];

		// 구현부
		check(nums, isReceived, N);

		// 출력부
		for (int i = 1; i <= N; i++) {
			sb.append(isReceived[i]).append(" ");
		}
		System.out.println(sb);
	}

	static void check(int[] nums, int[] isReceived, int N) {
		Stack<Integer> stack = new Stack<>(); // 수신하는 탑이 나올 때까지 담아둘 스택
		Stack<Integer> stackIdx = new Stack<>(); // 수신하는 탑이 나올 때까지 인덱스 정보 담아둘 스택
		
		for (int i = N; i > 1; i--) {
			stack.push(nums[i]);
			stackIdx.push(i);
			if (nums[i] > nums[i - 1]) { // 다음 탑이 더 낮다면 계속해서 스택에 push하러 감
				continue;
			}else { // 다음 탑이 현재 탑보다 높다면
				stack.pop(); // 한개 빼고
				isReceived[stackIdx.pop()] = i - 1;
				int len = stack.size(); // 따로 미리 구해두지 않으면 for문 돌면서 size가 바뀌면서 문제생김!
				for (int k = 0; k < len; k++) {
					if(stack.peek() < nums[i - 1]) { // 스택의 다음값도 다음 탑보다 작다면 이전 행동 반복!
						stack.pop();
						isReceived[stackIdx.pop()] = i - 1;
					}else break; // 다음 탑보다 크다면 pop하던걸 멈추고 다시 push하러 감!
				}
			}
		}
	}
}
