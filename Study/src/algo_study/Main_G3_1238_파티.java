package algo_study;

import java.io.*;
import java.util.*;

public class Main_G3_1238_파티 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 단방향 도로
		int X = Integer.parseInt(st.nextToken())-1; // X번 마을
		
		int[][] road = new int[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(road[i], 1000000); // 백만으로 초기화 1000 * 100이 가장 큰 경우라고 생각하고 대충..
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int dist = Integer.parseInt(st.nextToken());
			
			road[from][to] = dist;
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					road[i][j] = Math.min(road[i][j], road[i][k] + road[k][j]);
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			if(road[i][X] >= 1000000 || road[X][i] >= 1000000) continue;
			
			if(i == X) max = max > 1 ? max : 1;
			else max = max > road[i][X] + road[X][i] ? max : road[i][X] + road[X][i];
		}
		
		System.out.println(max);
	}
}
