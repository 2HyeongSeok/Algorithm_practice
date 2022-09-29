package sw;

import java.io.*;
import java.util.*;

public class Solution_1953_탈주범검거 {
	static int[] dr = {-1, 0, 1, 0}; // 상 우 하 좌
	static int[] dc = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visited;
	static int N, M, t, count;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			count = 0;
			bfs(r, c, 0);
			
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int r, int c, int depth) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		visited[r][c] = true;
		queue.offer(new int[] {r, c, depth});
		
		while(!queue.isEmpty()) {
			int[] rc = queue.poll();
			r = rc[0];
			c = rc[1];
			depth = rc[2];
			
			int value = map[r][c];
			
			if(value == 0) continue;
			count++;
			
			if(depth == t - 1)
				continue;
			
			for(int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if(!visited[nr][nc]) {
					switch(k) {
					case 0:
						if(value == 3 || value == 5 || value == 6) break;
						if(map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6) {
							visited[nr][nc] = true;
							queue.offer(new int[] {nr, nc, depth+1});
						}
						break;
					case 1:
						if(value == 2 || value == 6 || value == 7) break;
						if(map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7) {
							visited[nr][nc] = true;
							queue.offer(new int[] {nr, nc, depth+1});
						}
						break;
					case 2:
						if(value == 3 || value == 4 || value == 7) break;
						if(map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 7) {
							visited[nr][nc] = true;
							queue.offer(new int[] {nr, nc, depth+1});
						}
						break;
					case 3:
						if(value == 2 || value == 4 || value == 5) break;
						if(map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 5) {
							visited[nr][nc] = true;
							queue.offer(new int[] {nr, nc, depth+1});
						}
						break;
					}
				}
			}
		}
	}
}
