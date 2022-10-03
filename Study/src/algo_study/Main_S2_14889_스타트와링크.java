package algo_study;

import java.io.*;
import java.util.*;

public class Main_S2_14889_스타트와링크 {
	static int N, result = Integer.MAX_VALUE;
	static int[] selected, notSelected;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 총 인원 수
		selected = new int[N/2];
		notSelected = new int[N/2];
		arr = new int[N][N];
		for(int i = 0; i < N; i++) { // i번 사람과 j번 사람이 같은 팀에 속했을 때 더해지는 능력치
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
		
		System.out.println(result);
	}
	
	static void comb(int count, int start) {
		if(count == N/2) { // 기저조건
			// 선택되지 않은 배열 만들기
			int index = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N/2; j++) {
					if(selected[j] == i)
						break;
					if(j == N/2 - 1) { // 마지막까지 왔을 때 같은게 없으면(break X)
						notSelected[index++] = i;
					}
				}
			}
			
			int sumStart = 0, sumLink = 0;
			for(int i = 0; i < N/2; i++) {
				for(int j = 0; j < N/2; j++) {
					sumStart += arr[selected[i]][selected[j]];
				}
			}
			for(int i = 0; i < N/2; i++) {
				for(int j = 0; j < N/2; j++) {
					sumLink += arr[notSelected[i]][notSelected[j]];
				}
			}
			
			result = result < Math.abs(sumStart - sumLink) ? result : Math.abs(sumStart - sumLink);
			return;
		}
		
		for(int i = start; i < N; i++) {
			selected[count] = i;
			comb(count + 1, i + 1);
		}
	}
}
