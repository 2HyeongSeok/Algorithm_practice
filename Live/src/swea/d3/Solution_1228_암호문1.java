package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			int[] source = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				source[i] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int k = 0; k < M; k++) {
				int x, y;
				if(st.nextToken().equals("I")) {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					int[] tempArr = new int[y];
					for(int i = 0; i < y; i++) {
						tempArr[i] = Integer.parseInt(st.nextToken());
					}
					
					int[] result = new int[N + y];
					for(int i = 0; i < x; i++) {
						result[i] = source[i];
					}
					for(int i = x; i < y + x; i++) {
						result[i] = tempArr[i - x];
					}
					for(int i = y + x; i < N + y; i++) {
						result[i] = source[i - y];
					}
					
					source = result;
					N += y;
				}
			}
			for(int i = 0; i < 10; i++) {
				sb.append(source[i]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
