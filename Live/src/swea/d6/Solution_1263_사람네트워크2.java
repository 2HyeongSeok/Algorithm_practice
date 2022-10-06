package swea.d6;

import java.io.*;
import java.util.*;

public class Solution_1263_사람네트워크2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			int[][] dp = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i == j) continue;
					
					if(map[i][j] == 1) dp[i][j] = 1;
					else dp[i][j] = 100000;
				}
			}
			
			for(int i = 0; i < N; i++) { // 경
				for(int j = 0; j < N; j++) { // 출
					for(int k = 0; k < N; k++) { // 도
						dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
					}
				}
			}
			
			int minSum = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				int sum = 0;
				for(int j = 0; j < N; j++) {
					sum += dp[i][j];
				}
				minSum = minSum < sum ? minSum : sum;
			}
			
			sb.append("#").append(t).append(" ").append(minSum).append("\n");
		}
		
		System.out.println(sb);
	}
}
