package boj;

import java.io.*;

public class Main_G4_2239_스도쿠 {
	static int zero = 0;
	static boolean flag = false;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			char[] list = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				map[i][j] = list[j] - '0';
				if (map[i][j] == 0)
					zero++;
			}
		}

		boolean breakFlag = false;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j] == 0) {
					dfs(map, i, j, 0);
					breakFlag = true;
					break;
				}
			}
			if (breakFlag)
				break;
		}

		// 출력부분
		System.out.println(sb);
	}

	static void dfs(int[][] map, int r, int c, int idx) {
		// 배열 복사
		int[][] newMap = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				newMap[i][j] = map[i][j];
			}
		}

		// 끝까지 도달
		if (idx == zero) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(newMap[i][j]);
				}
				sb.append("\n");
			}
			flag = true;

			return;
		}

		for (int i = r; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (newMap[i][j] == 0) {
					for (int k = 1; k <= 9; k++) {
						if (isPossible(newMap, i, j, k)) {
							newMap[i][j] = k;
							dfs(newMap, i, j, idx + 1);

							if (flag)
								return;
						}

						if (k == 9) {
							return;
						}
					}
				}
			}
		}
	}

	static boolean isPossible(int[][] newMap, int r, int c, int k) {
		for (int i = 0; i < 9; i++) {
			// 기저조건 (행)
			if (newMap[r][i] == k) { // 같은 숫자가 행에 존재함
				return false;
			}

			// 기저조건 (열)
			if (newMap[i][c] == k) { // 같은 숫자가 열에 존재함
				return false;
			}
		}

		// 3x3 사각형
		int minRow = 0, maxRow = 0, minCol = 0, maxCol = 0;
		if (r < 3) {
			minRow = 0;
			maxRow = 2;
		} else if (r < 6) {
			minRow = 3;
			maxRow = 5;
		} else {
			minRow = 6;
			maxRow = 8;
		}

		if (c < 3) {
			minCol = 0;
			maxCol = 2;
		} else if (c < 6) {
			minCol = 3;
			maxCol = 5;
		} else {
			minCol = 6;
			maxCol = 8;
		}

		for (int m = minRow; m <= maxRow; m++) {
			for (int n = minCol; n <= maxCol; n++) {
				if (newMap[m][n] == k) {
					return false;
				}
			}
		}

		return true;
	}
}
