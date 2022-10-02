package boj;

import java.io.*;
import java.util.Arrays;

public class Main_S3_1463_1로만들기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1000001];

		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;

		for (int i = 4; i <= 1000000; i++) {
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
			}

			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
			}

			dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
		}

		System.out.println(dp[N]);
	}
}
