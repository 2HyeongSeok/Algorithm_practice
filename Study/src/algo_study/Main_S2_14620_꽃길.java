package algo_study;

import java.io.*;
import java.util.*;

public class Main_S2_14620_꽃길 {
	static int N, ans;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = Integer.MAX_VALUE;
		dfs(0, 0);
		
		System.out.println(ans);
	}
	
	static void dfs(int count, int tempSum) {
		if(count == 3) {
			
			if(ans > tempSum) ans = tempSum;
			
			return ;
		}
		
		for(int i = 1; i < N-1; i++) {
			for(int j = 1; j < N-1; j++) {
				if(!visited[i][j] && check(i, j)) {
					visited[i][j] = true;
					int s = sum(i, j);
					
					dfs(count + 1, tempSum + s);
					
					clear(i, j);
					visited[i][j] = false;
				}
			}
		}
	}
	
	private static void clear(int i, int j) {
		for(int k = 0; k < 4; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			
			visited[nr][nc] = false;
		}
	}

	private static boolean check(int i, int j) {
		for(int k = 0; k < 4; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			
			if(visited[nr][nc]) return false;
		}
		return true;
	}

	private static int sum(int row, int col) {
		int s = map[row][col];
		for(int k = 0; k < 4; k++) {
			int nr = row + dr[k];
			int nc = col + dc[k];
			
			visited[nr][nc] = true;
			s += map[nr][nc];
		}
		
		return s;
	}
}
