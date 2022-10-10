package exception;

import java.io.*;
import java.util.*;

public class Main_S1_25822_2000문제푼임스 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		float coin = Float.parseFloat(br.readLine());
		int prz = (int) (coin / 0.99);
		
		int maxProb = 0, zeroCount = 0;
		int N = Integer.parseInt(br.readLine());
		int[] probs = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			probs[i] = Integer.parseInt(st.nextToken());
			if (probs[i] == 0) {
				zeroCount++;
			}
			maxProb = maxProb > probs[i] ? maxProb : probs[i];
		}
		
		int maxLength = 0;
		if (prz > 2)
			prz = 2;
		if (zeroCount <= prz)
			maxLength = N;
		else {
			// 여기서 투포인터 활용
			int zero = 0;
			int s = 0, e = 0, length = 0;
			
			while(true) {
//				System.out.println("s : " + s + ", e : " + e + ", zero : " + zero);
				if(zero > prz) { // zero 개수가 초과
					if(probs[s] == 0) zero -= 2; // s인덱스의 배열 값이 0이면 zero 개수 -2 빼주기 (다시 probs[2]를 하면 +1이 반복..)
					s++;
					length--;
				}else if(e == N) {
					break; // 탈출 조건
				}else { // zero 개수가 아직 같거나 더 적음
					if(probs[e] == 0) { 
						zero++; // 올 때마다 더해서 문젠데..?
						if(zero <= prz) { // 만약 이번에 추가시킨 zero 개수가 프리즈보다 적거나 같다면
							e++;
							length++;
						}
					}else {
						e++;
						length++;
					}
				}
				
				maxLength = maxLength > length ? maxLength : length;
			}
		}
		sb.append(maxLength).append("\n").append(maxProb);
		System.out.println(sb);
	}
}