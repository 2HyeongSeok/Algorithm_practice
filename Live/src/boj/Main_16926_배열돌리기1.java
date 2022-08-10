package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
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
		rotation(N, M, R, 0);
		
		// 출력부
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void rotation(int N, int M, int R, int index) {
		// 기저조건
		// min(N,M) mod 2 = 0의 제한이 존재하므로
		if(index == minRC) {
			return;
		}
		
		// 돌릴 map 정보 큐에 담기
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i = index; i < M - index; i++)
			queue.offer(map[index][i]); 
		for(int i = index + 1; i < N - index; i++)
			queue.offer(map[i][M - index - 1]);
		for(int i = M - index - 2; i >= index; i--)
			queue.offer(map[N - index - 1][i]);
		for(int i = N - index - 2; i > index; i--)
			queue.offer(map[i][index]);
		
		// 회전
		for(int i = 0; i < R; i++)
			queue.offer(queue.poll());
		
		// 회전 후 다시 map에 넣기
		for(int i = index; i < M - index; i++) 
			map[index][i] = queue.poll();
		for(int i = index + 1; i < N - index; i++)
			map[i][M - index - 1] = queue.poll();
		for(int i = M - index - 2; i >= index; i--)
			map[N - index - 1][i] = queue.poll();
		for(int i = N - index - 2; i > index; i--) 
			map[i][index] = queue.poll();
		
		rotation(N, M, R, index + 1);
	}
}
