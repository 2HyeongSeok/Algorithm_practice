package boj_class03;

import java.io.*;

public class Main_S3_9461_파도반수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long[] dp = new long[101];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		for(int i = 6; i <= 100; i++) {
			dp[i] = dp[i-5] + dp[i-1];
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb);
	}
}
