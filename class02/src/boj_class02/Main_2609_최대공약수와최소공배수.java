package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2609_최대공약수와최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		int a = Integer.parseInt(line[0]);
		int b = Integer.parseInt(line[1]);
		
		for(int i = Math.min(a, b); i >= 1; i--) {
			if(a % i == 0 && b % i == 0) {
				System.out.println(i);
				System.out.println(i * (a / i) * (b / i));
				break;
			}
		}
	}
}
