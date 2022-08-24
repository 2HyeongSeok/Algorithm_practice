package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_탈출 {

	static boolean[][] visited;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int R, C, moved = 0;
	static boolean finFlag = false;

	static Queue<Integer[]> moveQueue = new ArrayDeque<>();
	static Queue<Integer[]> moveTempQueue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		int startRow = 0, startCol = 0, waterRow = -1, waterCol = -1;
		ArrayList<Integer[]> list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = line[j];
				if (map[i][j] == 'S') {
					startRow = i;
					startCol = j;
				} else if (map[i][j] == '*') {
					list.add(new Integer[] {i, j});
				}
			}
		}

		bfs(startRow, startCol, list);

		if (finFlag)
			System.out.println(moved);
		else
			System.out.println("KAKTUS");

	}

	static void bfs(int row, int col, ArrayList<Integer[]> list) {
		Queue<Integer[]> tempQueue = new ArrayDeque<>();
		Queue<Integer[]> queue = new ArrayDeque<>();
		queue.offer(new Integer[] { row, col });
		visited[row][col] = true;
		
		int wRow = -1, wCol = -1;
		for(int i = 0, len = list.size(); i < len; i++) {
			wRow = list.get(i)[0];
			wCol = list.get(i)[1];
			
			visited[wRow][wCol] = true;
			move(wRow, wCol); // 처음 물 이동(예정이지만 고슴도치가 갈 수 없으므로 미리 진행)
		}
		if (!moveTempQueue.isEmpty()) {
			moveQueue = moveTempQueue; // 다음 물 이동 큐 복사
			moveTempQueue = new ArrayDeque<>();
		}

		// 물 이동 좌표 찍어보기
//		System.out.println(wRow + ", " + wCol);
//		for(int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		while (!queue.isEmpty()) {
			Integer[] next = queue.poll();
			row = next[0];
			col = next[1];

			for (int k = 0; k < 4; k++) {
				int nr = row + dr[k];
				int nc = col + dc[k];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc])
					continue;

				if (map[nr][nc] == 'D') { // 비버의 굴 도착 가능
					moved++;
					finFlag = true;
					return;
				}

				if (!visited[nr][nc] && map[nr][nc] == '.') {
//					System.out.println("고슴도치 : (" + nr + ", " + nc + ")");
					tempQueue.offer(new Integer[] { nr, nc });
					visited[nr][nc] = true;
					map[row][col] = '.';
					map[nr][nc] = 'S';
				}
			}

			if (queue.isEmpty() && !tempQueue.isEmpty()) { // 같은 깊이 탐색 끝내고 다음 깊이가 있을 때
//				System.out.println();
				while (!moveQueue.isEmpty()) { // 다음 물 이동
					Integer[] temp = moveQueue.poll();
					wRow = temp[0];
					wCol = temp[1];

					visited[wRow][wCol] = true;
					move(wRow, wCol); // 처음 물 이동(예정이지만 고슴도치가 갈 수 없으므로 미리 진행)
				}
				if (!moveTempQueue.isEmpty()) {
					moveQueue = moveTempQueue; // 다음 물 이동 큐 복사
					moveTempQueue = new ArrayDeque<>();
				}

				// 물 이동 좌표 찍어보기
//				System.out.println(wRow + ", " + wCol);
//				for(int i = 0; i < R; i++) {
//					System.out.println(Arrays.toString(map[i]));
//				}

				// 고슴도치 이동
				queue = tempQueue;
				tempQueue = new ArrayDeque<>();
				moved++;
//				System.out.println(queue.size() + ", " + moved);
			}
		}
	}

	static void move(int row, int col) { // 물이 이동
		for (int k = 0; k < 4; k++) {
			int nrW = row + dr[k];
			int ncW = col + dc[k];

			if (nrW < 0 || nrW >= R || ncW < 0 || ncW >= C)
				continue;

			if (map[nrW][ncW] == '.') {
//				System.out.println("move! " + nrW + ", " + ncW);
				visited[nrW][ncW] = true; // 물이 차 있으므로 고슴도치가 이미 방문한 것과 동일하게 방문하지 않도록 설정
				moveTempQueue.offer(new Integer[] { nrW, ncW }); // 물이 이동하는 큐에 추가
				map[nrW][ncW] = '*';
			}
		}
	}
}
