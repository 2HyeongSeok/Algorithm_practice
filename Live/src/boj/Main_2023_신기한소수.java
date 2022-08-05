package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2023_신기한소수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int start = (int)Math.pow(10, N - 1);
		int end = (int)Math.pow(10, N);
		boolean flag;
		for(int i = start; i < end; i++) {
			flag = true; // 소수가 아닌 경우 있는지 체크
			for(int j = N-1; j >= 0; j--) {
				int temp = i / (int)Math.pow(10, j);
				if(!isPrime(temp)) {
					// 해당 파트 스킵!!
					// 예를 들어 2311 -> 소수가 아니여서 2321이 되는 상황이면 2311 + 10 - (2321 % 10) = 2321 - 1 = 2320으로 다음 파트 바로 계산 가능
					i = (i + (int)Math.pow(10, j)) - (i + (int)Math.pow(10, j)) % (int)Math.pow(10, j) - 1;
					flag = false;
					break;
				}
			}
			if(flag) sb.append(i).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static boolean isPrime(int i) {
		if(i == 1) return false;
		for(int k = 2; k <= (int)Math.sqrt(i); k++) {
			if(i % k == 0) {
				return false;
			}
		}
		return true;
	}
}
