package boj;

import java.io.*;

public class Main_G4_2239_스도쿠 {
	static int min;
	static int[][] finalMap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] map = new int[9][9];
		finalMap = new int[9][9];
		for (int i = 0; i < 9; i++) {
			char[] list = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				map[i][j] = list[j] - '0';
			}
		}

		min = Integer.MAX_VALUE;
		boolean breakFlag = false;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(map[i][j] == 0) {
					dfs(map, i, j);
					breakFlag = true;
					break;
				}
			}
			if(breakFlag) break;
		}
		
		// 출력부분
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(finalMap[i][j]);
			}
			System.out.println();
		}
	}

	static void dfs(int[][] map, int r, int c) {
		// 배열 복사
		int[][] newMap = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		
//		// 출력부분
//		System.out.println("-----------------------------------");
//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 9; j++) {
//				System.out.print(newMap[i][j]);
//			}
//			System.out.println();
//		}

		// 불가능한 기저조건
		if (newMap[r][c] != 0) {
			for (int i = 0; i < 9; i++) {
				// 기저조건 (행)
				if (i != c && newMap[r][i] == newMap[r][c]) { // 같은 숫자가 행에 존재함

					return;
				}

				// 기저조건 (열)
				if (i != r && newMap[i][c] == newMap[r][c]) { // 같은 숫자가 열에 존재함

					return;
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
					if ((m != r || n != c) && newMap[m][n] == newMap[r][c]) {

						return;
					}
				}
			}
			

			// 끝까지 도달
			if (r == 8 && c == 8) {
				int sum = 0;
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						sum += newMap[i][j];
					}
				}

				if (sum < min) { // 갱신이 필요
					for (int i = 0; i < 9; i++) {
						for (int j = 0; j < 9; j++) {
							finalMap[i][j] = newMap[i][j];
						}
					}
				}
				return;
			}
		}

		for (int i = r; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				for (int k = 1; k <= 9; k++) {
					if (newMap[i][j] == 0) { // 순열조합 푸는 것처럼
						newMap[i][j] = k;
						dfs(newMap, i, j);
						newMap[i][j] = 0;
					}
				}
			}
		}
	}
}
