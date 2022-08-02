package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1954_달팽이숫자 {
	static Queue<Integer> queue = new LinkedList<>();
	static int[][] finalArr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 횟수
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N * N; i++) {
				queue.add(i + 1);
			}
			
			finalArr = new int[N][N];
			insert1(0, 0, N, 0);
			
			sb.append("#").append(t).append("\n");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(finalArr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static void insert1(int row, int col, int N, int index) {
		// 오른쪽으로
		if(queue.isEmpty()) return; // 기저조건
		while(col < N - index) {
			finalArr[row][col++] = queue.poll();
		}
		insert2(row + 1, col - 1, N, index); // col++ 때문에 col-1 해줘야함
	}
	
	static void insert2(int row, int col, int N, int index) {
		// (오른쪽) 아래로
		if(queue.isEmpty()) return; // 기저조건
		while(row < N - index) {
			finalArr[row++][col] = queue.poll();
		}
		insert3(row - 1, col - 1, N, index); // row++ 때문에 row-1 해줘야함
	}
	
	static void insert3(int row, int col, int N, int index) {
		// 왼쪽으로
		if(queue.isEmpty()) return; // 기저조건
		while(col >= 0 + index) {
			finalArr[row][col--] = queue.poll();
		}
		insert4(row - 1, col + 1, N, index + 1); // col-- 때문에 col+1 해줘야함
	}
	
	static void insert4(int row, int col, int N, int index) {
		// (왼쪽) 위로
		if(queue.isEmpty()) return; // 기저조건
		while(row >= 0 + index) {
			finalArr[row--][col] = queue.poll();
		}
		insert1(row + 1, col + 1, N, index); // row-- 때문에 row+1 해줘야함
	}
}
