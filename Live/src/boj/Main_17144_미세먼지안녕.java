package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int R, C, xAC1, xAC2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		boolean flag = true;
		map = new int[R][C];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1 && flag) {
					xAC1 = i;
					xAC2 = i+1;
					flag = false;
				}
			}
		}
		
		while(T-- > 0) {
			spread();
			clean();
		}
		
		int dustCount = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == -1) continue;
				dustCount += map[i][j];
			}
		}
		
		System.out.println(dustCount);
		
	}
	
	static void spread() {
		int[][] sumMap = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] >= 5) { // 확산된다!
					int totalSpread = 0;
					for(int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						
						if(nr < 0 || nr >= R || nc < 0 || nc >= C || (nr == xAC1 && nc == 0) || (nr == xAC2 && nc == 0)) continue;
						
						sumMap[nr][nc] += map[i][j]/5;
						totalSpread += map[i][j]/5;
					}
					sumMap[i][j] += map[i][j] - totalSpread;
				}else if(map[i][j] > 0) { // 유지!
					sumMap[i][j] += map[i][j];
				}
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == -1) continue;
				map[i][j] = sumMap[i][j];
			}
		}
	}
	
	static void clean() {
		// 위쪽 돌리기
		for(int i = xAC1-1; i > 0; i--) 
			map[i][0] = map[i-1][0];
		for(int i = 0; i < C-1; i++)
			map[0][i] = map[0][i+1];
		for(int i = 0; i < xAC1; i++)
			map[i][C-1] = map[i+1][C-1];
		for(int i = C-1; i > 1; i--) 
			map[xAC1][i] = map[xAC1][i-1];
		map[xAC1][1] = 0;
		
		// 아래쪽 돌리기
		for(int i = xAC2+1; i < R-1; i++)
			map[i][0] = map[i+1][0];
		for(int i = 0; i < C-1; i++)
			map[R-1][i] = map[R-1][i+1];
		for(int i = R-1; i > xAC2; i--) 
			map[i][C-1] = map[i-1][C-1];
		for(int i = C-1; i > 1; i--) 
			map[xAC2][i] = map[xAC2][i-1];
		map[xAC2][1] = 0;
	}
}
