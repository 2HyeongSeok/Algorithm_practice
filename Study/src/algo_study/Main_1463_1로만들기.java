package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_1로만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		if(N == 1) {
			System.out.println(0);
			return;
		} else if(N <= 3) {
			// 2, 3이면 무조건 1회가 최소!
			System.out.println(1);
			return;
		}
		
		int[] dp = new int[N + 1]; // 인덱스 맞추려고!
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		for(int k = 4; k <= N; k++) {
			dp[k] = dp[k - 1] + 1; // 미리 -- 하는 케이스로 저장해두기 *스터디팁*
			if(k % 6 == 0) {
				// 6으로 나누어지는 경우
				dp[k] = calcMin(dp[k - 1], dp[k / 2], dp[k / 3]) + 1;
			}else if(k % 3 == 0) {
				// 3으로 나누어지는 경우
				dp[k] = Math.min(dp[k - 1], dp[k / 3]) + 1;
			}else if(k % 2 == 0) {
				// 2로 나누어지는 경우
				dp[k] = Math.min(dp[k - 1], dp[k / 2]) + 1;
			}
		}
		
		System.out.println(dp[N]);
	}
	
	static int calcMin(int a, int b, int c) {
		if(a >= c && b >= c) return c;
		else if(a >= b && c >= b) return b;
		else return a;
	}
}
