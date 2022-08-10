package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {
	static int minRC; 
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		minRC = Math.min(N, M) / 2;
		
		int R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// R번 회전
		for(int i = 0; i < R; i++) {
			rotation(N, M, 0);
		}
		
		// 출력부
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void rotation(int N, int M, int index) {
		// 기저조건
		// min(N,M) mod 2 = 0의 제한이 존재하므로
		if(index == minRC) {
			return;
		}
		
		// 회전
		int temp = map[index][index];
		for(int i = index; i < M - index - 1; i++) // index 행 왼쪽으로 보내기
			map[index][i] = map[index][i + 1];
		for(int i = index; i < N - index - 1; i++) // M - index 열 위로 보내기
			map[i][M - index - 1] = map[i + 1][M - index - 1];
		for(int i = M - index - 1; i > index; i--) {
			map[N - index - 1][i] = map[N - index - 1][i - 1]; // N - index 행 오른쪽으로 보내기
		}
		for(int i = N - index - 1; i > index + 1; i--) { // index 열 아래로 보내기 ([index][index]는 temp이므로 따로 해줘야함)
			map[i][index] = map[i - 1][index];
		}
		map[index + 1][index] = temp;
		
		rotation(N, M, index + 1);
	}
}
