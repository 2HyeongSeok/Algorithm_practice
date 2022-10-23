package algo_study;

import java.io.*;
import java.util.*;

public class Main_S2_18352_특정거리의도시찾기 {
	static ArrayList<Integer>[] list;
	static PriorityQueue<Integer> ansList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 도시의 개수
		int M = Integer.parseInt(st.nextToken()); // 도로의 개수
		int K = Integer.parseInt(st.nextToken()); // 거리 정보
		int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호
		
		list = new ArrayList[N+1];
		for(int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		ansList = new PriorityQueue<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
		}
		
		bfs(N, K, X);
		
		if(ansList.isEmpty()) {
			sb.append("-1");
		}else {
			while(!ansList.isEmpty()) {
				sb.append(ansList.poll()).append("\n");
			}
		}
				
		System.out.println(sb);
	}
	
	static void bfs(int N, int len, int start) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		int[] visited = new int[N+1];
		Arrays.fill(visited, Integer.MAX_VALUE);
		queue.offer(new int[] {start, 0});
		visited[start] = 0;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int next = cur[0];
			int depth = cur[1];
		
			if(depth == len) {
				ansList.add(next);
				continue;
			}
			
			for(int i = 0; i < list[next].size(); i++) {
				if(list[next].get(i) != start) {
					if(visited[list[next].get(i)] > depth) {
						visited[list[next].get(i)] = depth;
						queue.offer(new int[] {list[next].get(i), depth + 1});						
					}
				}
			}
		}
		
//		System.out.println(Arrays.toString(visited));
	}
}
