package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15655_N과M6 {
	static int[] input;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		selected = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		
		comb(N, M, 0, 0);
		
		System.out.println(sb);
	}
	
	static void comb(int N, int M, int count, int start) {
		if(count == M) {
			for(int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			selected[count] = input[i];
			comb(N, M, count + 1, i + 1);
		}
	}
}
