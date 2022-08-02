package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805_농작물수확하기 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			// 농장 크기
			int N = Integer.parseInt(br.readLine());

			int sum = 0;
			// 농작물 입력받기
			int[][] values = new int[N][N];
			for(int i = 0; i < N; i++) {
				String[] line = br.readLine().split("");
				for(int j = 0; j < N; j++) {
					values[i][j] = Integer.parseInt(line[j]);
					if(N / 2 == i) {
						sum += values[i][j]; // 가운데 합 구해두기
					}
				}
			}
			sb.append("#").append(t).append(" ");
			
			int row = N/2;
			if(row == 0) sb.append(sum).append("\n");
			else {
				int up = summationValues(values, row - 1, N, 1); // 위로
				int down = summationValues(values, row + 1, N, 1); // 아래로
				sum += up + down;
				sb.append(sum).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static int summationValues(int[][] values, int row, int N, int index) {
		int sum = 0;
		// 기저조건
		if(row == 0 || row == N - 1) {
			return values[row][N/2];
		}
		
		// 아니면 계산
		for(int i = index; i < N - index; i++) {
			sum += values[row][i];
		}
		
		if(row < N / 2)
			return sum + summationValues(values, row - 1, N, ++index); // 위로
		else
			return sum + summationValues(values, row + 1, N, ++index); // 아래로
	}
}
