package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {
	
	static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parent = new int[n+1];
			for(int i = 1; i < n+1; i++) {
				makeSet(i);
			}
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int oper = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				switch(oper) {
				case 0:
					union(a, b);
					break;
				case 1:
					int aParent = findSet(a);
					int bParent = findSet(b);
					if(aParent == bParent) sb.append(1);
					else sb.append(0);
					break;
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void makeSet(int x) {
		parent[x] = x;
	}
	
	static int findSet(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	
	static void union(int x, int y) {
		if(findSet(x) == findSet(y)) return;
		else parent[findSet(y)] = findSet(x);
	}
}
