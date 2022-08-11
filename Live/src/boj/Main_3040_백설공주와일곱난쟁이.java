package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3040_백설공주와일곱난쟁이 {
	static int[] noNan = new int[2];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 9C7 = 9C2, 비트마스킹?
		int[] nan = new int[9];
		int sum = 0;
		for(int i = 0; i < 9; i++) {
			nan[i] = Integer.parseInt(br.readLine());
			sum += nan[i];
		}		
		int dest = sum - 100; // 찾으려는 두 명의 키 합
		
		comb(nan, 0, 0, dest, 0);
		System.out.println(sb);
	}
	
	static void comb(int[] nan, int cnt, int start, int dest, int flag) {
		if(cnt == 2) {
			// 합이 dest랑 같으면 해당 정보 빼고.. sb에 저장
			if(nan[noNan[0]] + nan[noNan[1]] == dest)
				for(int i = 0; i < 9; i++) 
					if(nan[i] != nan[noNan[0]] && nan[i] != nan[noNan[1]]) sb.append(nan[i]).append("\n");
			
			return;
		}
		
		// 조합 찾는 재귀
		for(int i = start; i < 9; i++) {
			if((flag & 1 << i) != 0) continue;
			
			noNan[cnt] = i;
			comb(nan, cnt + 1, i + 1, dest, flag | 1 << i);
		}
	}
}
