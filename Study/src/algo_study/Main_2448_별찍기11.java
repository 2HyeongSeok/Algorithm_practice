package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2448_별찍기11 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int height = N / 3;
		for(int i = 1; i <= height; i++) {
			star(i, height);
		}
	}
	
	static void star(int i, int height) { // 하나 찍어보기
		for(int k = 2; k >= 0; k--) {
			for(int n = 0; n < k; n++) {
				System.out.print(" ");
			}
			System.out.print("*");
		}
	}
}
