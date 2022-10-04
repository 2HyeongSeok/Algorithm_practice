package sw;

import java.io.*;
import java.util.*;

public class Solution_5656_벽돌깨기{
	static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int N, W, H, minCount;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < W; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			minCount = Integer.MAX_VALUE;
			go(map, 0);
			
			sb.append("#").append(t).append(" ").append(minCount).append("\n");
		}
		
		System.out.println(sb);
	}
	
	// 구슬 던지기 게임
	static boolean go(int[][] map, int cnt) { // map : 직전 구슬까지 던진 상태의 배열
		
		int result = getRemain(map);
		if(result == 0) { /////////////////////////////////////////////
			minCount = 0;
			return true;
		}
		
		if(cnt == N) { // 구슬 다 던진 상태
			// 남은 벽돌 수 카운트해서 최소값 갱신!
			minCount = minCount < result ? minCount : result;
			return false;
		}
		
		// 중복 순열
		int[][] newMap = new int[H][W];
		
		for(int c = 0; c < W; c++) {
			// 구슬에 맞는 시작 벽돌 찾기
			int r = 0;
			while(r < H && map[r][c] == 0) ++r;
			
			if(r == H) {
				// 맞는 시작 벽돌이 없다
				continue; /////////////////////////////////////////////
			}else {
				copy(map, newMap);
				
				// 제거될 벽돌 연쇄 처리
				boom(newMap, r, c, newMap[r][c]); // 시작 위치
				
				// 벽돌 중력 처리
				down(newMap);
				
				// 다음 구슬 던지기
				if(go(newMap, cnt + 1)) return true; ///////////////////
			}
		}
		return false;
	}

	private static int getRemain(int[][] map) {
		int count = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(map[i][j] > 0) count++;
			}
		}
		
		return count;
	}

	private static void down(int[][] newMap) {
		Queue<Integer> q = new ArrayDeque<>();
		for(int c = 0; c < W; c++) {
			for(int r = H-1; r >= 0; r--) {
				if(newMap[r][c] > 0) {
					q.offer(newMap[r][c]);
					newMap[r][c] = 0;
				}
			}
			
			int index = H-1;
			while(!q.isEmpty()) {
				newMap[index--][c] = q.poll();
			}
		}
	}

	private static void boom(int[][] map, int r, int c, int cnt) {
		// 벽돌이 있던 자리를 0으로 변경 : 빈칸으로 만들어서 방문처리
		map[r][c] = 0; // 방문처리 ==> 제거처리
		
		if(cnt == 1) return;
		
		for(int k = 0; k < 4; k++) {
			int nr = r;
			int nc = c;
			for(int l = 1; l < cnt; l++) {
				nr += dr[k];
				nc += dc[k];
				
				if(nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 0) continue;
				
				boom(map, nr, nc, map[nr][nc]);
			}
		}
	}

	private static void copy(int[][] map, int[][] newMap) {
		for(int r = 0; r < H; r++) {
			for(int c = 0; c < W; c++) {
				newMap[r][c] = map[r][c];
			}
		}
	}
}