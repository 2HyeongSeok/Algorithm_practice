package algo_study;

import java.io.*;
import java.util.*;

public class Main_S3_17626_FourSquares {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N + 1];
		Arrays.fill(dp, 5);
		for(int i = 1; i*i <= N; i++) {
			dp[i*i] = 1;
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j*j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[j*j] + dp[i-j*j]);
			}
		}
		
		System.out.println(dp[N]);
	}
}
