package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] row = new int[N + 1]; // row 좌표 정보
		int[] col = new int[N + 1]; // col 좌표 정보
		int[][] map = new int[101][101];

		int size = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			row[i] = Integer.parseInt(st.nextToken());
			col[i] = Integer.parseInt(st.nextToken());
			
			for (int m = row[i]; m < row[i] + 10; m++) {
				for (int n = col[i]; n < col[i] + 10; n++) {
					if(map[m][n] != 1) {
						size++;
						map[m][n] = 1;
					}
				}
			}
		}
		
		System.out.println(size);
	}
}
