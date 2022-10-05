package boj;

import java.io.*;
import java.util.*;

public class Main_G1_1194_달이차오른다가자 {
	static int rows, cols, minMoved = Integer.MAX_VALUE;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		rows = Integer.parseInt(st.nextToken());
		cols = Integer.parseInt(st.nextToken());

		int row = -1, col = -1;
		map = new char[rows][cols];
		visited = new boolean[rows][cols][128];
		for (int k = 0; k < rows; k++) {
			char[] line = br.readLine().toCharArray();
			for (int l = 0; l < cols; l++) {
				map[k][l] = line[l];
				if (map[k][l] == '0') {
					row = k;
					col = l;
				}
			}
		}

		bfs(row, col, 0, 0);

		if (minMoved == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minMoved);
	}

	static void bfs(int row, int col, int moved, int flag) {
		ArrayDeque<Integer[]> queue = new ArrayDeque<>();
		queue.offer(new Integer[] { row, col, moved, flag });
		visited[row][col][flag] = true;

		while (!queue.isEmpty()) {
			Integer[] cur = queue.poll();
			row = cur[0];
			col = cur[1];
			moved = cur[2];
			flag = cur[3];

			if (map[row][col] == '1') {
				minMoved = moved;
				return;
			}

			for (int k = 0; k < 4; k++) {
				int nr = row + dr[k];
				int nc = col + dc[k];

				if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited[nr][nc][flag] || map[nr][nc] == '#')
					continue;

				if (map[nr][nc] == 'A') {
					if ((flag & 1 << 1) != 0) {
						// 갈 수 있음
						visited[nr][nc][flag] = true;
						queue.offer(new Integer[] { nr, nc, moved + 1, flag });
					} else {
						continue;
					}
				} else if (map[nr][nc] == 'B') {
					if ((flag & 1 << 2) != 0) {
						// 갈 수 있음
						visited[nr][nc][flag] = true;
						queue.offer(new Integer[] { nr, nc, moved + 1, flag });
					} else {
						continue;
					}
				} else if (map[nr][nc] == 'C') {
					if ((flag & 1 << 3) != 0) {
						// 갈 수 있음
						visited[nr][nc][flag] = true;
						queue.offer(new Integer[] { nr, nc, moved + 1, flag });
					} else {
						continue;
					}
				} else if (map[nr][nc] == 'D') {
					if ((flag & 1 << 4) != 0) {
						// 갈 수 있음
						visited[nr][nc][flag] = true;
						queue.offer(new Integer[] { nr, nc, moved + 1, flag });
					} else {
						continue;
					}
				} else if (map[nr][nc] == 'E') {
					if ((flag & 1 << 5) != 0) {
						// 갈 수 있음
						visited[nr][nc][flag] = true;
						queue.offer(new Integer[] { nr, nc, moved + 1, flag });
					} else {
						continue;
					}
				} else if (map[nr][nc] == 'F') {
					if ((flag & 1 << 6) != 0) {
						// 갈 수 있음
						visited[nr][nc][flag] = true;
						queue.offer(new Integer[] { nr, nc, moved + 1, flag });
					} else {
						continue;
					}
				} else if (map[nr][nc] == 'a') {
					if ((flag & 1 << 1) != 0) {
						queue.offer(new Integer[] { nr, nc, moved + 1, flag });
					}else {
						queue.offer(new Integer[] { nr, nc, moved + 1, flag | 1 << 1 });
					}
					visited[nr][nc][flag | 1 << 1] = true;
					queue.offer(new Integer[] { nr, nc, moved + 1, flag | 1 << 1 });
				} else if (map[nr][nc] == 'b') {
					if ((flag & 1 << 2) != 0) {
						queue.offer(new Integer[] { nr, nc, moved + 1, flag });
					}else {
						queue.offer(new Integer[] { nr, nc, moved + 1, flag | 1 << 2 });
					}
					visited[nr][nc][flag | 1 << 2] = true;
				} else if (map[nr][nc] == 'c') {
					if ((flag & 1 << 3) != 0) {
						queue.offer(new Integer[] { nr, nc, moved + 1, flag });
					}else {
						queue.offer(new Integer[] { nr, nc, moved + 1, flag | 1 << 3 });
					}
					visited[nr][nc][flag | 1 << 3] = true;
				} else if (map[nr][nc] == 'd') {
					if ((flag & 1 << 4) != 0) {
						queue.offer(new Integer[] { nr, nc, moved + 1, flag });
					}else {
						queue.offer(new Integer[] { nr, nc, moved + 1, flag | 1 << 4 });
					}
					visited[nr][nc][flag | 1 << 4] = true;
				} else if (map[nr][nc] == 'e') {
					if ((flag & 1 << 5) != 0) {
						queue.offer(new Integer[] { nr, nc, moved + 1, flag });
					}else {
						queue.offer(new Integer[] { nr, nc, moved + 1, flag | 1 << 5 });
					}
					visited[nr][nc][flag | 1 << 5] = true;
				} else if (map[nr][nc] == 'f') {
					if ((flag & 1 << 6) != 0) {
						queue.offer(new Integer[] { nr, nc, moved + 1, flag });
					}else {
						queue.offer(new Integer[] { nr, nc, moved + 1, flag | 1 << 6 });
					}
					visited[nr][nc][flag | 1 << 6] = true;
				} else {
					// 갈 수 있음
					visited[nr][nc][flag] = true;
					queue.offer(new Integer[] { nr, nc, moved + 1, flag });
				}
			}

		}
	}
}
