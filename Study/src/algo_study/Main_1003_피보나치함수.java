package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003_피보나치함수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] cnt0 = new int[41];
			cnt0[0] = 1;
			cnt0[1] = 0;
			int[] cnt1 = new int[41];
			cnt1[0] = 0;
			cnt1[1] = 1;
			
			if(N == 0) {
				sb.append(cnt0[0] + " " + cnt1[0] + "\n");
			}else if(N == 1) {
				sb.append(cnt0[1] + " " + cnt1[1] + "\n");
			}else {
				for(int k = 2; k <= N; k++) {
					cnt0[k] = cnt0[k - 1] + cnt0[k - 2];
					cnt1[k] = cnt1[k - 1] + cnt1[k - 2];
				}
				
				sb.append(cnt0[N] + " " + cnt1[N] + "\n");
			}
		}
		System.out.println(sb);
	}
}
