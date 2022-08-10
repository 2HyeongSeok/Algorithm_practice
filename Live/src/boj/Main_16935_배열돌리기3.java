package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기3 {
	static int[][] map;
	static int[][] resMap;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 배열의 크기 NxM
		M = Integer.parseInt(st.nextToken());
		
		int R = Integer.parseInt(st.nextToken()); // 연산의 수 R
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < R; i++) {
			int order = Integer.parseInt(st.nextToken());
			mode(order);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(resMap[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void mode(int order) {
		int halfN, halfM;
		int[][] maps;
		
		if(order <= 2 || order >= 5) resMap = new int[N][M];
		else resMap = new int[M][N];
		
		switch(order) {
		case 1: // 상하반전
			for(int i = 0; i < N; i++) 
				for(int j = 0; j < M; j++) 
					resMap[i][j] = map[N - i - 1][j];
			break;
		case 2: // 좌우반전
			for(int i = 0; i < N; i++) 
				for(int j = 0; j < M; j++) 
					resMap[i][j] = map[i][M - j - 1];
			break;
		case 3: // 오른쪽 90도 회전
			for(int i = 0; i < N; i++) 
				for(int j = 0; j < M; j++) 
					resMap[j][N - i - 1] = map[i][j];
			break;
		case 4: // 왼쪽 90도 회전
			for(int i = 0; i < N; i++) 
				for(int j = 0; j < M; j++) 
					resMap[M - j - 1][i] = map[i][j];
			break;
		case 5: // 4개의 배열로 쪼개서 1->2->3->4->1
			halfN = N / 2;
			halfM = M / 2;
			maps = new int[halfN][halfM];
			for(int i = 0; i < halfN; i++) 
				for(int j = 0; j < halfM; j++)  // 4번을 임시배열에 넣어두고
					maps[i][j] = map[i + halfN][j];
			for(int i = 0; i < halfN; i++) 
				for(int j = 0; j < halfM; j++)  // 3번을 4번에
					resMap[i + halfN][j] = map[i + halfN][j + halfM];
			for(int i = 0; i < halfN; i++) 
				for(int j = 0; j < halfM; j++)  // 2번을 3번에
					resMap[i + halfN][j + halfM] = map[i][j + halfM];
			for(int i = 0; i < halfN; i++) 
				for(int j = 0; j < halfM; j++)  // 1번을 2번에
					resMap[i][j + halfM] = map[i][j];
			for(int i = 0; i < halfN; i++) 
				for(int j = 0; j < halfM; j++)  // 4번 임시배열에서 1번에
					resMap[i][j] = maps[i][j];
			
			break;
		case 6: // 4개의 배열로 쪼개서 1->4->3->2->1
			halfN = N / 2;
			halfM = M / 2;
			maps = new int[halfN][halfM];
			for(int i = 0; i < halfN; i++) 
				for(int j = 0; j < halfM; j++)  // 1번을 임시배열에 넣어두고
					maps[i][j] = map[i][j];
			for(int i = 0; i < halfN; i++) 
				for(int j = 0; j < halfM; j++)  // 2번을 1번에
					resMap[i][j] = map[i][j + halfM];
			for(int i = 0; i < halfN; i++) 
				for(int j = 0; j < halfM; j++)  // 3번을 2번에
					resMap[i][j + halfM] = map[i + halfN][j + halfM];
			for(int i = 0; i < halfN; i++) 
				for(int j = 0; j < halfM; j++)  // 4번을 3번에
					resMap[i + halfN][j + halfM] = map[i + halfN][j];
			for(int i = 0; i < halfN; i++) 
				for(int j = 0; j < halfM; j++)  // 1번을 4번에
					resMap[i + halfN][j] = maps[i][j];
			break;
		default:
			break;
		}
		
		// 변경 값 반영
		if(order == 3 || order == 4) {
			int temp = N;
			N = M;
			M = temp;
		}
		map = resMap;
	}
}
