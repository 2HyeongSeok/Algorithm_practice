package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2669_직사각형네개의합집합의면적구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] x = new int[2];
		int[] y = new int[2];
		int[][] map = new int[101][101];
		for(int k = 0; k < 4; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			x[0] = Integer.parseInt(st.nextToken());
			y[0] = Integer.parseInt(st.nextToken());
			x[1] = Integer.parseInt(st.nextToken());
			y[1] = Integer.parseInt(st.nextToken());
			
			for(int i = x[0]; i < x[1]; i++) {
				for(int j = y[0]; j < y[1]; j++) {
					map[i][j] = 1;
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i <= 100; i++) {
			for(int j = 0; j <= 100; j++) {
				if(map[i][j] == 1) count++;
			}
		}
		System.out.println(count);
	}
}
