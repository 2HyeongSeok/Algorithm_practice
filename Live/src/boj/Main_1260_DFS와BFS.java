package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {

	static int[][] vector;
	static boolean[] visitedBFS, visitedDFS;
	static int N;
	
	static StringBuilder sbBFS = new StringBuilder();
	static StringBuilder sbDFS = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		vector = new int[N + 1][N + 1];
		visitedBFS = new boolean[N + 1];
		visitedDFS = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			vector[a][b] = vector[b][a] = 1;
		}

		dfs(V);
		bfs(V);
		
		System.out.println(sbDFS);
		System.out.println(sbBFS);
	}

	static void bfs(int V) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(V);
		visitedBFS[V] = true;
		
		while(!queue.isEmpty()) {
			int next = queue.poll();
			sbBFS.append(next).append(" ");
			
			for(int i = 1; i <= N; i++) {
				if(!visitedBFS[i] && vector[next][i] == 1) {
					queue.offer(i);
					visitedBFS[i] = true;
				}
			}
		}
	}

	static void dfs(int V) {
		visitedDFS[V] = true;
		sbDFS.append(V).append(" ");
		
		for(int i = 1; i <= N; i++) {
			if(!visitedDFS[i] && vector[V][i] == 1) {
				dfs(i);
			}
		}
	}
}
