package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001_파리퇴치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 누적 값 구하기
			int[][] sumMap = new int[N + 1][N + 1];
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 1; j <= N; j++) {
					sumMap[i][j] = sumMap[i - 1][j] + sumMap[i][j - 1] - sumMap[i - 1][j - 1] + Integer.parseInt(st.nextToken());
				}
			}
			
			int sum;
			int max = 0;
			for(int i = M; i <= N; i++) {
				for(int j = M; j <= N; j++) {
					sum = sumMap[i][j] - sumMap[i - M][j] - sumMap[i][j - M] + sumMap[i - M][j - M];
					max = Math.max(sum, max);
				}
			}
			
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
