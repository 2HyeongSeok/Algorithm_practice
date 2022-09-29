package algo_study;

import java.io.*;
import java.util.*;

public class Main_11048_이동하기 {
	static int[] dr = {1, 0, 1};
	static int[] dc = {0, 1, 1};
	static int[][] map;
	static boolean[][] visited;
	static int N, M, maxCount = 0;
	
	static int getMax(int a, int b, int c) {
		if(a > b && a > c) return a;
		if(b > c && b > a) return b;
		return c;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i > 0 && j > 0) map[i][j] += getMax(map[i-1][j-1], map[i-1][j], map[i][j-1]);
				if(i == 0 && j > 0) map[i][j] += map[i][j-1];
				if(j == 0 && i > 0) map[i][j] += map[i-1][j];
			}
		}
		
		System.out.println(map[N-1][M-1]);
		
//		// 우하향
//		visited[0][0] = true;
//		dfs(0, 0, map[0][0]);
//		
//		System.out.println(maxCount);
	}
	
//	static void dfs(int row, int col, int count) {
//		if(row == N-1 && col == M-1) {
//			maxCount = maxCount > count ? maxCount : count;
//			return;
//		}
//		
//		for(int k = 0; k < 3; k++) {
//			int nr = row + dr[k];
//			int nc = col + dc[k];
//			
//			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
//			
//			if(!visited[nr][nc]) {
//				visited[nr][nc] = true;
//				dfs(nr, nc, count + map[nr][nc]);
//				visited[nr][nc] = false;
//			}
//		}
//		
//	}
}
