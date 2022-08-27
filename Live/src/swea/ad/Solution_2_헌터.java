package swea.ad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2_헌터 {

	static int[][] map;
	static int N, M;
	static int move;
	static int minMove;
	static boolean[] visited;
	static ArrayList<Integer[]> vList, cList; // vList : 방문할 리스트 (처음엔 몬스터 리스트로 시작), cList : 고객 리스트

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			// 맵 정보
			map = new int[N + 1][N + 1];
			visited = new boolean[9];
			
			vList = new ArrayList<Integer[]>();
			cList = new ArrayList<Integer[]>();
			M = 0;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 0) {
						vList.add(new Integer[] { i, j, map[i][j] + 4 }); // 몬스터 정보 리스트에 담기
						M++;
					}
					else if (map[i][j] < 0)
						cList.add(new Integer[] { i, j, map[i][j] + 4 }); // 고객 정보 리스트에 담기
				}
			}

			minMove = Integer.MAX_VALUE;
			dfs(1, 1, 0, 0);

			sb.append("#").append(t).append(" ").append(minMove).append("\n");
		}

		System.out.println(sb);
	}

	static void dfs(int r, int c, int move, int count) {
		if(count == M) {
			minMove = minMove < move ? minMove : move;
			return;
		}
		
		for (int i = 0, size = vList.size(); i < size; i++) {
			Integer[] temp = vList.get(i);
			if (!visited[temp[2]]) {
				visited[temp[2]] = true;
				if(temp[2] > 4) {
					// i번째 몬스터(map[x][y])에 방문한적 없다면!!
					for (int j = 0, size2 = cList.size(); j < size2; j++) {
						if (cList.get(j)[2] == 8 - temp[2]) {
							// 짝이면 재귀
							int tempMove = Math.abs(temp[0] - r) + Math.abs(temp[1] - c);
							vList.add(cList.get(j)); // 더해주고
							dfs(temp[0], temp[1], move + tempMove, count);
							vList.remove(vList.size() - 1); // 다시 빼야함 (다른 선택 먼저 할 수도 있어서)
						}
					}
				}else if(temp[2] < 4) {
					// 몬스터가 아니라 해당 집 방문이면 해결카운트 +1
					int tempMove = Math.abs(temp[0] - r) + Math.abs(temp[1] - c);
					dfs(temp[0], temp[1], move + tempMove, count + 1);
				}
				visited[temp[2]] = false;
			}
		}
	}

}
