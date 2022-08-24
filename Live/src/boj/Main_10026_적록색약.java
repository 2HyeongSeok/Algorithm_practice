package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_10026_적록색약 {
	
	static char[][] parent, map;
	static boolean[][] visited;
	static int N, areaCount = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		parent = new char[N][N];
		for(int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				map[i][j] = line[j];
			}
		}

		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i, j, map[i][j]);
				}
			}
		}
		sb.append(areaCount).append(" ");
		
		areaCount = 0;
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 'G') map[i][j] = 'R'; // 적록색약은 같은 색으로 보니까
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i, j, map[i][j]);
				}
			}
		}
		sb.append(areaCount);
		
		System.out.println(sb);
	}
	
	static void bfs(int row, int col, char value) {
		Queue<Integer[]> queue = new ArrayDeque<>();
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		queue.offer(new Integer[] { row, col });
		visited[row][col] = true;
		
		while(!queue.isEmpty()) {
			Integer[] next = queue.poll();
			row = next[0];
			col = next[1];
			
			for(int k = 0; k < 4; k++) {
				int nr = row + dr[k];
				int nc = col + dc[k];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if(!visited[nr][nc] && map[nr][nc] == value) {
					visited[nr][nc] = true;
					queue.offer(new Integer[] {nr, nc});
				}
			}
		}
		
		areaCount++;
	}
}
