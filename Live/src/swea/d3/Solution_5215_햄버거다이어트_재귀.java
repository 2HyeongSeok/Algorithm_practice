package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트_재귀 {

	static boolean[] isSelected;
	static int[] selectedRes;
	static int maxScore;
	static int[] scores, kcals;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			isSelected = new boolean[N];
			selectedRes = new int[N];
			maxScore = 0;
			int totalKcal = 0;
			int totalScore = 0;
			
			scores = new int[N];
			kcals = new int[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				scores[i] = Integer.parseInt(st.nextToken());
				kcals[i] = Integer.parseInt(st.nextToken());
			}

			comb(0, N, L, totalKcal, totalScore, N);
			sb.append(maxScore).append("\n");
		}
		System.out.println(sb);
	}
	
	// 조합
	static void comb(int cnt, int N, int L, int totalKcal, int totalScore, int call) {		
		if(call == 0) return;
		
		for(int i = cnt; i < N; i++) {
			if(isSelected[i]) continue;
			
			if(totalKcal + kcals[i] <= L) { // 이번꺼 더해도 된다!
				isSelected[i] = true;
				selectedRes[cnt] = i;
				
				totalKcal += kcals[i];
				totalScore += scores[i];
				comb(cnt + 1, N, L, totalKcal, totalScore, call - 1);
				maxScore = maxScore > totalScore ? maxScore : totalScore;
				
				isSelected[i] = false;
				totalKcal -= kcals[i];
				totalScore -= scores[i];
			}
		}
	}
	
}
