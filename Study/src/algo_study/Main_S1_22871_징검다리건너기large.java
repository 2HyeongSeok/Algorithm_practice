package algo_study;

import java.io.*;
import java.util.*;

public class Main_S1_22871_징검다리건너기large {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		long[] dp = new long[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 0;
		for(int i = 1; i < N; i++) {
			dp[i] = Integer.MAX_VALUE;
			for(int j = 0; j < i; j++) {
				// j번째 돌까지 쓴 힘 최대 K = dp[j]와 j번째 돌에서 i번째 돌까지 가는 힘 중 최대값 구함
				// 구한 최대값과 dp[i] 비교 후 작은 걸 dp[i]에 갱신
				dp[i] = Math.min(dp[i], Math.max(dp[j], (i - j) * (1 + Math.abs(arr[i] - arr[j]))));
			}
		}
		
		System.out.println(dp[N-1]);
	}
}
