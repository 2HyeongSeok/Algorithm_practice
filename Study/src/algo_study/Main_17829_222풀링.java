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
			// 4여야 마지막으로 222 풀링 가능
			int[][] newArr = new int[N/4][N/4];
			
			int[] compare = new int[4];
			for(int row = 0; row < N; row += 2) {
				for(int col = 0; col < N; col += 2) {
					int secVal = -10001; // 두번째로 큰 수 저장할 공간
					int index = 0;
					for(int i = row; i < row + 2; i++)
						for(int j = col; j < col + 2; j++)
							compare[index++] = arr[i][j];
					
					// 두번째로 큰 수 찾기
					Arrays.sort(compare);
					secVal = compare[2];
					newArr[row/2][col/2] = secVal;
				}
			}
		}
		
		
		
	}
}
