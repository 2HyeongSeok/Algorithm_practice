package algo_study;

import java.io.*;
import java.util.*;

public class Main_S1_1446_지름길 {
	static int N, D, size, minDist = Integer.MAX_VALUE;
	static ArrayList<Node> list;
	static boolean[] visited;

	static class Node implements Comparable<Node> {
		int from, to, dist;

		public Node(int from, int to, int dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.from - o.from;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		size = 0;
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			if (to <= D && (to - from) > dist) {
				list.add(new Node(from, to, dist));
				size++;
			}
		}
		Collections.sort(list);

		visited = new boolean[size];
		dfs(0, 0);
		
		System.out.println(minDist);
	}
	
	static void dfs(int current, int distance) {
		if(current == D) {
			minDist = Math.min(minDist, distance);
			return;
		}else if(current > D) return;
		
		
		for(int i = current; i <= D; i++) {
			for(int k = 0; k < size; k++) {
				Node curNode = list.get(k);
				if (!visited[k] && i == curNode.from) { //  현재 위치가 지름길이면
					visited[k] = true;
					dfs(curNode.to, distance + curNode.dist);
					visited[k] = false;
				}
			}
			
			if(i == D) {
				minDist = Math.min(minDist, distance);
			}
			
			distance++;
		}
	}
}