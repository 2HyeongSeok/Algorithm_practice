package boj_class04;

import java.io.*;
import java.util.*;

public class Main_S2_11053_가장긴증가하는부분순열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxLength = 1;
		int[] dp = new int[N];
		dp[0] = 1;
		for(int i = 1; i < N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					maxLength = maxLength > dp[i] ? maxLength : dp[i];
				}
			}
		}
		
		System.out.println(maxLength);
	}
}
