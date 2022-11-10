package algo_study;

import java.io.*;
import java.util.*;

public class Main_S3_1058_친구 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		char[][] friends = new char[N][N];
		for(int i = 0 ; i < N; i++) {
			friends[i] = br.readLine().toCharArray();
		}
		
		// 초기화 - 플로이드 워셜 사용을 위해
		int[][] fw = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(friends[i][j] == 'Y') {
					fw[i][j] = 1;
				}else {
					fw[i][j] = 100000;
				}
			}
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					fw[i][j] = Math.min(fw[i][j], fw[i][k] + fw[k][j]);
				}
			}
		}
		
		int maxCount = 0;
		for(int i = 0; i < N; i++) {
			int count = 0;
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(fw[i][j] <= 2) {
					count++;
				}
			}
			
			if(maxCount < count) {
				maxCount = count;
			}
		}
		
		System.out.println(maxCount);
	}
}
