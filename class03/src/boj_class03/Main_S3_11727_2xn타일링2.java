package boj_class03;

import java.io.*;

public class Main_S3_11727_2xn타일링2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[] dp = new long[1001];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		dp[3] = 5;
		for(int i = 3; i <= 1000; i++) {
			// dp[i-1] -> i-1칸의 마지막 + 'ㅣ' 모양 -> 1가지
			// dp[i-2] -> i-2칸의 마지막 + '=' 또는 'ㅁ' 또는 'ㅣㅣ'인데, 'ㅣㅣ'는 위의 케이스랑 겹침 -> 2가지
			dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007; 
		}
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(dp[n]);
	}
}
