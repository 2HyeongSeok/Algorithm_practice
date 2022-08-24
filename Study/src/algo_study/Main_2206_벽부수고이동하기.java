package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M, minDistance;
	static char[][] map;
	static boolean[][][] visited;
	static boolean okFlag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		minDistance = N * M + 1;

		map = new char[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				map[i][j] = line[j - 1];
			}
		}

		// 최단경로(1은 최대 1개)
		visited = new boolean[2][N + 1][M + 1];
		visited[0][1][1] = true;
		bfs(1, 1, 0, 1);

		if (okFlag)
			System.out.println(minDistance);
		else
			System.out.println(-1);
	}

	static void bfs(int row, int col, int crashCount, int depth) {
		Queue<Integer[]> queue = new ArrayDeque<>();
		queue.offer(new Integer[] { row, col, crashCount, depth });

		while (!queue.isEmpty()) {
			Integer[] temp = queue.poll();
			row = temp[0];
			col = temp[1];
			crashCount = temp[2];
			depth = temp[3];

			if (row == N && col == M) {
				okFlag = true;
				minDistance = minDistance < depth ? minDistance : depth;
				return;
			}

			for (int k = 0; k < 4; k++) {
				int nr = row + dr[k];
				int nc = col + dc[k];

				if (nr < 1 || nr > N || nc < 1 || nc > M)
					continue;

				if (map[nr][nc] == '0' && !visited[crashCount][nr][nc]) {
					// 방문할 수 있는 위치이면서 빈칸이면 이동 가능
					visited[crashCount][nr][nc] = true;
					queue.offer(new Integer[] { nr, nc, crashCount, depth + 1 });
				} else if (map[nr][nc] == '1' && crashCount == 0) {
					visited[crashCount+1][nr][nc] = true;
					queue.offer(new Integer[] { nr, nc, crashCount + 1, depth + 1 }); // 벽 뚫고 갈 때마다 +1
				}

			}
		}
	}
}