package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579_계단오르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] scores = new int[N+1];
		for(int i = 1; i <= N; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] dp = new int[N+1][2];
		
		dp[1][0] = scores[1];
		dp[1][1] = scores[1];
		
		if(N >= 2) {
			dp[2][0] = scores[2]; // dp[0][0] dp[0][1] 모두 0임!
			dp[2][1] = dp[1][1] + scores[2];
		}
		
		for(int k = 3; k <= N; k++) {
			dp[k][0] = Math.max(dp[k-2][1] + scores[k], dp[k-2][0] + scores[k]); // 2계단씩 오를 경우도 있음
			dp[k][1] = dp[k-1][0] + scores[k];
		}	
		
		int max = Math.max(dp[N][0], dp[N][1]);
		System.out.println(max);
	}
}
