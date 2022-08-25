package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_외판원순회2 {

	static int[][] costMatrix;
	static boolean[] visited;
	static int N, minCost = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		costMatrix = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				costMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(i, i, 0, 0);
		}
		

		System.out.println(minCost);
	}

	static void dfs(int start, int cur, int cost, int depth) {
		if(depth == N - 1) {
			// 다 방문 가능!
			// 마지막에 되돌아오는게 가능하면 cost 추가해야함
			if(costMatrix[cur][start] != 0) {
				cost += costMatrix[cur][start];
				minCost = minCost < cost ? minCost : cost;
			}
			return;
		}
		
		// 이미 현재 최소값보다 큰 비용이라면 탈출
		if(cost > minCost) return;
		
		for (int i = 0; i < N; i++) {
			if (!visited[i] && costMatrix[cur][i] != 0) {
				// 다음꺼로 갈 수 있다~!
				visited[i] = true;
				dfs(start, i, cost + costMatrix[cur][i], depth + 1);
				visited[i] = false;
			}
		}

	}
}
