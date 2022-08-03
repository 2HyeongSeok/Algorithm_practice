package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10250_ACM호텔 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			String[] line = br.readLine().split(" ");
			int H = Integer.parseInt(line[0]); // 층 수
			int W = Integer.parseInt(line[1]); // 층별 호 수
			int N = Integer.parseInt(line[2]); // N번째 손님
			
			int ho = 0;
			ho += ((N - 1) % H + 1) * 100; // 층
			ho += (N - 1) / H + 1; // 호
			
			sb.append(ho).append("\n");
		}
		
		System.out.println(sb);
	}
}
