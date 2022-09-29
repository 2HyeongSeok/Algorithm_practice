package bochoong;

import java.io.*;
import java.util.*;

public class GraphList {
	static int[][] g;
	static boolean[] v;
	static int N;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		
		g = new int[N][N];
		v = new boolean[N];
		
		for(int e = 0; e < E; e++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			g[from][to] = g[to][from] = 1;
		}
		for(int[] a : g) System.out.println(Arrays.toString(a));System.out.println();
		
//		dfs(0);
		bfs(0);
		sc.close();
	}
	
	static void dfs(int s) {
		v[s] = true;
//		System.out.print((char)(s + 'A') + " ");
		System.out.print(s);
		
		for(int k = 0; k < N; k++) {
			if(!v[k] && g[s][k] != 0) {
				// 방문하지 않았고, 인접해 있다면
				dfs(k);
			}
		}
	}
	
	static void bfs(int s) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[s] = true;
		q.offer(s);
		
		while(!q.isEmpty()) {
			s = q.poll();
			
			System.out.print((char)(s + 'A') + " ");
			
			for(int k = 0; k < N; k++) {
				if(!v[k] && g[s][k] != 0) {
					// 방문하지 않았고, 인접해 있다면
					v[k] = true;
					q.offer(k);
				}
			}
		}
	}
}


/*
    A
   / \
  B   C 
 / \ /
D   E
 \  |
   F-G

7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
bfs: A B C D E F G 
dfs: A B D F E C G

*/