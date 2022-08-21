package boj_class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	static StringBuilder sbDFS = new StringBuilder();
	static StringBuilder sbBFS = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		boolean[] visitedDFS = new boolean[N + 1];
		boolean[] visitedBFS = new boolean[N + 1]; // 인덱스 맞춰주려고
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> temp;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if(map.containsKey(k))
				temp = map.remove(k);
			else 
				temp = new ArrayList<>();
			
			temp.add(v);
			Collections.sort(temp);
			map.put(k, temp);
			
			// 반대의 경우
			if(map.containsKey(v))
				temp = map.remove(v);
			else 
				temp = new ArrayList<>();
			
			temp.add(k);
			Collections.sort(temp);
			map.put(v, temp);
		}

		Stack<Integer> s = new Stack<>();
		s.push(V);
		dfs(map, s, visitedDFS);

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(V);
		bfs(map, q, visitedBFS);
		
		System.out.println(sbDFS);
		System.out.println(sbBFS);
	}
	
	static void dfs(Map<Integer, ArrayList<Integer>> map, Stack<Integer> s, boolean[] visitedDFS) {
		int V = s.pop();
		
		if(!visitedDFS[V]) {
			sbDFS.append(V).append(" ");
			visitedDFS[V] = true;
		}else return;
		
		if(!map.containsKey(V)) return; // 기저조건
		
		ArrayList<Integer> start = map.get(V);
		int size = start.size();
		for(int i = size - 1; i >= 0; i--) {
			if(visitedDFS[start.get(i)]) continue; // 이미 방문했다면 추가하지 않음!
			s.push(start.get(i));
		}
		
		while(!s.isEmpty())
			dfs(map, s, visitedDFS);
	}
	
	static void bfs(Map<Integer, ArrayList<Integer>> map, Queue<Integer> q, boolean[] visitedBFS) {
		int V = q.poll();
		
		if(!visitedBFS[V]) {
			sbBFS.append(V).append(" ");
			visitedBFS[V] = true;
		}else return;
		
		if(!map.containsKey(V)) return; // 기저조건
		
		ArrayList<Integer> start = map.get(V);
		int size = start.size();
		for(int i = 0; i < size; i++) {
			if(visitedBFS[start.get(i)]) continue;
			q.offer(start.get(i));
		}
		
		while(!q.isEmpty()) {
			bfs(map, q, visitedBFS);
		}
	}
}
