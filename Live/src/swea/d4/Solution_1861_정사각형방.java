package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방 {
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());

			int[][] map = new int[N + 1][N + 1];
			int[][] cntMap = new int[N + 1][N + 1]; // 각 방에서 이동 가능한 최대 방의 수를 저장하는 배열
			visited = new boolean[N + 1][N + 1]; // 방문했는지 체크하는 배열
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int maxCnt = 0;
			int minNum = (int) Math.pow(N, 2);
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int thisCount = 1;
					if(!visited[i][j]) { // 방문하지 않았다면 check 재귀함수에서 사방탐색!!
						cntMap[i][j] = check(map, N, i, j, thisCount);
					}

					if (maxCnt < cntMap[i][j]) { // 최대값이 갱신됐다면, 해당 값을 최대값으로 저장하고 현재 방 번호를 최소 방번호 값으로 저장
						maxCnt = cntMap[i][j];
						minNum = map[i][j];
					} else if(maxCnt == cntMap[i][j]) { // 최대값이 같다면 방 번호가 최소인지 비교해서 저장
						minNum = minNum > map[i][j] ? map[i][j] : minNum;
					}
				}
			}
			sb.append(minNum).append(" ").append(maxCnt).append("\n");
		}
		System.out.println(sb);
	}

	static int check(int[][] map, int N, int i, int j, int count) { // 사방탐색해서 몇 개의 방을 이동할 수 있는지 카운팅 해주는 메소드
		int[] dr = { 1, -1, 0, 0 }; // 상하좌우
		int[] dc = { 0, 0, -1, 1 };
		
		for (int k = 0; k < 4; k++) {
			int nr = dr[k] + i;
			int nc = dc[k] + j;

			if (nr <= 0 || nr > N || nc <= 0 || nc > N)
				continue;

			if (map[nr][nc] == map[i][j] + 1) {
				visited[nr][nc] = true;
				count = check(map, N, nr, nc, count + 1);
			}
		}
		return count;
	}
}
