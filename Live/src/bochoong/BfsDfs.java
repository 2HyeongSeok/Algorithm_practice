package bochoong;

import java.io.*;
import java.util.*;

public class BfsDfs {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int N = 5, C = 1;
	static int[][] a;
	static boolean[][] v;
	
	static void bfs(int r, int c) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[r][c] = true;
		q.offer(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] rc = q.poll();
			r = rc[0];
			c = rc[1];
			
			a[r][c] = C++;
			for(int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if(!v[nr][nc]) {
					v[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}
	
	static void dfs(int r, int c) {
		v[r][c] = true;
		a[r][c] = C++;
		for(int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			
			if(!v[nr][nc])
				dfs(nr, nc);
		}
	}
	
	public static void main(String[] args) {
		a = new int[N][N];
		v = new boolean[N][N];
		
		bfs(N/2, N/2);
		dfs(N/2, N/2);
		for(int[] b:a) System.out.println(Arrays.toString(b));System.out.println();
	}
}
