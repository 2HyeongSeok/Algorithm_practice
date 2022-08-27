package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663_NQueen {
	static int[] queens;
	static int counter = 0, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		queens = new int[N + 1];

		select(1);
		
		System.out.println(counter);
	}

	static void select(int rowNo) {
		if(rowNo > N) {
			counter++;
			return;
		}
		
		for (int k = 1; k <= N; k++) {
			queens[rowNo] = k;
			if (isAvailable(rowNo)) { // 현재 놓은 위치가 유망하다면
				select(rowNo + 1);
			}
		}
	}

	static boolean isAvailable(int rowNo) {
		for (int i = 1; i < rowNo; i++) {
			if (queens[i] == queens[rowNo] || rowNo - i == Math.abs(queens[i] - queens[rowNo])) {
				// 같은 행이거나 행차이 = 열차이
				return false;
			}
		}
		return true;
	}
}
