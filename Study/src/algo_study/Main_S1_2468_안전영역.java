package algo_study;

import java.io.*;
import java.util.*;

public class Main_S1_2468_안전영역 {
	static int N, minH, maxH, maxCount = 1;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		minH = Integer.MAX_VALUE;
		maxH = 0;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				minH = Math.min(minH, map[i][j]);
				maxH = Math.max(maxH, map[i][j]);
			}
		}

		for (int k = minH; k < maxH; k++) {
			visited = new boolean[N][N];
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > k) {
						count++;
						bfs(i, j, k);
					}
				}
			}

			maxCount = Math.max(maxCount, count);
		}

		System.out.println(maxCount);
	}

	static void bfs(int r, int c, int height) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		visited[r][c] = true;
		queue.offer(new int[] { r, c });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			r = cur[0];
			c = cur[1];

			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
					continue;

				if (map[nr][nc] > height) {
					visited[nr][nc] = true;
					queue.offer(new int[] { nr, nc });
				}
			}
		}
	}
}
