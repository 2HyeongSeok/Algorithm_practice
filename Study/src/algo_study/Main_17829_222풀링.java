package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_17829_222풀링 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for(int j = 0; j < N; j++)
				// 배열 저장
				arr[i][j] = Integer.parseInt(line[j]);
		}
		
		while(N >= 4) {
			// 4 풀링하면 2
			N /= 2;
			int[][] newArr = new int[N][N];
			
			int[] compare = new int[4];
			for(int row = 0; row < 2 * N; row += 2) {
				for(int col = 0; col < 2 * N; col += 2) {
					int index = 0;
					for(int i = row; i < row + 2; i++)
						for(int j = col; j < col + 2; j++) {
							compare[index++] = arr[i][j];
						}
					
					// 두번째로 큰 수 찾기
					Arrays.sort(compare);
					newArr[row/2][col/2] = compare[2];
				}
			}
			// 배열 복사
			arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = newArr[i][j];
				}
			}
		}

		int last = 0;
		if(N == 2) {
			// 마지막 풀링
			int[] compare = new int[4];
			for(int row = 0; row < N; row += 2) {
				for(int col = 0; col < N; col += 2) {
					int index = 0;
					for(int i = row; i < row + 2; i++)
						for(int j = col; j < col + 2; j++)
							compare[index++] = arr[i][j];
					
					// 두번째로 큰 수 찾기
					Arrays.sort(compare);
					last = compare[2];
				}
			}
		}
		
		System.out.println(last);
	}
}
