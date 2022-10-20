package algo_study;

import java.io.*;
import java.util.*;

public class Main_S1_1389_케빈베이컨의6단계법칙 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[101][101];
		for(int i = 1; i <= N; i++) {
			Arrays.fill(map[i], 1000);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = map[b][a] = 1;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		int min = 10000, minIdx = -1;
		for(int i = 1; i <= N; i++) {
			int temp = 0;
			for(int j = 1; j <= N; j++) {
				if(i == j) continue;
				
				temp += map[i][j];
			}
			if(min > temp) {
				min = temp;
				minIdx = i;
			}
		}
		
		System.out.println(minIdx);
	}
}
