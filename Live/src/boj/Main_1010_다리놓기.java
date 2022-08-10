package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 미리 계산
		BigInteger[][] dp = new BigInteger[30][30]; // N, M 순서
		for(int i = 0; i < 30; i++) {
			dp[0][i] = new BigInteger("0");
		}
		
		for(int i = 1; i < 30; i++) {
			BigInteger parent = new BigInteger("1");

			for(int k = 1; k <= i; k++) {
				parent = parent.multiply(new BigInteger(Integer.toString(k)));
			}
			
			for(int j = i; j < 30; j++) {
				// child 계산해야함
				BigInteger child = new BigInteger("1");
				for(int k = 0; k < i; k++) {
					child = child.multiply(new BigInteger(Integer.toString(j - k)));
				}
				
				dp[i][j] = child.divide(parent);
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			BigInteger count = new BigInteger("0");
			
			count = count.add(dp[N][M]);
			sb.append(count).append("\n");
		}
		
		System.out.println(sb);
	}
}
