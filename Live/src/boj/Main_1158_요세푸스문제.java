package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1158_요세푸스문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		sb.append("<");
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> arr = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			arr.offer(i);
		}
		
		while(arr.size() > 0) {
			for(int i = 0; i < K - 1; i++) {
				arr.offer(arr.poll());
			}
			sb.append(arr.poll());
			if(arr.size() == 0) sb.append(">");
			else sb.append(", ");
		}
		
		System.out.println(sb);
	}
}
