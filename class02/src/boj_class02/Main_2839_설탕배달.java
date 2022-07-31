package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_설탕배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dest = Integer.parseInt(br.readLine());
		int calcDest = dest;
		int count = 0;
		int ok5 = 0;
		int loop;

		// 3가지 경우
		// 1. 5로 나눈 나머지
		// 2. 5로 나눈 나머지 + 5
		// 3. 5로 나눈 나머지 + 10
		if(calcDest <= 5) {
			loop = 1;
		}else if(calcDest <= 10) {
			loop = 2;
		}else {
			loop = 3;
		}
		for(int i = 0; i < loop; i++) {
			calcDest = dest;
			count = calcDest / 5 - ok5;
			calcDest = calcDest % 5 + ok5 * 5;
			
			if(calcDest % 3 == 0) {
				count += calcDest / 3;
				System.out.println(count);
				break;
			}else {
				ok5++;
				if(loop == ok5) System.out.println(-1);
			}
		}
	}
}
