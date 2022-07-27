package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2231_분해합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int val = 0;
		boolean flag = false;
		
		for(int i = 0; i < num; i++) {
			val = i + (i / 100000) + (i % 100000 / 10000) + (i % 10000 / 1000) + (i % 1000 / 100) + (i % 100 / 10) + (i % 10);
			if(val == num) {
				flag = true;
				sb.append(i);
				break;
			}
		}
		
		if(!flag)
			sb.append(0);
		
		System.out.println(sb);
	}
}
