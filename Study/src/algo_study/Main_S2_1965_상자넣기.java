package algo_study;

import java.io.*;
import java.util.*;

public class Main_S2_1965_상자넣기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int[] boxes = new int[n];
		for(int i = 0; i < n; i++) {
			boxes[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 1;
		int[] dp = new int[n];
		dp[0] = 1;
		for(int i = 1; i < n; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(boxes[i] > boxes[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					max = max > dp[i] ? max : dp[i];
				}
			}
		}
		
		System.out.println(max);
	}
}
