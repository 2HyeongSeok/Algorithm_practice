package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {
	static int N, eatCounter = 0;
	static int[][] map;
	static int timer = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int row = 0, col = 0, size = 2;

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) { // 시작점 저장
					row = i;
					col = j;
				}
			}
		}

		bfs(row, col, size);

		if (eatCounter == 0 && timer == 0) // 만약 현재 사이즈에서 먹은 마릿수가 0, 전체 이동 횟수도 0이라면 0출력
			System.out.println(0);
		else // 이동횟수가 있다면 timer 출력
			System.out.println(timer);
	}

	static void bfs(int row, int col, int size) {
		int count = 0;
		boolean[][] visited = new boolean[N][N];
		Queue<Integer[]> queue = new ArrayDeque<>();
		Queue<Integer[]> tempQueue = new ArrayDeque<>();
		ArrayList<Integer[]> eatList = new ArrayList<>();
		ArrayList<Integer[]> eatTempList = new ArrayList<>();

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		queue.offer(new Integer[] { row, col, size });
		visited[row][col] = true;
		map[row][col] = 0; // 다시 지나갈 수 있으려면 자리 비워야하므로 0으로 초기화

		while (!queue.isEmpty()) {
			Integer[] next = queue.poll();
			row = next[0];
			col = next[1];
			size = next[2];

			int high = N - 1, left = N - 1;
			for (int i = 0, len = eatList.size(); i < len; i++) {
				// 먹을 수 있는 애들이 같은 깊이에 있다!
				Integer[] temp = eatList.get(i);
				if (temp[0] < high) { // 더 위에 있으면 무조건 그 자리로 갱신
					high = temp[0];
					left = temp[1];
				} else if (temp[0] == high) { // 같은 높이면 더 왼쪽으로 갱신
					if (temp[1] < left) {
						left = temp[1];
					}
				}

				if (i == eatList.size() - 1) { // 마지막까지 다 봤을 때
					map[high][left] = 0; // 이제 여긴 오지 말아야 하니까 0으로 바꿈
					if (++eatCounter == size) {
						size++; // 자신의 크기랑 먹은 마릿수 같아지면 사이즈 +1
						eatCounter = 0; // 먹은 마릿수 촉화
					}
					timer += count; // 전체 시간에 더해줌
					
					bfs(high, left, size);
					return;
				}
			}

			for (int k = 0; k < 4; k++) {
				int nr = row + dr[k];
				int nc = col + dc[k];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
					continue;

				if (!visited[nr][nc]) {
					if (map[nr][nc] < size) {
						// 방문하지 않았으면 다음 bfs 돌 tempQueue에 저장
						if (map[nr][nc] != 0) {
							// 먹을 수 있는 애들을 같은 깊이 탐색 끝낼 때까지 임시 ArrayList에 저장
							eatTempList.add(new Integer[] { nr, nc }); 
						}
						
						// 이동할 수 있으므로 임시 tempQueue에 저장
						tempQueue.offer(new Integer[] { nr, nc, size });
						visited[nr][nc] = true;
					}else if(map[nr][nc] == size) {
						// 이동할 수 있으므로 임시 tempQueue에 저장
						tempQueue.offer(new Integer[] { nr, nc, size });
						visited[nr][nc] = true;
					}

				}
			}

			if (queue.isEmpty()) { // 하나의 깊이가 끝났으므로 다음 깊이 있으면 queue에 복사
				eatList = eatTempList; // 임시로 저장했던 같은 깊이의 먹을 수 있는 물고기 좌표를 eatList에 복사
				eatTempList = new ArrayList<>(); // 임시 리스트 초기화
				if (!tempQueue.isEmpty()) { // 다음 깊이가 있으므로
					queue = tempQueue; // queue에 복사
					tempQueue = new ArrayDeque<>(); // 임시 큐 초기화
				}
				count++; // 이동 횟수 카운팅
			}
		}

	}
}
