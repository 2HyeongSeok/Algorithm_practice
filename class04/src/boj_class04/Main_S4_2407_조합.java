package boj_class04;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main_S4_2407_조합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		BigInteger[][] dp = new BigInteger[n+1][n+1];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
				dp[i][j] = new BigInteger("0");
			}
		}
		
		for(int i = 1; i <= n; i++) { // nC0, nC1 기본설정
			dp[i][0] = new BigInteger("1");
			dp[i][1] = new BigInteger(Integer.toString(i));
		}
		
		for(int i = 2; i <= n; i++) {
			for(int j = 2; j <= i; j++) {
				dp[i][j] = dp[i-1][j].add(dp[i-1][j-1]);
			}
		}
		
		System.out.println(dp[n][m]);
	}
}
