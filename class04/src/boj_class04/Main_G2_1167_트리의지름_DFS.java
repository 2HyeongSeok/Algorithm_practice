package boj_class04;

import java.io.*;
import java.util.*;

public class Main_G2_1167_트리의지름_DFS {
	static ArrayList<Integer[]>[] adjList;
	static boolean[] visited;
	static int V, maxLength = 0, maxIdx = -1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		adjList = new ArrayList[V];
		for(int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken())-1;
			while(st.hasMoreTokens()) {
				int to = Integer.parseInt(st.nextToken())-1;
				
				if(to == -2) break;
				
				int dist = Integer.parseInt(st.nextToken());
				adjList[from].add(new Integer[] {to, dist});
			}
		}
		
		for(int i = 0; i < V; i++) {
			if(adjList[i].size() == 1) { // 출발점으로 할만 함
				visited = new boolean[V];
				visited[i] = true;
				dfs(i, 0);
				break;
			}
		}
		
		visited = new boolean[V];
		visited[maxIdx] = true;
		maxLength = 0;
		dfs(maxIdx, 0);
		
		System.out.println(maxLength);
	}
	
	static void dfs(int idx, int length) {
		if(maxLength < length) {
			maxLength = length;
			maxIdx = idx;
		}
		
		for(int i = 0, size = adjList[idx].size(); i < size; i++) {
			int nextIdx = adjList[idx].get(i)[0];
			int nextLength = length + adjList[idx].get(i)[1];
			
			if(!visited[nextIdx]) {
				visited[nextIdx] = true;
				dfs(nextIdx, nextLength);
				visited[nextIdx] = false;
			}
		}
	}
}
