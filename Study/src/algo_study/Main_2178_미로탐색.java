package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 맵 정보 입력
		int[][] map = new int[N+1][M+1];
		boolean[][] visited = new boolean[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			char[] mapChar = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				map[i][j] = mapChar[j - 1] - '0';
			}
		}

		int[] dr = { -1, 1, 0, 0 }; // 상하좌우 델타탐색
		int[] dc = { 0, 0, -1, 1 };
		Queue<int[]> queue = new ArrayDeque<>();
		Queue<int[]> tempQueue = new ArrayDeque<>();
		int[] temp;
		int i, j, nr, nc;
		int count = 1; // count는 깊이 체크
		
		int[] start = {1, 1};
		queue.offer(start);
		visited[1][1] = true;
		
		while(!queue.isEmpty()) {
			temp = queue.poll();
			i = temp[0];
			j = temp[1];
			
			if(i == N && j == M) break; // 만약 목적지에 다다랐다면 종료
			
			for (int k = 0; k < 4; k++) {
				nr = i + dr[k];
				nc = j + dc[k];

				if (nr < 1 || nr > N || nc < 1 || nc > M)
					continue;

				if (map[nr][nc] == 1 && !visited[nr][nc]) {
					// 근처 사방탐색 결과 이동 가능, 방문X
					// 방문해야 하므로 Queue에 추가
					tempQueue.offer(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
			
			if(queue.isEmpty() && !tempQueue.isEmpty()) {
				// 다 비었고, 이동할 칸이 더 있다면 다음 깊이로
				queue = tempQueue; 
				tempQueue = new ArrayDeque<>();
				count++;
			}
		}
		
		System.out.println(count);
	}
}
