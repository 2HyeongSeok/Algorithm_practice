package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2775_부녀회장이될테야 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int res = reCalc(k, n);
			sb.append(res + "\n");
		}
		System.out.println(sb);
	}
	
	public static int reCalc(int a, int n) {
		int sum = 0;
		if(a > 0) {
			for(int i = 1; i <= n; i++) {
				sum += reCalc(a - 1, i);
			}
			return sum;
		}else { // a == 0
			return n;
		}
	}
}
