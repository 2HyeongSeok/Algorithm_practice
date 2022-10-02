package boj;

import java.io.*;
import java.util.*;

public class Main_G3_1600_말이되고픈원숭이 {
	static int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 }; // 오른쪽위부터 시계방향
	static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };

	static int[] ddr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] ddc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int minMoveCount = Integer.MAX_VALUE;

		int[][] map = new int[H][W];
		int[][][] visited = new int[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
			}
		}

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0][0][0] = 1;
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { 0, 0, 0, 0 });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int row = cur[0];
			int col = cur[1];
			int move = cur[2];
			int depth = cur[3];

			if (move > minMoveCount)
				continue; // 이미 최소값보다 많이 이동했다면 할 필요 X

			if (row == H - 1 && col == W - 1) {
				minMoveCount = minMoveCount < move ? minMoveCount : move; // 마지막 지점 도달했으니 최소값 갱신 하고 다음 queue
				continue;
			}

			if (depth < K) {
				for (int k = 0; k < 8; k++) {
					int nr = row + dr[k];
					int nc = col + dc[k];

					if (nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 1)
						continue;

					if (visited[nr][nc][depth + 1] > move) {
						visited[nr][nc][depth + 1] = move;
						queue.offer(new int[] { nr, nc, move + 1, depth + 1 });
					}
				}
			}

			for (int k = 0; k < 4; k++) {
				int nr = row + ddr[k];
				int nc = col + ddc[k];

				if (nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 1)
					continue;

				if (visited[nr][nc][depth] > move) {
					visited[nr][nc][depth] = move;
					queue.offer(new int[] { nr, nc, move + 1, depth });
				}
			}

		}

		if (minMoveCount == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minMoveCount);
	}
}
