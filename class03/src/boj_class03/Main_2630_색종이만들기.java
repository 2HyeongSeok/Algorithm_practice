package boj_class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {
	static int[][] map;
	static int blue = 0, white = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		make(0, 0, N);
		
		sb.append(white).append("\n").append(blue);
		System.out.println(sb);
	}
	
	static void make(int row, int col, int size) {
		if(size == 1) { // 기저조건
			if(map[row][col] == 1) blue++;
			else white++;
			
			return;
		}
		
		int sum = 0;
		for(int i = row; i < size + row; i++) {
			for(int j = col; j < size + col; j++) {
				sum += map[i][j];
			}
		}
		
		if(sum == size * size) {
			// 파란색
			blue++;
		}else if(sum == 0){
			// 모두 0이면 흰색
			white++;
		}else {
			// 4분할 돌리기
			make(row, col, size/2);
			make(row, col + size/2, size/2);
			make(row + size/2, col, size/2);
			make(row + size/2, col + size/2, size/2);
		}
	}
}
