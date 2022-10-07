package boj;

import java.io.*;
import java.util.*;

public class Main_G2_17143_낚시왕 {
	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken()); // 행
		int C = Integer.parseInt(st.nextToken()); // 열
		int M = Integer.parseInt(st.nextToken()); // 상어의 수

		int[][] map = new int[R][C];
		Shark[] sharks = new Shark[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1; // 위치 행
			int c = Integer.parseInt(st.nextToken()) - 1; // 위치 열
			int s = Integer.parseInt(st.nextToken()); // 속력
			int d = Integer.parseInt(st.nextToken()); // 이동방향 // 1:위 // 2:아래 // 3:오른쪽 // 4:왼쪽
			int z = Integer.parseInt(st.nextToken()); // 크기

			map[r][c] = z; // 두 상어가 같은 크기를 갖는 경우는 없으므로 구분하기 위해 크기를 사용
			sharks[i] = new Shark(r, c, s, d, z);
		}
		
		Map<Integer, Integer> hashmap = new HashMap<>();

		int totalLength = 0;
		for (int i = 0; i < C; i++) {
			// 낚시왕과 같은 열에 있는 상어 중 제일 먼저 발견되는거 잡기(땅에 가까운 것)
//			System.out.println("----------------------------------------");
//			for(int p = 0; p < R; p++) {
//				System.out.println(Arrays.toString(map[p]));
//			}
//			System.out.println();
			
			for (int k = 0; k < R; k++) {
				if (map[k][i] > 0) {
//					System.out.println(i + "번째 : " + map[k][i]);
					totalLength += map[k][i];
					hashmap.put(map[k][i], 0);
					map[k][i] = 0;
					break;
				}
			}
			
			if(i == C - 1) {
				System.out.println(totalLength);
				break;
			}

			// 상어 이동
			int turns = 0; // 방향 전환 횟수
			int remains = 0; // 남은 이동 횟수
			map = new int[R][C];
			for (int k = 0; k < M; k++) { 
				if(hashmap.containsKey(sharks[k].z)) continue;
				
				// 방향 설정
				if(sharks[k].r == 0 && sharks[k].d == 1) sharks[k].d = 2;
				else if(sharks[k].r == R - 1 && sharks[k].d == 2) sharks[k].d = 1;
				else if(sharks[k].c == 0 && sharks[k].d == 4) sharks[k].d = 3;
				else if(sharks[k].c == C - 1 && sharks[k].d == 3) sharks[k].d = 4;
				
				switch (sharks[k].d) {
				case 1: // 위
					turns = sharks[k].s / (R - 1);
					remains = sharks[k].s % (R - 1);

					if (turns % 2 == 0) { // 짝수이므로 제자리부터 방향 유지하며 나머지 처리
						if (sharks[k].r > remains) { // 나머지 처리할 때 방향 바꾸지 않는 범위
							if (map[sharks[k].r - remains][sharks[k].c] < sharks[k].z) {
								// 크기 비교하고 지금이 더 크면 교체
								hashmap.put(map[sharks[k].r - remains][sharks[k].c], 0);
								map[sharks[k].r - remains][sharks[k].c] = sharks[k].z;
							}else { // 이미 있는 애가 나보다 큼!! 그럼 나는 잡아먹힌다!
								hashmap.put(sharks[k].z, 0);
							}
							sharks[k].r = sharks[k].r - remains;
						} else { // 방향 바뀜
							if (map[remains - sharks[k].r][sharks[k].c] < sharks[k].z) {
								// 이미 다른 상어가 있다면 크기 비교 (크거나 같으면 교체)
								hashmap.put(map[remains - sharks[k].r][sharks[k].c], 0);
								map[remains - sharks[k].r][sharks[k].c] = sharks[k].z;
							}else { // 이미 있는 애가 나보다 큼!! 그럼 나는 잡아먹힌다!
								hashmap.put(sharks[k].z, 0);
							}
							sharks[k].r = remains - sharks[k].r;
							sharks[k].d = 2; // 방향 반대
						}
					} else { // 홀수이므로 배열크기 - 방향 반대로!!
						// 즉 아래방향
						sharks[k].r = R - sharks[k].r - 1;

						if (sharks[k].r + remains < R - 1) { // 나머지 처리할 때 방향 바꾸지 않는 범위
							if (map[sharks[k].r + remains][sharks[k].c] < sharks[k].z) {
								// 이미 다른 상어가 있다면 크기 비교하고 지금이 더 크면 교체 (작으면 기존꺼 그대로 유지)
								hashmap.put(map[sharks[k].r + remains][sharks[k].c], 0);
								map[sharks[k].r + remains][sharks[k].c] = sharks[k].z;
							}else { // 이미 있는 애가 나보다 큼!! 그럼 나는 잡아먹힌다!
								hashmap.put(sharks[k].z, 0);
							}
							sharks[k].r = sharks[k].r + remains;
							sharks[k].d = 2; // 이미 반대 방향이므로
						} else { // 방향 바뀜! 즉 위 방향
							if (map[2 * R - 2 - sharks[k].r - remains][sharks[k].c] < sharks[k].z) {
								// 이미 다른 상어가 있다면 크기 비교 (크거나 같으면 교체)
								hashmap.put(map[2 * R - 2 - sharks[k].r - remains][sharks[k].c], 0);
								map[2 * R - 2 - sharks[k].r - remains][sharks[k].c] = sharks[k].z;
							}else { // 이미 있는 애가 나보다 큼!! 그럼 나는 잡아먹힌다!
								hashmap.put(sharks[k].z, 0);
							}
							sharks[k].r = 2 * R - 2 - sharks[k].r - remains;
						}
					}
					break;
				case 2: // 아래
					turns = sharks[k].s / (R - 1);
					remains = sharks[k].s % (R - 1);

					if (turns % 2 == 0) { // 짝수이므로 제자리부터 방향 유지하며 나머지 처리
						// 즉 아래방향

						if (sharks[k].r + remains < R - 1) { // 나머지 처리할 때 방향 바꾸지 않는 범위
							if (map[sharks[k].r + remains][sharks[k].c] < sharks[k].z) {
								// 이미 다른 상어가 있다면 크기 비교하고 지금이 더 크면 교체
								hashmap.put(map[sharks[k].r + remains][sharks[k].c], 0);
								map[sharks[k].r + remains][sharks[k].c] = sharks[k].z;
							}else { // 이미 있는 애가 나보다 큼!! 그럼 나는 잡아먹힌다!
								hashmap.put(sharks[k].z, 0);
							}
							sharks[k].r = sharks[k].r + remains;
						} else { // 방향 바뀜! 즉 위 방향
							if (map[2 * R - 2 - sharks[k].r - remains][sharks[k].c] < sharks[k].z) {
								// 이미 다른 상어가 있다면 크기 비교
								hashmap.put(map[2 * R - 2 - sharks[k].r - remains][sharks[k].c], 0);
								map[2 * R - 2 - sharks[k].r - remains][sharks[k].c] = sharks[k].z;
							}else { // 이미 있는 애가 나보다 큼!! 그럼 나는 잡아먹힌다!
								hashmap.put(sharks[k].z, 0);
							}
							sharks[k].r = 2 * R - 2 - sharks[k].r - remains;
							sharks[k].d = 1; //
						}
					} else { // 홀수이므로 배열크기 - 방향 반대로!!
						// 즉 위 방향
						sharks[k].r = R - sharks[k].r - 1;
 						
						if (sharks[k].r > remains) { // 나머지 처리할 때 방향 바꾸지 않는 범위
							if (map[sharks[k].r - remains][sharks[k].c] < sharks[k].z) {
								// 이미 다른 상어가 있다면 크기 비교하고 지금이 더 크면 교체
								hashmap.put(map[sharks[k].r - remains][sharks[k].c], 0);
								map[sharks[k].r - remains][sharks[k].c] = sharks[k].z;
							}else { // 이미 있는 애가 나보다 큼!! 그럼 나는 잡아먹힌다!
								hashmap.put(sharks[k].z, 0);
							}
							sharks[k].r = sharks[k].r - remains;
							sharks[k].d = 1; // 방향 반대
						} else { // 방향 바뀜
							if (map[remains - sharks[k].r][sharks[k].c] < sharks[k].z) {
								// 이미 다른 상어가 있다면 크기 비교
								hashmap.put(map[remains - sharks[k].r][sharks[k].c], 0);
								map[remains - sharks[k].r][sharks[k].c] = sharks[k].z;
							}else { // 이미 있는 애가 나보다 큼!! 그럼 나는 잡아먹힌다!
								hashmap.put(sharks[k].z, 0);
							}
							sharks[k].r = remains - sharks[k].r;
						}
					}
					break;
				case 3: // 오른쪽
					turns = sharks[k].s / (C - 1);
					remains = sharks[k].s % (C - 1);

					if (turns % 2 == 0) { // 짝수이므로 제자리부터 방향 유지하며 나머지 처리
						
						if (sharks[k].c + remains < C - 1) { // 나머지 처리할 때 방향 바꾸지 않는 범위
							if (map[sharks[k].r][sharks[k].c + remains] < sharks[k].z) {
								// 이미 다른 상어가 있다면 크기 비교하고 지금이 더 크면 교체 (작으면 기존꺼 그대로 유지)
								hashmap.put(map[sharks[k].r][sharks[k].c + remains], 0);
								map[sharks[k].r][sharks[k].c + remains] = sharks[k].z;
							}else { // 이미 있는 애가 나보다 큼!! 그럼 나는 잡아먹힌다!
								hashmap.put(sharks[k].z, 0);
							}
							sharks[k].c = sharks[k].c + remains;
						} else { // 방향 바뀜! 즉 왼쪽 방향
							if (map[sharks[k].r][2 * C - 2 - sharks[k].c - remains] < sharks[k].z) {
								// 이미 다른 상어가 있다면 크기 비교 (크거나 같으면 교체)
								hashmap.put(map[sharks[k].r][2 * C - 2 - sharks[k].c - remains], 0);
								map[sharks[k].r][2 * C - 2 - sharks[k].c - remains] = sharks[k].z;
							}else { // 이미 있는 애가 나보다 큼!! 그럼 나는 잡아먹힌다!
								hashmap.put(sharks[k].z, 0);
							}
							sharks[k].c = 2 * C - 2 - sharks[k].c - remains;
							sharks[k].d = 4; // 반대 방향이므로
						}
					} else { // 홀수이므로 배열크기 - 방향 반대로!!
						// 즉 왼쪽 방향
						sharks[k].c = C - sharks[k].c - 1;
						
						if (sharks[k].c > remains) { // 나머지 처리할 때 방향 바꾸지 않는 범위
							if (map[sharks[k].r][sharks[k].c - remains] < sharks[k].z) {
								// 이미 다른 상어가 있다면 크기 비교하고 지금이 더 크면 교체 (작으면 기존꺼 그대로 유지)
								hashmap.put(map[sharks[k].r][sharks[k].c - remains], 0);
								map[sharks[k].r][sharks[k].c - remains] = sharks[k].z;
							}else { // 이미 있는 애가 나보다 큼!! 그럼 나는 잡아먹힌다!
								hashmap.put(sharks[k].z, 0);
							}
							sharks[k].c = sharks[k].c - remains;
							sharks[k].d = 4; //
						} else { // 방향 바뀜
							if (map[sharks[k].r][remains - sharks[k].c] < sharks[k].z) {
								// 이미 다른 상어가 있다면 크기 비교 (크거나 같으면 교체)
								hashmap.put(map[sharks[k].r][remains - sharks[k].c], 0);
								map[sharks[k].r][remains - sharks[k].c] = sharks[k].z;
							}else { // 이미 있는 애가 나보다 큼!! 그럼 나는 잡아먹힌다!
								hashmap.put(sharks[k].z, 0);
							}
							sharks[k].c = remains - sharks[k].c;
						}
					}
					break;
				case 4: // 왼쪽
					turns = sharks[k].s / (C - 1);
					remains = sharks[k].s % (C - 1);

					if (turns % 2 == 0) { // 짝수이므로 제자리부터 방향 유지하며 나머지 처리
						if (sharks[k].c > remains) { // 나머지 처리할 때 방향 바꾸지 않는 범위
							if (map[sharks[k].r][sharks[k].c - remains] <= sharks[k].z) {
								// 이미 다른 상어가 있다면 크기 비교하고 지금이 더 크면 교체 (작으면 기존꺼 그대로 유지)
								hashmap.put(map[sharks[k].r][sharks[k].c - remains], 0);
								map[sharks[k].r][sharks[k].c - remains] = sharks[k].z;
							}else { // 이미 있는 애가 나보다 큼!! 그럼 나는 잡아먹힌다!
								hashmap.put(sharks[k].z, 0);
							}
							sharks[k].c = sharks[k].c - remains;
						} else { // 방향 바뀜
							if (map[sharks[k].r][remains - sharks[k].c] <= sharks[k].z) {
								// 이미 다른 상어가 있다면 크기 비교 (크거나 같으면 교체)
								hashmap.put(map[sharks[k].r][remains - sharks[k].c], 0);
								map[sharks[k].r][remains - sharks[k].c] = sharks[k].z;
							}else { // 이미 있는 애가 나보다 큼!! 그럼 나는 잡아먹힌다!
								hashmap.put(sharks[k].z, 0);
							}
							sharks[k].c = remains - sharks[k].c;
							sharks[k].d = 3; // 방향 반대
						}
					} else { // 홀수이므로 배열크기 - 방향 반대로!!
						// 즉 오른쪽 방향
						sharks[k].c = C - sharks[k].c - 1;

						if (sharks[k].c + remains < C - 1) { // 나머지 처리할 때 방향 바꾸지 않는 범위
							if (map[sharks[k].r][sharks[k].c + remains] <= sharks[k].z) {
								// 이미 다른 상어가 있다면 크기 비교하고 지금이 더 크면 교체 (작으면 기존꺼 그대로 유지)
								hashmap.put(map[sharks[k].r][sharks[k].c + remains], 0);
								map[sharks[k].r][sharks[k].c + remains] = sharks[k].z;
							}else { // 이미 있는 애가 나보다 큼!! 그럼 나는 잡아먹힌다!
								hashmap.put(sharks[k].z, 0);
							}
							sharks[k].c = sharks[k].c + remains;
							sharks[k].d = 3; // 이미 반대 방향이므로
						} else { // 방향 바뀜! 즉 위 방향
							if (map[sharks[k].r][2 * C - 2 - sharks[k].c - remains] <= sharks[k].z) {
								// 이미 다른 상어가 있다면 크기 비교 (크거나 같으면 교체)
								hashmap.put(map[sharks[k].r][2 * C - 2 - sharks[k].c - remains], 0);
								map[sharks[k].r][2 * C - 2 - sharks[k].c - remains] = sharks[k].z;
							}else { // 이미 있는 애가 나보다 큼!! 그럼 나는 잡아먹힌다!
								hashmap.put(sharks[k].z, 0);
							}
							sharks[k].c = 2 * C - 2 - sharks[k].c - remains;
						}
					}
					break;
				}
			}

		}
	}
}