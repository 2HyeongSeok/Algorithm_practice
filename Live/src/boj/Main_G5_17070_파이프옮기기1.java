package boj;

import java.io.*;
import java.util.*;

public class Main_G5_17070_파이프옮기기1 {
	static int N, count = 0;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		arr[0][1] = 2;

		dfs(0, 1);

		System.out.println(count);
	}

	static void dfs(int row, int col) {
		if (row == N - 1 && col == N - 1) {
			count++;
			return;
		}

		switch (arr[row][col]) {
		case 2: // 가로
			if (col + 1 < N && arr[row][col + 1] == 0) {
				// 오른쪽으로 이동이 가능
				arr[row][col + 1] = 2;
				dfs(row, col + 1);
				arr[row][col + 1] = 0;
			}
			if (col + 1 < N && row + 1 < N && arr[row][col + 1] == 0 && arr[row + 1][col] == 0
					&& arr[row + 1][col + 1] == 0) {
				// 오른쪽 대각선 아래로 이동 가능
				arr[row + 1][col + 1] = 3;
				dfs(row + 1, col + 1);
				arr[row + 1][col + 1] = 0;
			}
			break;
		case 3: // 대각선 (우하향)
			if (col + 1 < N && arr[row][col + 1] == 0) {
				// 오른쪽으로 이동이 가능
				arr[row][col + 1] = 2;
				dfs(row, col + 1);
				arr[row][col + 1] = 0;
			}
			if (row + 1 < N && arr[row + 1][col] == 0) {
				// 아래쪽으로 이동이 가능
				arr[row + 1][col] = 4;
				dfs(row + 1, col);
				arr[row + 1][col] = 0;
			}
			if (col + 1 < N && row + 1 < N && arr[row][col + 1] == 0 && arr[row + 1][col] == 0
					&& arr[row + 1][col + 1] == 0) {
				// 오른쪽 대각선 아래로 이동 가능
				arr[row + 1][col + 1] = 3;
				dfs(row + 1, col + 1);
				arr[row + 1][col + 1] = 0;
			}
			break;
		case 4: // 세로
			if (row + 1 < N && arr[row + 1][col] == 0) {
				// 아래쪽으로 이동이 가능
				arr[row + 1][col] = 4;
				dfs(row + 1, col);
				arr[row + 1][col] = 0;
			}
			if (col + 1 < N && row + 1 < N && arr[row][col + 1] == 0 && arr[row + 1][col] == 0
					&& arr[row + 1][col + 1] == 0) {
				// 오른쪽 대각선 아래로 이동 가능
				arr[row + 1][col + 1] = 3;
				dfs(row + 1, col + 1);
				arr[row + 1][col + 1] = 0;
			}
			break;
		default:
			break;
		}
	}
}
