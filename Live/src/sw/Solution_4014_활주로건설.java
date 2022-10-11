package sw;

import java.io.*;
import java.util.*;

public class Solution_4014_활주로건설 {

	static int[][] map, map2;
	static int N, X;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 맵 NxN
			X = Integer.parseInt(st.nextToken()); // 경사로 길이

			map = new int[N][N];
			map2 = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map2[j][i] = map[i][j] = Integer.parseInt(st.nextToken()); // 지형의 높이
				}
			}
			
			int count = 0;
			for(int k = 0; k < N; k++) {
				// 수직(열 별)
				if(make(map2[k])) count++;
				
				// 수평(행 별)
				if(make(map[k])) count++;
				
			}
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
	private static boolean make(int[] arr) {
		int base = arr[0];
		int length = 0, i = 0;
		
		while(i < N) {
			if(base == arr[i]) {
				// 높이가 같음
				length++;
				i++;
			}else if(base + 1 == arr[i]) {
				// 높이가 1 높아짐
				if(length < X) return false;
				
				if(length >= X) {
					base = arr[i];
					length = 1;
					i++;					
				}
			}else if(base - 1 == arr[i]) {
				// 높이가 1 낮아짐
				int count = 0;
				for(int j = i; j < N; j++) {
					if(arr[i] != arr[j]) return false;
					
					if(++count == X) break;
				}
				if(count < X) return false;
				
				if(count == X) {
					base--;
					length = 0;
					i += X;
				}
			}else { // 높이가 2 이상 차이나면 불가능
				return false;
			}
		}
		
		return true;
	}
}
