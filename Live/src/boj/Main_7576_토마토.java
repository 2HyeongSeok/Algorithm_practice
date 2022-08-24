package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {

	static Queue<Integer[]> queue = new ArrayDeque<>();
	static Queue<Integer[]> tempQueue = new ArrayDeque<>();
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int row, col, days = 0, good = 0;
	static boolean clearFlag = false;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		col = Integer.parseInt(st.nextToken()); // 가로
		row = Integer.parseInt(st.nextToken()); // 세로
		visited = new boolean[row][col];
		
		int notGood = 0, empty = 0;
		ArrayList<Integer[]> list = new ArrayList<>();
		map = new int[row][col];
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					list.add(new Integer[] { i, j });
					good++;
				}else if(map[i][j] == 0) {
					notGood++;
				}else {
					empty++;
				}
			}
		}

		if (notGood == 0)
			sb.append(0);
		else {			
			for (int i = 0, size = list.size(); i < size; i++) {
				queue.offer(new Integer[] {list.get(i)[0], list.get(i)[1]});
				visited[list.get(i)[0]][list.get(i)[1]] = true;
			}
			bfs();
			
			if(good + empty == row * col) sb.append(days);
			else sb.append(-1);
		}
		
		System.out.println(sb);
	}

	static void bfs() {
		int r, c;

		while (!queue.isEmpty()) {
			Integer[] next = queue.poll();
			r = next[0];
			c = next[1];

			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];

				if (nr < 0 || nr >= row || nc < 0 || nc >= col || visited[nr][nc])
					continue;

				if (!visited[nr][nc] && map[nr][nc] == 0) {
					visited[nr][nc] = true;
					tempQueue.offer(new Integer[] { nr, nc });
					map[nr][nc] = 1;
					good++;
				}
			}

			if (queue.isEmpty() && !tempQueue.isEmpty()) {
				queue = tempQueue;
				tempQueue = new ArrayDeque<>();
				days++;
			}
			
			if(queue.isEmpty() && tempQueue.isEmpty()) {
				// 접근 가능한 모든 토마토 익혔음
			}
		}
	}
}
