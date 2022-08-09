package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임 {
	
	static boolean[] isChecked;
	static int[] temp;
	static int[] yy, gy;
	static int gyCount, yyCount;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			gy = new int[9];
			for(int i = 0; i < 9; i++) {
				gy[i] = Integer.parseInt(st.nextToken());
			}
			
			// 인영이 카드 목록 저장
			yy = new int[9];
			int index = 0;
			for(int i = 1; i <= 18; i++) {
				for(int j = 0; j < 9; j++) {
					if(i == gy[j]) break;
					if(j == 8) 
						yy[index++] = i;
				}
			}
			
			// 순열.. 9!가지..?
			gyCount = 0;
			yyCount = 0;
			isChecked = new boolean[9];
			temp = new int[9];
			permutation(0);
			
			sb.append(gyCount).append(" ").append(yyCount).append("\n");
		}
		System.out.println(sb);
	}
	
	static void permutation(int cnt) {
		// 기저조건
		if(cnt == 9) {
			// 이긴 횟수 계산 카운팅
			int gyScore = 0;
			int yyScore = 0;
			for(int i = 0; i < 9; i++) {
				if(temp[i] > gy[i]) yyScore += temp[i] + gy[i];
				else if(temp[i] < gy[i]) gyScore += temp[i] + gy[i];
			}
			
			if(yyScore > gyScore) yyCount++;
			else if(gyScore > yyScore) gyCount++;
			
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(isChecked[i]) {
				continue;
			}
			
			isChecked[i] = true;
			temp[cnt] = yy[i];
			permutation(cnt + 1);
			isChecked[i] = false;
		}
	}
}
