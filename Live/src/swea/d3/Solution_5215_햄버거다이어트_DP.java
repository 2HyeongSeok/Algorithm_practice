package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트_DP {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			
			int[] scores = new int[N+1];
			int[] kcals = new int[N+1];
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				scores[i] = Integer.parseInt(st.nextToken());
				kcals[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] dp = new int[N+1][L+1];
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= L; j++) {
					if(j - kcals[i] >= 0) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-kcals[i]] + scores[i]);
					}else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
			
			sb.append(dp[N][L]).append("\n");
		}
		System.out.println(sb);
		
	}
}
