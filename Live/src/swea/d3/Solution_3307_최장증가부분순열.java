package swea.d3;

import java.io.*;
import java.util.*;

public class Solution_3307_최장증가부분순열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[N];
			dp[0] = 1;
			for(int i = 1; i < N; i++) {
				dp[i] = 1;
				for(int j = 0; j < i; j++) {
					if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
			}
			
			int max = 0;
			for(int i = 0; i < N; i++) {
				max = max > dp[i] ? max : dp[i];
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
	}
}
