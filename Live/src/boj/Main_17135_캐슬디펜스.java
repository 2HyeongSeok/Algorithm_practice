package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {

	static int[] selected;
	static int[][] map;
	static int N, M, D;
	static int killCount = 0, enemyCount = 0, totalEnemy = 0, maxKillCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M];
		int[][] tempMap = new int[N + 1][M];
		selected = new int[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				tempMap[i][j] = value;
				totalEnemy += map[i][j];
			}
		}

		comb(tempMap, 0, 0);

		System.out.println(maxKillCount);
	}

	static void comb(int[][] tempMap, int cnt, int start) {
		if (cnt == 3) {
			for (int i = 0; i < N + 1; i++) { // 맵 초기화
				for (int j = 0; j < M; j++) {
					map[i][j] = tempMap[i][j];
				}
			}

			enemyCount = 0;
			killCount = 0;

			while (enemyCount + killCount != totalEnemy) {
				attack();
				move();
			}
			
			maxKillCount = maxKillCount > killCount ? maxKillCount : killCount;

			return;
		}

		for (int i = start; i < M; i++) {
			selected[cnt] = i;
			comb(tempMap, cnt + 1, i + 1);
		}
	}

	static void attack() {
		ArrayList<Integer[]> rowColList = new ArrayList<>();
		int distance = 2*N + 1, left = M + 1, row = -1;
		for (int i = 0; i < 3; i++) {
			distance = 2*N + 1; // 가장 멀다고 가정
			left = M + 1; // 가장 오른쪽 시작 가정
			row = -1; // 가장 위 가정

			for (int m = N - 1; m >= 0; m--) {
				for (int n = M - 1; n >= 0; n--) {
					if (map[m][n] == 1) {
						// 적과 i번째 궁수와의 거리
						int tempD = Math.abs(N - m) + Math.abs(selected[i] - n);
						if (tempD <= D) {
							if (tempD < distance) {
								distance = tempD; // 가장 가까운 적 갱신하면 현재 정보 저장
								row = m;
								left = n; 
							}else if(tempD == distance) { // 가장 가까운 적이 여럿이면 더 왼쪽인걸로 저장
								if (n < left) {
									row = m;
									left = n; // 가장 왼쪽 찾기
								}
							}
						}
					}
				}
			}
			if (row != -1 && left != M + 1)
				rowColList.add(new Integer[] { row, left });

		}

		// 찾은 적 제거
		for (int i = 0; i < rowColList.size(); i++) {
			if (map[rowColList.get(i)[0]][rowColList.get(i)[1]] == 1) {
				map[rowColList.get(i)[0]][rowColList.get(i)[1]] = 0;
				killCount++;
			}
		}
	}

	static void move() { // 한 칸 밑으로
		for (int i = 0; i < M; i++) {
			if (map[N - 1][i] == 1)
				enemyCount++; // 사라질 애들 카운팅
		}

		// 맵 덮어쓰기
		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < M; j++) { 
				map[i + 1][j] = map[i][j];
			}
		}

		for (int i = 0; i < M; i++) {
			map[0][i] = 0;
		}
	}
}
