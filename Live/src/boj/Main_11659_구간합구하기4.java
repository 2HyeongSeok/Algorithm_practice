package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11659_구간합구하기4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] line = br.readLine().split(" ");
	
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		
		int[] arrSum = new int[N + 1];

		int total = 0;
		line = br.readLine().split(" ");
		for(int t = 1; t <= N; t++) {
			total += Integer.parseInt(line[t - 1]);
			arrSum[t] = total;
		}
		
		for(int t = 0; t < M; t++) {
			line = br.readLine().split(" ");
			int i = Integer.parseInt(line[0]);
			int j = Integer.parseInt(line[1]);

			int res = arrSum[j] - arrSum[i - 1];
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
}
