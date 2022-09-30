package sw;

import java.io.*;
import java.util.*;

public class Solution_1249_보급로_dfsX {
	
	static int minTime;
	static int[][] map;
	static boolean[][] visited;
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
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				char[] line = br.readLine().toCharArray();
				for(int j = 0; j < N; j++) {
					map[i][j] = line[j] - '0';
				}
			}

			minTime = Integer.MAX_VALUE;
			visited[0][0] = true;
			dfs(0, 0, 0);
			
			sb.append("#").append(tc).append(" ").append(minTime).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int row, int col, int time) {
		if(row == N-1 && col == N-1) {
			minTime = minTime < time ? minTime : time;
			return;
		}
		
		if(minTime < time) return;
		
		for(int k = 0; k < 4; k++) {
			int nr = row + dr[k];
			int nc = col + dc[k];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
			
			if(!visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, time + map[nr][nc]);
				visited[nr][nc] = false;
			}
		}
	}
}
