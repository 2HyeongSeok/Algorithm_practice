package boj;

import java.io.*;
import java.util.*;

public class Main_G4_14502_연구소 {
	static int N, M, maxCount;
	static int[][] map;
	static int[][] selected;
	static boolean[][] visited;
	static ArrayList<Integer[]> zeros;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[3][2];
		
		zeros = new ArrayList<>();
		maxCount = 0;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) zeros.add(new Integer[] {i, j});
			}
		}

		comb(0, 0);

		System.out.println(maxCount);
	}

	static void comb(int count, int start) {
		if (count == 3) {

			visited = new boolean[N][M];
			int[][] newMap = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					newMap[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < 3; i++) {
				newMap[selected[i][0]][selected[i][1]] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (newMap[i][j] == 2) {
						bfs(newMap, i, j);
					}
				}
			}

			int thisCount = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (newMap[i][j] == 0) {
						thisCount++;
					}
				}
			}
			
			maxCount = maxCount > thisCount ? maxCount : thisCount;
			return;
		}

		for(int i = start; i < zeros.size(); i++) {
			selected[count][0] = zeros.get(i)[0];
			selected[count][1] = zeros.get(i)[1];
			
			comb(count + 1, i + 1);
		}
	}

	static void bfs(int[][] newMap, int row, int col) {
		ArrayDeque<Integer[]> queue = new ArrayDeque<>();
		queue.offer(new Integer[] { row, col });
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			Integer[] cur = queue.poll();
			row = cur[0];
			col = cur[1];

			for (int k = 0; k < 4; k++) {
				int nr = row + dr[k];
				int nc = col + dc[k];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])
					continue;

				if (newMap[nr][nc] == 0) {
					queue.offer(new Integer[] { nr, nc });
					newMap[nr][nc] = 2;
					visited[nr][nc] = true;
				}
			}
		}
	}
}