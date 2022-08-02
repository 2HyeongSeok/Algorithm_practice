package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1676_팩토리얼0의개수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int num = N / 5;
		
		for(int i = 1; i <= N; i++) {
			if(i % 25 == 0) {
				num += 1;
			}
			if(i % 125 == 0) {
				if(i % 25 == 0) num--;
				num += 2;
			}
		}
		
		System.out.println(num);
		
	}
}
