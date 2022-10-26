package algo_study;

import java.io.*;
import java.util.*;

public class Main_S2_11501_주식{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] stocks = new int[N];
//			int[] maxStocks = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				stocks[i] = Integer.parseInt(st.nextToken());
//				if(stocks[i] >= totMax) { // 이전의 최대값보다 클 때만 해도 된다
//					for(int j = 0; j < i; j++) {
//						maxStocks[j] = Math.max(maxStocks[j], stocks[i] - stocks[j]);
//					}
//				}else if(stocks[i] >= max){
//					for(int j = maxIdx + 1; j < i; j++) {
//						maxStocks[j] = Math.max(maxStocks[j], stocks[i] - stocks[j]);
//					}
//				}else if(i >= 1 && stocks[i] < stocks[i-1]) {
//					totMax = max;
//					max = 0;
//				}
//				
//				if(i == N-1) {
//					for(int j = maxIdx + 1; j < i; j++) {
//						maxStocks[j] = Math.max(maxStocks[j], stocks[i] - stocks[j]);
//					}
//				}
//				
//				if(max < stocks[i]) {
//					max = stocks[i];
//					maxIdx = i;
//				}
//				// 이전의 최대값보다 작으면 애초에 전날 계산한게 최대치
			}

			int max = stocks[N-1];
			int maxIdx = N-1;
			long sum = 0;
			for(int i = N-2; i >= 0; i--) {
				if(stocks[i] > max) { // 기존까지의 최대값보다 커지면
					// 기존 값들 수익 정산
					for(int j = i + 1; j < maxIdx; j++) {
						sum += max - stocks[j];
					}
					
					// max값 갱신
					max = stocks[i];
					maxIdx = i;
				}
				
				if(i == 0) {
					for(int j = 0; j < maxIdx; j++) {
						sum += max - stocks[j];
					}
				}
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
