package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11866_요세푸스문제0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		sb.append("<");
		while(!queue.isEmpty()) {
			for(int i = 0; i < K - 1; i++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll());
			if(queue.size() == 0) sb.append(">");
			else sb.append(", ");
		}
		
		System.out.println(sb);
	}
}
