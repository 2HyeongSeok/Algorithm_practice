package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_7568_덩치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[][] sizeArr = new int[N][2];
		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			sizeArr[i][0] = Integer.parseInt(line[0]);
			sizeArr[i][1] = Integer.parseInt(line[1]);
		}
		
		int[] rank = new int[N];
		for(int i = 0; i < N; i++) {
			rank[i] = 1;
			for(int j = 0; j < N; j++) {
				if( i == j ) continue;
				if((sizeArr[i][0] < sizeArr[j][0]) && (sizeArr[i][1] < sizeArr[j][1])) {
					// 키, 몸무게 둘 다 i < j
					rank[i]++;
				}
			}
			sb.append(rank[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
