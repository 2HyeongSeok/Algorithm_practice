package bochoong;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// nPr, nCr, 2^n
public class PermCombSubs {
	static int N = 4, R = 3, C = 0;
	static int[] arr = {1,2,3,4}, selected = new int[R];
	static boolean[] visited = new boolean[N];
	
	public static void main(String[] args) {
		perm(0); // 순열 4P3 = 24
		
		comb(0, 0); // 조합 4C3 = 4
		
		subs(0);
	}
	
	static void perm(int depth) {
		if(depth == R) {
			System.out.println(Arrays.toString(selected));
			C++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;	// 중복순열에선 불필요
			
			
			selected[depth] = arr[i];
			visited[i] = true;	// 중복순열에선 불필요
			perm(depth + 1);
			visited[i] = false;	// 중복순열에선 불필요
		}
	}
	
	static void comb(int depth, int start) {
		if(depth == R) {
			System.out.println(Arrays.toString(selected));
			C++;
			return;
		}
		
		for(int i = start; i < N; i++) {
			selected[depth] = arr[i];
			comb(depth + 1, i + 1);	// 중복조합에서는 i+1 대신 i를 넘겨줌
		}
	}
	
	static void subs(int depth) {
		if(depth == N) {
			System.out.println(visited[i] ? arr[i] : "X");
			C++;
			return;
		}
		
		visited[depth] = true;
		subs(depth + 1);
		visited[depth] = false;
		subs(depth + 1);
	}
}
