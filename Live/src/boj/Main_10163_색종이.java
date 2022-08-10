package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10163_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		if(N == 1) {
			String[] line = br.readLine().split(" ");
			sb.append(Integer.parseInt(line[2]) * Integer.parseInt(line[3]));
		}else {
			int[][] map = new int[1001][1001];
			int[] counter = new int[N + 1];
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int width = Integer.parseInt(st.nextToken());
				int height = Integer.parseInt(st.nextToken());
				
				for(int m = x; m < x + width; m++) {
					for(int n = y; n < y + height; n++) {
						map[m][n] = i; // 해당 색종이 번호
					}
				}
			}
			
			for(int i = 0; i <= 1000; i++) {
				for(int j = 0; j <= 1000; j++) {
					counter[map[i][j]]++;
				}
			}
			
			for(int i = 1; i <= N; i++) {
				if(counter[i] == 0) sb.append(0).append("\n");
				else sb.append(counter[i]).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
