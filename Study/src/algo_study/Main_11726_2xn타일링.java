package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11726_2xn타일링 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= 1000; i++) {
			dp[i] = dp[i-1] + dp[i-2] * 2;
		}
		
		System.out.println(dp[n] % 10007);
	}
}
