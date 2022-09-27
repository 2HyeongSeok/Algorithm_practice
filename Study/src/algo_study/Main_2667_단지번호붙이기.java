package algo_study;

import java.io.*;
import java.util.*;

public class Main_2667_단지번호붙이기 {
	static int[][] map;
	static int[][] visited;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int counter = 0; // 단지별 카운팅
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new int[N][N];
		for(int i = 0; i < N; i++) {
			char[] mapLine = br.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				// 맵 정보 저장 0 => -1 (집이 없음) / 1 => 0 (집 있음)
				// 단지 번호랑 겹치지 않게 하려고 ㅎㅎ!!
				map[i][j] = mapLine[j] - '1'; 
			}
		}
		
		int index = 1; // 단지 번호
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] > 0 || map[i][j] < 0) {
					// 이미 방문했거나, 집이 없으면
					continue;
				}else if(visited[i][j] == 0 && map[i][j] == 0) {
					// 방문한 적 없는 집이 있다면
					visited[i][j] = index;
					counter++;
					dfs(N, i, j, index);
					
					// 이어진거 다 방문하고 나서
					index++;
					pq.offer(counter);
					counter = 0;
				}
			}
		}
		
		sb.append(index - 1).append("\n");
		for(int i = 1; i < index; i++) {
			sb.append(pq.poll()).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int N, int row, int col, int index) {
		for(int k = 0; k < 4; k++) {
			int nr = row + dr[k];
			int nc = col + dc[k];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			
			if(visited[nr][nc] == 0 && map[nr][nc] == 0) {
				// 방문한 적 없는 집이 있다면
				visited[nr][nc] = index;
				counter++;
				dfs(N, nr, nc, index);
			}
		}		
	}
}
