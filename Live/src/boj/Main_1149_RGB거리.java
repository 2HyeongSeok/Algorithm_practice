package boj;

import java.io.*;
import java.util.*;

public class Main_1149_RGB거리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] rgbMap = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rgbMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				if(j == 0) {
					rgbMap[i][j] += Math.min(rgbMap[i-1][1], rgbMap[i-1][2]);
				}else if(j == 1) {
					rgbMap[i][j] += Math.min(rgbMap[i-1][0], rgbMap[i-1][2]);
				}else {
					rgbMap[i][j] += Math.min(rgbMap[i-1][0], rgbMap[i-1][1]);
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			if(min > rgbMap[N-1][i]) min = rgbMap[N-1][i];
		}
		
		System.out.println(min);
	}
}
