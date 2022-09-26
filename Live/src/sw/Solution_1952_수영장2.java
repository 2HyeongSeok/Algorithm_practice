package sw;

import java.io.*;
import java.util.*;

public class Solution_1952_수영장2 {
	
	static int min;
	
	static int[] costs, days;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			costs = new int[4];
			days = new int[13];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 4; i++) {
				costs[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 12; i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			
			min = costs[3];
			dfs(0, 0);
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int idx, int sum) {
		if(idx >= 12) {
			if(min > sum) min = sum;
			return;
		}
		
		dfs(idx + 1, sum + days[idx + 1] * costs[0]);
		dfs(idx + 1, sum + costs[1]);
		dfs(idx + 3, sum + costs[2]);
	}
}
