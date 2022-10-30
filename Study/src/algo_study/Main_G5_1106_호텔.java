package algo_study;

import java.io.*;
import java.util.*;

public class Main_G5_1106_호텔 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int maxCost = 0, max = 0;
		int[] costs = new int[N];
		int[] customers = new int[N];
		for(int k = 0; k < N; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cost = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());
			
			max = Math.max(C * (cost / customer + 1), max);
			maxCost = Math.max(maxCost, cost);
			costs[k] = cost;
			customers[k] = customer;
		}
		
		int[][] dp = new int[N+1][max+maxCost];
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < max+maxCost; j++) {
				if(costs[i-1] <= j) {
					dp[i][j] = Math.max(customers[i-1] + dp[i-1][j-costs[i-1]], dp[i-1][j]);
					dp[i][j] = Math.max(dp[i][j], customers[i-1] + dp[i][j-costs[i-1]]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 1; i < max+maxCost; i++) {
			if(dp[N][i] >= C) {
				min = i;
				break;
			}
		}
		
		System.out.println(min);
	}
}
