package sw;

import java.io.*;
import java.util.*;

public class Solution_1952_수영장 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[] costs;
		int[] days;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			costs = new int[4];
			days = new int[13];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 4; i++) {
				costs[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= 12; i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[13];
			for(int i = 1; i <= 12; i++) {
				int DAY = dp[i-1] + days[i] * costs[0];
				int MONTH = dp[i-1] + costs[1];
				int MON3 = (i>=3) ? dp[i-3] + costs[2] : Integer.MAX_VALUE;
				int YEAR = (i>=12) ? dp[i-12] + costs[3] : Integer.MAX_VALUE;
				dp[i] = Math.min(DAY, Math.min(MONTH, Math.min(MON3, YEAR)));
			}
			
			sb.append("#").append(t).append(" ").append(dp[12]).append("\n");
		}
		System.out.println(sb);
	}
}
