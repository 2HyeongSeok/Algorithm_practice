package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {
	
	static int[] selectedIndex;
	static int[] S, B;
	static int minValue = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());		
		if(N == 1) {
			st = new StringTokenizer(br.readLine(), " ");
			System.out.println((int)(Math.abs(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()))));
			return;
		}
		
		selectedIndex = new int[N];
		S = new int[N];
		B = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		// 부분집합..구해야 할 듯
		partSet(0, N, 0, 1, 0);
		
		System.out.println(minValue);
	}
	
	static void partSet(int cnt, int N, int flag, int mulS, int sumB) {
		for(int i = cnt; i < N; i++) {
			if((flag & 1 << i) != 0) continue;
			
			selectedIndex[cnt] = i;
			mulS *= S[i];
			sumB += B[i];
			int diff = Math.abs(mulS - sumB);
			
			partSet(cnt + 1, N, flag | 1 << i, mulS, sumB);
			// 모든 경우 계산해주자!
			minValue = minValue < diff ? minValue : diff;
			
			mulS /= S[i];
			sumB -= B[i];
		}
	}
}
