package algorithm;

import java.io.*;
import java.util.*;

public class Solution_5643_Å°¼ø¼­ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			int[][] stus = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					stus[i][j] = 100000;
				}
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int small = Integer.parseInt(st.nextToken());
				int tall = Integer.parseInt(st.nextToken());
				
				stus[small - 1][tall - 1] = 1;
			}
			
			for(int k = 0; k < N; k++) {
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						stus[i][j] = Math.min(stus[i][j], stus[i][k] + stus[k][j]);
					}
				}
			}
			
			int totalCount = 0;
			for(int i = 0; i < N; i++) {
				int count = 0;
				for(int j = 0; j < N; j++) {
					if(stus[j][i] < 100000) count++;
					if(stus[i][j] < 100000) count++;
				}
				
				if(count == N - 1) totalCount++; 
			}
			
			sb.append("#").append(t).append(" ").append(totalCount).append("\n");
		}
		System.out.println(sb);
	}
}
