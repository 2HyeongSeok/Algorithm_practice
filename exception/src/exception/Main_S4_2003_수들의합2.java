package exception;

import java.io.*;
import java.util.*;

public class Main_S4_2003_수들의합2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0, e = 0, count = 0, sum = 0;;
		while(true) {
			if(sum >= M) sum -= arr[s++];
			else if(e == N) break;
			else sum += arr[e++];
			
			if(sum == M) count++;
		}
		
		System.out.println(count);
	}
}
