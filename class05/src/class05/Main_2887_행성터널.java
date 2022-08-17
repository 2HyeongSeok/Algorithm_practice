package class05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2887_행성터널 {
	static int[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		isSelected = new int[N + 1];
		int[] x = new int[N];
		int[] y = new int[N];
		int[] z = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			z[i] = Integer.parseInt(st.nextToken());	
		}
		
		int[][] dp = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				dp[i][j] = min(Math.abs(x[i] - x[j]), Math.abs(y[i] - y[j]), Math.abs(z[i] - z[j]));
			}
		}
	}
	
	static int min(int a, int b, int c) {
		if(a >= c && b >= c) return c;
		else if(b >= a && c >= a) return a;
		else return b;
	}
	
	static void comb(int cnt, int start, int flag, int N) {
		if(cnt == N) {
			
			return;
		}
		
		for(int i = start; i < N*(N-1)/2; i++) {
			if((flag & 1 << i) != 0) continue;
			
			isSelected[i]++;
			if(isSelected[i] >= 3) {
				isSelected[i]--;
				return;
			}else {
				comb(cnt + 1, i + 1, flag | 1 << i, N);
			}
		}
	}
}
