package boj_class03;

import java.io.*;
import java.util.*;

public class Main_G5_7569_토마토 {
	static int[] dr = {-1, 0, 1, 0, 0, 0}; // 상우하좌 위층 아래층
	static int[] dc = {0, 1, 0, -1, 0, 0};
	static int[] dh = {0, 0, 0, 0, -1, 1};

	static int[][][] map;
	static boolean[][][] visited;
	
	static ArrayDeque<int[]> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int cols = Integer.parseInt(st.nextToken()); // 가로칸의 수
		int rows = Integer.parseInt(st.nextToken()); // 세로칸의 수
		int h = Integer.parseInt(st.nextToken()); // 쌓아올려지는 상자의 수
		
		map = new int[rows][cols][h];
		visited = new boolean[rows][cols][h];
		queue = new ArrayDeque<>();
		
		int sum = 0, tomato = 0;
		for(int k = 0; k < h; k++) {
			for(int i = 0; i < rows; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < cols; j++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k] == 1) {
						visited[i][j][k] = true;
						queue.offer(new int[] {i, j, k});
						sum++;
						tomato++;
//						System.out.println("초기상태 sum : " + sum + ", tomato : " + tomato);
//						System.out.println("위치 : (" + i + ", " + j + ", " + k + ")");
					}else if(map[i][j][k] == 0) {
						tomato++;
					}
				}
			}
		}
		
		int day = 0;
		while(!queue.isEmpty()) {
			int size = queue.size(); // 날짜 계산하기 위해
			day++;
			for(int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				int row = cur[0];
				int col = cur[1];
				int height = cur[2];
				
				for(int k = 0; k < 6; k++) {
					int nr = row + dr[k];
					int nc = col + dc[k];
					int nh = height + dh[k];
					
					if(nr < 0 || nr >= rows || nc < 0 || nc >= cols || nh < 0 || nh >= h || visited[nr][nc][nh]) continue;
					
					if(map[nr][nc][nh] == 0) {
						visited[nr][nc][nh] = true;
						queue.offer(new int[] {nr, nc, nh});
						sum++;
//						System.out.println(day + " = 번지는 중 sum : " + sum + ", tomato : " + tomato);
//						System.out.println("위치 : (" + nr + ", " + nc + ", " + nh + ")");
//						System.out.println();
					}
				}
			}
		}
		
		if(sum == tomato) System.out.println(day - 1);
		else System.out.println(-1);
	}
}
