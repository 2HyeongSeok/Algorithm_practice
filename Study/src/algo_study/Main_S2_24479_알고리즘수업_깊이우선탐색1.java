package algo_study;

import java.io.*;
import java.util.*;

public class Main_S2_24479_알고리즘수업_깊이우선탐색1 {
	static int N, M, R, idx = 1;
	static boolean[] visited;
	static int[] list;
	static ArrayList<Integer>[] arrList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		visited = new boolean[N+1];
		list = new int[N+1];
		arrList = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			arrList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arrList[a].add(b);
			arrList[b].add(a);
		}
		for(int i = 0; i < N+1; i++) {
			Collections.sort(arrList[i]);
		}
		
		visited[R] = true;
		list[R] = idx++;
		dfs(R);
		
		for(int i = 1; i <= N; i++) {
			sb.append(list[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int row) {
		for(int i = 0; i < arrList[row].size(); i++) {
			int index = (int)arrList[row].get(i);
			if(visited[index]) continue;
			
			visited[index] = true;
			list[index] = idx++;
			dfs(index);
		}		
	}
}
