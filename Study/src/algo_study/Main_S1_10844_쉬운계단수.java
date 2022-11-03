package algo_study;

import java.io.*;

public class Main_S1_10844_쉬운계단수 {
	static final int div = 1000000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] dp = new int[N][10];
		dp[0][0] = 0;
		for(int i = 1; i < 10; i++) {
			dp[0][i] = 1;
		}
		
		for(int i = 1; i < N; i++) {
			dp[i][0] = dp[i-1][1] % div;
			for(int j = 1; j < 9; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % div;
			}
			dp[i][9] = dp[i-1][8] % div;
		}
		
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += dp[N-1][i];
			sum %= div;
		}
		System.out.println(sum);
	}
}
