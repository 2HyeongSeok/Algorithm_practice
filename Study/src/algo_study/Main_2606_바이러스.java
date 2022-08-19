package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
	
	static int[][] vector;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());
		int couple = Integer.parseInt(br.readLine());
		
		vector = new int[num+1][num+1];
		boolean[] visited = new boolean[num+1];
		
		for(int i = 0; i < couple; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			vector[a][b] = vector[b][a] = 1;
		}
		
		int result = bfs(visited, num, 1) - 1; // 1번 컴퓨터 제외
		
		System.out.println(result);
	}
	
	static int bfs(boolean[] visited, int num, int V) {
		int count = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(V);
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			int next = queue.poll();
			count++;
			
			for(int i = 1; i <= num; i++) {
				if(!visited[i] && vector[next][i] == 1) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		
		return count;
	}
}
