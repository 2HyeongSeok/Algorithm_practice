package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10157_자리배정 {
	static int totalCnt = 0;
	static int finalRow = -1;
	static int finalCol = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		// R + (C-1) + (R-1) + (C-2) 재귀!!
		reCalc(R, C, K, 0);
		
		if(finalRow != -1 && finalCol != -1) {
			sb.append(finalCol).append(" ").append(finalRow);
		}else {
			sb.append(0);
		}
		System.out.println(sb);
	}
	
	static void reCalc(int R, int C, int K, int call) {		
		int tempCnt = R + (C-1) + (R-1) + (C-2);
		totalCnt += tempCnt;
		if(totalCnt < K) {
			if(R - 2 < 1 || C - 2 < 1) return;
			reCalc(R - 2, C - 2, K, call + 1);
		}else {
			int tempValue = K - (totalCnt - tempCnt); // 이전 값까지 비교
			if(tempValue <= R) {
				finalRow = call + tempValue;
				finalCol = (call + 1);
			}else if(tempValue <= R + C - 1) {
				finalRow = call + R;
				finalCol = (call + 1) + (tempValue - R);
			}else if(tempValue <= 2 * R + C - 2) {
				finalRow = call + (R - (tempValue - (R + C - 1)));
				finalCol = call + C;
			}else {
				finalRow = (call + 1);
				finalCol = call + (C - (tempValue - (2 * R + C - 2)));
			}
		}
		
	}
}
