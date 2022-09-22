package boj_class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		make(N);
		
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
		int[] counter = new int[N+1];
		for(int i = 1; i < N+1; i++) {
			counter[find(i)] = 1;
		}
		
		int result = 0;
		for(int i = 1; i < N+1; i++) {
			result += counter[i];
		}
		
		System.out.println(result);
	}

	static void make(int N) {
		for(int i = 1; i < N+1; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int x) {
		if(x == parent[x]) return x;
		return find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x > y) parent[x] = y;
		else parent[y] = x;
	}
}
