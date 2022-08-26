package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {
	
	static class Node implements Comparable<Node>{
		int from, to, weight;

		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};
		int N = Integer.parseInt(br.readLine());
		int[][] map, D;
		int index = 1;
		Node cur;
		
		while(N > 0) {
			
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			D = new int[N][N];
			for(int i = 0; i < N; i++) {
				Arrays.fill(D[i], Integer.MAX_VALUE);
			}
			D[0][0] = map[0][0];
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0, 0, D[0][0]));
			
			while(!pq.isEmpty()) {
				cur = pq.poll();
				
				if(cur.from == N-1 && cur.to == N-1) break;
								
				for(int i = 0; i < 4; i++) {
					int nr = cur.from + dr[i];
					int nc = cur.to + dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					
					if(map[nr][nc] + cur.weight >= D[nr][nc]) continue; // 이미 더 최적해가 구해져있음
					else { // 현재 경로에서 가는게 더 최적이다! -> 갱신
						D[nr][nc] = map[nr][nc] + cur.weight;
						pq.offer(new Node(nr, nc, D[nr][nc]));
					}
				}
			}
			
			sb.append("Problem ").append(index++).append(": ").append(D[N-1][N-1]).append("\n");
			
			N = Integer.parseInt(br.readLine());
		}
		
		System.out.println(sb);
	}
}
