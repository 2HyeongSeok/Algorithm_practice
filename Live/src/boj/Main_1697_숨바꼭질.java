package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new ArrayDeque<>();
		Queue<Integer> tempQueue = new ArrayDeque<>();
		boolean[] visited = new boolean[100001];
		
		int time = 0;
		queue.offer(N);
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			if(cur == K) {
				// 도착
				break;
			}
			
			// cur - 1, cur + 1, cur * 2 방문 안했으면 방문하면서 큐에 추가
			if(cur - 1 >= 0 && !visited[cur-1]) {
				tempQueue.offer(cur-1);
				visited[cur-1] = true;
			}
			if(cur + 1 < 100001 && !visited[cur+1]) {
				tempQueue.offer(cur+1);
				visited[cur+1] = true;
			}
			if(cur * 2 < 100001 && !visited[cur*2]) {
				tempQueue.offer(cur*2);
				visited[cur*2] = true;
			}
			
			if(!tempQueue.isEmpty() && queue.isEmpty()) {
				// 기존 큐가 다 비었음 (너비 탐색 완료)
				// 그동안 tempQueue에 담아둔 BFS 다음 너비 탐색하게 queue로 전달
				queue = tempQueue;
				tempQueue = new ArrayDeque<>();
				time++; // 다음 너비 갈 때마다 1초씩 추가
				System.out.println(queue + ", time : " + time);
			}
		}
		
		System.out.println(time);
	}
}
