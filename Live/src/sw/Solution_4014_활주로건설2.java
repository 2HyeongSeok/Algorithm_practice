package sw;

import java.io.*;
import java.util.*;

public class Solution_4014_활주로건설2 {
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

			int[][] map = new int[N][N];
			int[][] map2 = new int[N][N];
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
		int beforeHeight = arr[0], size = 0;
		int j = 0;
		
		while(j < N) {
			if(beforeHeight == arr[j]) { // 동일 높이
				size++;
				j++;
			}else if(beforeHeight + 1 == arr[j]) { // 이전 높이보다 1 높으므로 오르막 설치 가능한지?
				if(size < X) return false;
				
				beforeHeight++;
				size = 1;
				j++;
			}else if(beforeHeight - 1 == arr[j]) { // 이전 높이보다 1 낮으므로 내리막 설치 가능한지?
				int count = 0;
				for(int k = j; k < N; k++) {
					if(arr[k] != beforeHeight-1) return false;
					
					if(++count == X) break;
				}
				
				// 반복문이 끝나서 온 것
				if(count < X) return false;
				
				// 길이 만족해서 나왔다면
				beforeHeight--;
				j += X;
				size = 0;
			}else { // 높이가 2 이상 차이
				return false;
			}
		}
		
		return true;
	}
}
