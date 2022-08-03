package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11660_구간합구하기5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] line = br.readLine().split(" ");
		
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		
		int[][] sumMap = new int[N+1][N+1];	// 배열 합 미리 구해두기
		
		for(int i = 1; i <= N; i++) {
			line = br.readLine().split(" ");
			for(int j = 1; j <= N; j++) {
				int sum = sumMap[i][j - 1] + sumMap[i - 1][j] - sumMap[i - 1][j - 1] + Integer.parseInt(line[j - 1]);
				sumMap[i][j] = sum;
			}
		}
		
		for(int i = 1; i <= M; i++) {
			line = br.readLine().split(" ");
			int x1 = Integer.parseInt(line[0]);
			int y1 = Integer.parseInt(line[1]);
			int x2 = Integer.parseInt(line[2]);
			int y2 = Integer.parseInt(line[3]);
			
			int result = sumMap[x2][y2] - sumMap[x1 - 1][y2] - sumMap[x2][y1 - 1] + sumMap[x1 - 1][y1 - 1]; // 중복해서 빼는 x1,y1의 누적합은 다시 더해줌
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
