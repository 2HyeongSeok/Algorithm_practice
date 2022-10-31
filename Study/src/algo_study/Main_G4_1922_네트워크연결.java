package algo_study;

import java.io.*;
import java.util.*;

public class Main_G4_1922_네트워크연결 {
	static class Node implements Comparable<Node>{
		int a, b, cost;

		public Node(int a, int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		Node[] list = new Node[M];
		
		for(int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
		
			list[k] = new Node(a, b, cost);
		}
		
		Arrays.sort(list);
		make(N);
		
		int sum = 0;
		for(int i = 0; i < list.length; i++) {
			Node cur = list[i];
			
			if(find(cur.a) != find(cur.b)) {
				sum += cur.cost;
				union(cur.a, cur.b);
			}
		}
		
		System.out.println(sum);
	}
	
	static void make(int N) {
		for(int i = 0; i < N+1; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a > b) parent[b] = a;
		else parent[a] = b;
	}
}
