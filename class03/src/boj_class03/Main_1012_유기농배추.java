package boj_class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int M, N, K;
		
		int[][] map;
		boolean[][] checkedMap;
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		Queue<Integer[]> queue;
		
		int counter = 0;
		int nr, nc;
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[M][N];
			checkedMap = new boolean[M][N];
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine(), " ");
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			queue = new ArrayDeque<>();
			counter = 0;
			
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 1 && !checkedMap[i][j]) { // 배추흰지렁이 필요하므로 bfs 시작
						checkedMap[i][j] = true;
						
						for(int k = 0; k < 4; k++) {
							nr = i + dr[k];
							nc = j + dc[k];
							
							if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
							
							if(map[nr][nc] == 1 && !checkedMap[nr][nc]) {
								queue.offer(new Integer[] {nr, nc});
								checkedMap[nr][nc] = true;
							}
						}
						
						while(!queue.isEmpty()) { // bfs
							Integer[] temp = queue.poll();
							for(int k = 0; k < 4; k++) {
								nr = temp[0] + dr[k];
								nc = temp[1] + dc[k];
								
								if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
								
								if(map[nr][nc] == 1 && !checkedMap[nr][nc]) {
									queue.offer(new Integer[] {nr, nc});
									checkedMap[nr][nc] = true;
								}
							}
						}
						counter++;
					}
				}
			}
			sb.append(counter).append("\n");
		}
		System.out.println(sb);
	}
}
