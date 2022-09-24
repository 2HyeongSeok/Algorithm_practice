package boj_class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780_종이의개수 {
	static int oneCount = 0, zeroCount = 0, mOneCount = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		if(N == 1) System.out.println(Integer.parseInt(br.readLine()));
		
		int[][] map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		equals9(map, N, 0, 0);
		
		sb.append(mOneCount).append("\n").append(zeroCount).append("\n").append(oneCount);
		System.out.println(sb);
	}
	
	static void equals9(int[][] map, int size, int row, int col) {
		if(size == 1) {
			// 기저조건 1
			if(map[row][col] == 1) oneCount++;
			else if(map[row][col] == 0) zeroCount++;
			else mOneCount++;
			
			return;
		}
		
		int value = size * size;
		int zero = 0, one = 0, minusOne = 0;
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				if(map[i][j] == -1) minusOne++;
				else if(map[i][j] == 0) zero++;
				else one++;
			}
		}
		
		// 기저 조건 2
		if(one == value) {
			oneCount++;
			return;
		} 
		if(zero == value) {
			zeroCount++;
			return;
		} 
		if(minusOne == value){
			mOneCount++;
			return;
		}
		
		size /= 3;
		equals9(map, size, row, col);
		equals9(map, size, row, col + size);
		equals9(map, size, row, col + (size*2));
		equals9(map, size, row + size, col);
		equals9(map, size, row + size, col + size);
		equals9(map, size, row + size, col + (size*2));
		equals9(map, size, row + (size*2), col);
		equals9(map, size, row + (size*2), col + size);
		equals9(map, size, row + (size*2), col + (size*2));
	}
}
