package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_1로만들기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int res = 0;
		int k = 4;
		
		int[] dp = new int[1000000]; // 최대
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		while(k < N) {
			int temp = 0;
			int temp2 = 0;
			int temp3 = 0;
			if(k % 3 == 0) {
				temp3 = dp[k/3] + 1;
			}
			if(k % 2 == 0) {
				temp2 = dp[k/2] + 1;
			}
			int min = Math.min(temp2, temp3);
			
			temp = dp[k - 1] + 1;
			min = Math.min(temp, min);
			k++;
		}
		
		System.out.println(dp[N]);
//		if(N <= 3) {
//			System.out.println(1);
//			return;
//		}
//		while(N >= 4) {
//			if(N % 3 == 0 && N % 2 == 0) {
//				N /= 6;
//				res ++; // 두번 나누는 것과 같으므로 한 번 더 ++!
//			}else if(N % 3 == 0) {
//				N /= 3;
//			}else if(N % 2 == 0) {
//				N /= 2;
//			}else {
//				N--;
//			}
//			res++;
//			System.out.println(N);
//		}
//		res++; //while문 탈출하면 1인 경우는 없으므로 +1
//		
//		System.out.println(res);
	}
}
