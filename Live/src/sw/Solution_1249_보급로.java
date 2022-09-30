package sw;

import java.io.*;
import java.util.*;

public class Solution_1249_보급로 {
	
	static int minTime;
	static int[][] map;
	static int[][] visited;
	static int N;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new int[N][N];
			for(int i = 0; i < N; i++) {
				char[] line = br.readLine().toCharArray();
				for(int j = 0; j < N; j++) {
					map[i][j] = line[j] - '0';
				}
				Arrays.fill(visited[i], Integer.MAX_VALUE);
			}

			minTime = Integer.MAX_VALUE;
			visited[0][0] = 0;
			bfs(0, 0);
			
			sb.append("#").append(tc).append(" ").append(minTime).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int row, int col) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {row, col});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			row = cur[0];
			col = cur[1];
			int time = visited[row][col];
			
			if(row == N-1 && col == N-1) {
				minTime = minTime < time ? minTime : time;
				continue;
			}
			
			if(minTime <= time) continue;
			
			for(int k = 0; k < 4; k++) {
				int nr = row + dr[k];
				int nc = col + dc[k];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if(visited[nr][nc] > visited[row][col] + map[nr][nc]) {
					visited[nr][nc] = visited[row][col] + map[nr][nc];
					queue.offer(new int[] {nr, nc});
				}
			}
		}
	}
}
