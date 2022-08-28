package swea.ad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3_Shuffle_O_Matic {
	
	static int N, shuffleCount;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int[] totCards = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				int card = Integer.parseInt(st.nextToken());
				totCards[i] = card;
			}

			shuffleCount = 6;
			for(int x = 1; x < N; x++) { // i = 0은 하나마나이므로 하지 않음!!
				shuffle(totCards, x, 0);
			}
			
			if(shuffleCount == 6) { // 초기 값에서 바뀌지 않았다면 정렬 안되는 경우!!
				sb.append("#").append(t).append(" -1\n");
			}else {
				sb.append("#").append(t).append(" ").append(shuffleCount).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static boolean isSorted(int[] totCards) {
		for(int i = 1; i < N-1; i++) {
			if((totCards[i]-totCards[i-1] > 0 && totCards[i+1] - totCards[i] < 0) ||
					(totCards[i]-totCards[i-1] < 0 && totCards[i+1] - totCards[i] > 0))
				return false;
		}
		
		return true;
		
	}
	
	static void shuffle(int[] totCards, int x, int count) {
		if(count == 6 || count > shuffleCount) { // 기저조건
			return;
		}
		
		if(isSorted(totCards)) { // 정렬 되었다면
			shuffleCount = shuffleCount < count ? shuffleCount : count; // 최저값 갱신해보기
			return;
		}
		
		int half = (N-1)/2;
		int[] shuffleCards = new int[N];
		
		if(x <= half) {
			for(int i = 0; i < N; i++) {
				shuffleCards[i] = totCards[i];
			} 
			
			// 왼쪽 절반
			for(int i = half, t = x; t > 0; i--, t--) {
				shuffleCards[i+t] = totCards[i];
			}			
			// 오른쪽 절반
			for(int i = half+1, t = x; t > 0; i++, t--) {
				shuffleCards[i-t] = totCards[i];
			}
		}else {
			// 뒤집기
			for(int i = 0; i <= half; i++) {
				int temp = totCards[i];
				totCards[i] = totCards[i+half+1];
				totCards[i+half+1] = temp;
			}
			
			for(int i = 0; i < N; i++) {
				shuffleCards[i] = totCards[i];
			}
			
			int tempX = (N-1) - x;
			// 왼쪽 절반
			for(int i = half, t = tempX; t > 0; i--, t--) {
				shuffleCards[i+t] = totCards[i];
			}			
			// 오른쪽 절반
			for(int i = half+1, t = tempX; t > 0; i++, t--) {
				shuffleCards[i-t] = totCards[i];
			}
			
			// 뒤집었던 것 되돌리기
			for(int i = 0; i <= half; i++) {
				int temp = totCards[i];
				totCards[i] = totCards[i+half+1];
				totCards[i+half+1] = temp;
			}
		}
		
		for(int i = 1; i < N; i++) {
			shuffle(shuffleCards, i, count + 1);
		}
	}
}
