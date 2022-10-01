package boj_class03;

import java.io.*;
import java.util.*;

public class Main_6064_카잉달력 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int lcm = M * N / gcd(M, N);
			
			while(x <= lcm) {
				if(x % N == y % N) {
					sb.append(x).append("\n");
					break;
				}
				x += M;
			}
			
			if(x > lcm) {
				// while문을 더이상 돌 수 없음 -> 같은 값 x
				sb.append("-1\n");
			}
		}
		System.out.println(sb);
	}
	
	static int gcd(int a, int b) {
		if(b == 0) return a;
		else return gcd(b, a%b);
	}
}
