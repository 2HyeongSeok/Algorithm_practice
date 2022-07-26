package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1929_소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		
		int min = Integer.parseInt(line[0]);
		int max = Integer.parseInt(line[1]);
		boolean isPrime;
		
		for(int i = min; i <= max; i++) {
			isPrime = true;
			for(int j = 2; j <= (int)Math.sqrt(i); j++) {
				if(i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) sb.append(i).append("\n");
		}
		
		System.out.println(sb);
	}
}
