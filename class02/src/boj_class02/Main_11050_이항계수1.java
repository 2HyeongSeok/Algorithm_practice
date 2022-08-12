package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11050_이항계수1 {
	
	static int[] numbers;
	static int counter = 0;
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		
		comb(0, 0, 0);
		
		System.out.println(counter);
	}
	
	static void comb(int count, int start, int flag) {
		if(count == K) {
			counter++;
			return;
		}
		
		for(int i = start; i < N; i++) {
			if((flag & 1 << i) != 0) continue;
			
			comb(count + 1, i + 1, flag | 1 << i);
		}
		
	}
}
