package algorithm;

import java.io.*;
import java.util.*;

public class Main_S1_9465_½ºÆ¼Ä¿ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[2][n];
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] dp = new int[2][n];
			int maxVal = 0;
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			if(n == 1)
				maxVal = Math.max(dp[0][0], dp[1][0]);

			else if(n > 1) {
				dp[0][1] = dp[1][0] + arr[0][1];
				dp[1][1] = dp[0][0] + arr[1][1];
				maxVal = max(dp[0][1], dp[1][1], maxVal);
				
				for(int i = 2; i < n; i++) {
					for(int j = 0; j < 2; j++) {
						if(j == 0) {
							dp[j][i] = Math.max(dp[j+1][i-1], dp[j+1][i-2]) + arr[j][i];
						}else {
							dp[j][i] = Math.max(dp[j-1][i-1], dp[j-1][i-2]) + arr[j][i];
						}
						maxVal = maxVal > dp[j][i] ? maxVal : dp[j][i];
					}
				}
			}
			
			sb.append(maxVal).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int max(int a, int b, int c) {
		if(a >= b && a >= c) return a;
		if(b >= a && b >= c) return b;
		return c;
	}
}
