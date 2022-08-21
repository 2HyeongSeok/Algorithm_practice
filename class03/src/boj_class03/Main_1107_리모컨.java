package boj_class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1107_리모컨 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String strN = br.readLine(); // 마지막에 이 문자열 길이만큼 더해줄 것!
		int N = Integer.parseInt(strN);
		int M = Integer.parseInt(br.readLine());
		
		if(M == 0) {
			System.out.println(strN.length());
			return;
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		HashSet<Integer> brokenSet = new HashSet<>();
		for (int i = 0; i < M; i++) {
			brokenSet.add(Integer.parseInt(st.nextToken()));
		}
		
		int diff = Math.abs(N - 100);

		if (N == 100) {
			System.out.println(0);
			return;
		}

		if (M == 10) {
			System.out.println(diff);
			return;
		}
		
		int temp;
		int resultPLUS = 0;
		int resultMINUS = 0;
		int strLen = strN.length();
		
		// 큰 쪽으로 찾기
		int tempN = N;
		boolean okFlag = true;
		for (int i = strLen - 1; i >= 0; i--) {
			temp = tempN / (int)Math.pow(10, i); 

			if (brokenSet.contains(temp)) { // 고장난 키
				for(int k = 1; k <= 9; k++) {
					if(temp + k <= 9) { // 큰 수중에 제일 작은 값 찾기 위함
						if (!brokenSet.contains(temp + k)) {
							temp += k;
							break;
						}
					}else { 
						int ten = (temp + k) / 10;
						int one = (temp + k) % 10;
						if (!brokenSet.contains(ten) && !brokenSet.contains(one)) {
							temp = (temp + k);
							break;
						}
					}
					
				}
				
//				while (temp < 10) {
//					if (!brokenSet.contains(++temp))
//						break;
//					if(temp == 10) okFlag = false;
//				}
//			}
//			if(!okFlag) {
//				resultPLUS = 500000;
//				break;
			}
			resultPLUS += temp * (int) Math.pow(10, i);
			System.out.println(resultPLUS);
			tempN %= (int)Math.pow(10, i);
		}

		// 작은 쪽으로 찾기
		tempN = N;
		okFlag = true;
		for (int i = strLen - 1; i >= 0; i--) {
			if(i == strLen - 1) temp = tempN / (int) Math.pow(10, i); // 처음에만 해당 값 그대로 사용
			else temp = 9; // 첫 자리 아니면 9부터 제일 큰 값 찾아야함

			if (brokenSet.contains(temp)) { // 고장난 키
				for(int k = 1; k <= 9; k++) {
					if(temp - k > 0) { // 작은 수중에 가장 큰 값 찾기 위함
						if (!brokenSet.contains(temp - k)) {
							temp -= k;
							break;
						}
					}else {
						if (!brokenSet.contains(9 + (temp - k))) {
							temp = 9 + (temp - k);
							i -= 1;
							break;
						}
					}
					
				}
//				while (temp >= 0) {
//					if (!brokenSet.contains(--temp))
//						break;
//					if(temp == 0) 
//						okFlag = false;
//				}
//			}
//			if(!okFlag) {
//				resultMINUS = 500000;
//				break;
			}
			resultMINUS += temp * (int) Math.pow(10, i);
			System.out.println(resultMINUS);
			tempN %= (int)Math.pow(10, i);
		}
		
		int plus = Math.abs(resultPLUS);
		int minus = Math.abs(resultMINUS);
		int result = min(plus, minus, diff, N);
		
		System.out.println(result);
	}
	
	
	static int min(int a, int b, int diff, int N) {
		int na = Math.abs(a - N);
		int nb = Math.abs(b - N);
		if(na >= nb && diff >= nb) return nb + Integer.toString(b).length();
		else if(nb >= diff && na >= diff) return diff;
		else return na + Integer.toString(a).length();
	}
}
