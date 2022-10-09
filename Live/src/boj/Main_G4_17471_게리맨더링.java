package boj;

import java.io.*;
import java.util.*;

public class Main_G4_17471_게리맨더링 {
	static int N, minDiff = Integer.MAX_VALUE;
	static int[] selected, people;
	static int[][] adjMap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 구역의 수
		selected = new int[N];

		people = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		adjMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(adjMap[i], 1000);
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			for (int k = 0; k < num; k++) {
				int node = Integer.parseInt(st.nextToken()) - 1;
				adjMap[i][node] = adjMap[node][i] = 1;
			}

		}
		subset(0);
		minDiff = minDiff == Integer.MAX_VALUE ? -1 : minDiff;

		System.out.println(minDiff);
	}

	static void subset(int count) {
		if (count == N) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				sum += selected[i];
			}
			if(sum == 0 || sum == 6) return; // 불가능한 케이스
			
			
			int[][] tempMap = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					tempMap[i][j] = adjMap[i][j];
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (selected[i] != selected[j]) {
						// 둘이 같지 않음
						if (adjMap[i][j] == 1) { // 갈 수 있던 곳 끊어버려!
							tempMap[i][j] = tempMap[j][i] = 1000;
						}
					}
				}
			}
			
			// 플로이드 워셜 -> 이동이 가능한가? 확인하기 위함
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						tempMap[i][j] = Math.min(tempMap[i][j], tempMap[i][k] + tempMap[k][j]);
					}
				}
			}

			// 불가능한 케이스 쳐내기
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (selected[i] == selected[j]) {
						// 둘이 같은데 갈 수 없다면
						if (tempMap[i][j] >= 1000) { // 불가능한 케이스
							return;
						}
					}
				}
			}

			// 인구수 차이 구하기
			int first = 0, second = 0;
			for (int i = 0; i < N; i++) {
				if (selected[i] == 1)
					first += people[i];
				else
					second += people[i];
			}
			minDiff = minDiff < Math.abs(first - second) ? minDiff : Math.abs(first - second);

			return;
		}

		selected[count] = 1;
		subset(count + 1);
		selected[count] = 0;
		subset(count + 1);
	}
}
