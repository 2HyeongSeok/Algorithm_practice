package boj_class03;

import java.io.*;

public class Main_5525_IOIOI {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // O의 개수
		int M = Integer.parseInt(br.readLine()); // S의 길이
		String S = br.readLine();
		
		int index = 0;
		int[] counter = new int[M];
		int i = 0;
		while(i < M - 2) {
			if(S.charAt(i) == 'I' && S.charAt(i+1) == 'O' && S.charAt(i+2) == 'I') { // "IOI" 이면 카운팅
				if(index < N) // "IOI" 개수가 N보다 작다면 index를 키우면서 카운팅 누적 기록
					counter[i+2] = ++index;
				else if(index == N) // "IOI" 개수가 N이랑 같으면 index 유지하면서 카운팅 기록
					counter[i+2] = index;
				i += 2;
			}else { // "IOI" 아니면 한 칸 이동하고 index 리셋
				i += 1;
				index = 0;
			}
		}
		
		int answer = 0;
		for(int k = 2; k < M; k++) {
			if(counter[k] == N) answer++; // 누적 카운팅 배열의 값이 N과 같으면 -> 원하는 IOIOI... 
		}
		
		System.out.println(answer);
	}
}
