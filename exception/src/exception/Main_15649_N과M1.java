package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_N과M1 {
	static StringBuilder sb = new StringBuilder();
	static int[] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		selected = new int[M];
		perm(N, M, 0, 0);
		
		System.out.println(sb);
	}
	
	static void perm(int N, int M, int count, int flag) {
		if(count == M) {
			for(int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if((flag & 1 << i) != 0) continue;
			
			selected[count] = i;
			perm(N, M, count + 1, flag | 1 << i);
		}
	}
}
