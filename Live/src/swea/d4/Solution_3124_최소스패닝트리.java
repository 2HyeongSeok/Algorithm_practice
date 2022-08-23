package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리 {
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// return Integer.compare(this.weight, o.weight;
			return this.weight - o.weight;
		}	
		
	}
	
	static int[] parent;
	static int V, E;
	static Edge[] edgeList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parent = new int[V+1];
			edgeList = new Edge[E];
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			make();
			Arrays.sort(edgeList);
			
			long weights = 0;
			int counter = 0;
			for(int i = 0; i < E; i++) {
				// V-1개 간선 선택하기
				if(union(edgeList[i].from, edgeList[i].to)) {
					weights += edgeList[i].weight;
					counter++;
				}
				
				if(counter == V-1) break;
			}
			sb.append("#").append(t).append(" ").append(weights).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void make() {
		for(int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		if(find(x) == find(y)) return false;
		
		parent[find(y)] = find(x);
		return true;
	}
}
