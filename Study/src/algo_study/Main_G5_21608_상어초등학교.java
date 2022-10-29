package algo_study;

import java.io.*;
import java.util.*;

public class Main_G5_21608_상어초등학교 {
	static class Student implements Comparable<Student> {
		int row, col, favorCnt, emptyCnt;

		public Student(int row, int col, int favorCnt, int emptyCnt) {
			super();
			this.row = row;
			this.col = col;
			this.favorCnt = favorCnt;
			this.emptyCnt = emptyCnt;
		}

		@Override
		public int compareTo(Student o) {
			if (this.favorCnt == o.favorCnt) {
				if (this.emptyCnt == o.emptyCnt) {
					if (this.row == o.row) {
						return this.col - o.col;
					} else {
						return this.row - o.row;
					}
				} else {
					return o.emptyCnt - this.emptyCnt;
				}
			} else {
				return o.favorCnt - this.favorCnt;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int powN = N * N;
		int[][] seats = new int[N + 1][N + 1];

		int[] dr = new int[] { -1, 0, 1, 0 };
		int[] dc = new int[] { 0, 1, 0, -1 };

		int[][] favors = new int[powN + 1][];
		PriorityQueue<Student> pq = new PriorityQueue<>();
		for (int t = 0; t < powN; t++) {
			st = new StringTokenizer(br.readLine(), " ");

			int start = Integer.parseInt(st.nextToken());
			favors[start] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

			// 1. �����ϴ� �л��� ������ ĭ�� ���� ������
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (seats[i][j] == 0) { // 현재 자리가 0일 때
						int count = 0, emptyCnt = 0;
						for (int k = 0; k < 4; k++) {
							int nr = i + dr[k];
							int nc = j + dc[k];

							if (nr < 1 || nr >= N + 1 || nc < 1 || nc >= N + 1)
								continue;

							for (int x = 0; x < 4; x++) {
								if (seats[nr][nc] == favors[start][x]) {
									count++;
								}
							}
							if (seats[nr][nc] == 0) {
								emptyCnt++;
							}
						}

						pq.offer(new Student(i, j, count, emptyCnt));
					}
				}
			}
			Student temp = pq.peek();
			seats[temp.row][temp.col] = start;

			pq = new PriorityQueue<>();
		}

		int sum = 0;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				int tempCnt = 0;
				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];

					if (nr < 1 || nr >= N + 1 || nc < 1 || nc >= N + 1)
						continue;

					for (int t = 0; t < 4; t++) {
						if (favors[seats[i][j]][t] == seats[nr][nc]) {
							tempCnt++;
						}
					}
				}

				if (tempCnt == 1) {
					sum += 1;
				} else if (tempCnt == 2) {
					sum += 10;
				} else if (tempCnt == 3) {
					sum += 100;
				} else if (tempCnt == 4) {
					sum += 1000;
				}
			}

		}

		System.out.println(sum);
	}
}
