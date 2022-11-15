package sw;

import java.io.*;
import java.util.*;

public class Solution_2112_보호필름 {
	static int T, D, W, K;
	static int ans;
	static boolean find;
	static int[][] map;
	static int[][] temp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			temp = new int[D][W];
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			find = false;
			for(int drug = 0; drug < D; drug++) {
				comb(0, 0, drug);
				if(find) {
					ans = drug;
					break;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void comb(int start, int count, int drug) {
		if(count == drug) {
			boolean flag = false;
			for(int i = 0; i < W; i++) {
				int cnt = 1;
				flag = false;
				for(int j = 0; j < D-1; j++) {
					if(map[j][i] == map[j+1][i]) cnt++;
					else cnt = 1;
					
					if(cnt == K) {
						flag = true;
						break;
					}
				}
				if(!flag) break;
			}
			if(flag) find = true;
			return;
		}
		
		for(int i = start; i < D; i++) {
			for(int type = 0; type <= 1; type++) {
				setDrug(i, type);
				comb(i + 1, count + 1, drug);
				setOrigin(i);
			}
		}
	}

	private static void setOrigin(int i) {
		for(int j = 0; j < W; j++) {
			map[i][j] = temp[i][j];
		}
	}

	static void setDrug(int i, int type) {
		for(int j = 0; j < W; j++) {
			temp[i][j] = map[i][j];
			map[i][j] = type;
		}
	}
}
