package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_13023_ABCDE {

	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> map;
	static int N, M;
	static boolean finFlag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new ArrayList<>();
		for(int i = 0; i < N; i++) { // 초기화
			map.add(new ArrayList<>());
		}
		
		visited = new boolean[N]; // 싸이클 막는 용도 - 하나의 DFS에서 사용하고 나면 다시 false로

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map.get(a).add(b);
			map.get(b).add(a);
		}

		
		
		for (int i = 0; i < N; i++) { // 모든 그래프가 이어져있지 않을 수도 있음
			visited[i] = true;
			dfs(i, 1);
			visited[i] = false; // dfs 탐색 후에 다시 false로

			if (finFlag)
				break; // 만약 dfs 깊이가 4 => ABCDE가능
		}

		if (finFlag)
			sb.append(1);
		else
			sb.append(0);
		System.out.println(sb);
	}

	static void dfs(int next, int count) {
		if (count == 5) {
			finFlag = true;
			return;
		}

		ArrayList<Integer> search = map.get(next);
		if(search == null) return;
		
		for(int i = 0; i < search.size(); i++) {
			if(!visited[search.get(i)]) {
				visited[search.get(i)] = true;
				dfs(search.get(i), count + 1);
				visited[search.get(i)] = false;
			}
		}
	}
}
