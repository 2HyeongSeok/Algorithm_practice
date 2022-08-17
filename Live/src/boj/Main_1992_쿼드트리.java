package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992_쿼드트리 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int total = 0;
		for (int i = 0; i < N; i++) {
			char[] lines = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = lines[j] - '0';
				total += map[i][j];
			}
		}
		
		int size = N*N;
		
		if (total == 0) {
			sb.append(0);
		} else if(total == size){
			sb.append(1);
		} else {
			zip(map, size, N, 0, 0);
		}
		System.out.println(sb);
	}

	static void zip(int[][] map, int max, int size, int r, int c) {
		if (size == 1) {
			// 기저조건
			return;
		}

		sb.append("(");

		size /= 2;
		max /= 4;
		int sum = 0;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				sum += map[i][j];
			}
		}
		if (sum == 0)
			sb.append("0");
		else if (sum == max)
			sb.append("1");
		else {
			zip(map, max, size, r, c);
		}

		sum = 0;
		for (int i = r; i < r + size; i++) {
			for (int j = c + size; j < c + size * 2; j++) {
				sum += map[i][j];
			}
		}
		if (sum == 0)
			sb.append("0");
		else if (sum == max)
			sb.append("1");
		else
			zip(map, max, size, r, c + size);

		sum = 0;
		for (int i = r + size; i < r + size * 2; i++) {
			for (int j = c; j < c + size; j++) {
				sum += map[i][j];
			}
		}
		if (sum == 0)
			sb.append("0");
		else if (sum == max)
			sb.append("1");
		else
			zip(map, max, size, r + size, c);

		sum = 0;
		for (int i = r + size; i < r + size * 2; i++) {
			for (int j = c + size; j < c + size * 2; j++) {
				sum += map[i][j];
			}
		}
		if (sum == 0)
			sb.append("0");
		else if (sum == max)
			sb.append("1");
		else {
			zip(map, max, size, r + size, c + size);
		}

		sb.append(")");
	}
}