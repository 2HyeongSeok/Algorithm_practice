package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1978_소수찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		boolean isPrime;
		int count = 0;
		
		String[] strArr = br.readLine().split(" ");
		for(int i = 0; i < num; i++) {
			isPrime = true;
			int temp = Integer.parseInt(strArr[i]);
			if(temp == 1) continue;
			for(int j = 2; j <= Math.sqrt(temp); j++) {
				if(temp % j == 0) {
					// 소수가 아니야!
					isPrime = false;
					break;
				}
			}
			if(isPrime) count++;
		}
		
		System.out.println(count);
	}
}
