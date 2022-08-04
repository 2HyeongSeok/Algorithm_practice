package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_9079_동전게임 {

	static ArrayList<Integer> results;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			isSelected = new boolean[8];
			results = new ArrayList<>();

			// 반복 횟수
			String[][] coins = new String[3][3];
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 3; j++) {
					coins[i][j] = st.nextToken();
				}
			}
//			for (int i = 0; i < 3; i++) {
//				for (int j = 0; j < 3; j++) {
//					System.out.print(coins[i][j]);
//				}
//				System.out.println();
//			}
//			
//			System.out.println("-----------------------------case" + (t + 1) + "---------------------------------");
			
			check(coins, 0, 0); // index -> 어느 줄 뒤집는 연산인지 / call -> 수행한 횟수

			int size = results.size();
			int min = 10;
			for (int i = 0; i < size; i++) {
				if (results.get(i) != -1) { // 허위 값 걸러내는 수단
					min = Math.min(results.get(i), min);
				}
			}
			if (min == 10)
				min = -1; // 만약 -1 외에 다른 값이 없었다면 답이 없는 것!!
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}

	static void check(String[][] coins, int index, int call) {
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
//				System.out.print(coins[i][j]);
				if (coins[i][j].equals("T"))
					cnt++;
			}
//			System.out.println();
		}

		// 전부 같은 것이므로 호출 수 return
		if (cnt == 0 || cnt == 9) {
//			System.out.println("======================== res : " + call + " =========================" );
			
			results.add(call);
			return;
		}

		// 끝
		if (index == 8) {
//			for(int i = 0; i < 8; i++) {
//				System.out.print(isSelected[i] + "\t");
//			}
//			System.out.println(cnt);
			
			results.add(-1);
			return;
		}

		// 부분집합 재귀처럼 돌렸음!
		if (index < 3) {
			isSelected[index] = true;
			for (int i = 0; i < 3; i++) {
				coins[index][i] = (coins[index][i].equals("H") ? "T" : "H");
			}
			check(coins, index + 1, call + 1);
//			System.out.println("index : " + index);
			
			// 원상태 복구
			isSelected[index] = false;
			for (int i = 0; i < 3; i++) {
				coins[index][i] = (coins[index][i].equals("H") ? "T" : "H");
			}
			check(coins, index + 1, call);
		} else if (index < 6) {
			isSelected[index] = true;
			for (int i = 0; i < 3; i++) {
				coins[i][index - 3] = (coins[i][index - 3].equals("H") ? "T" : "H");
			}
			check(coins, index + 1, call + 1);
//			System.out.println("index : " + index);

			// 원상태 복구
			isSelected[index] = false;
			for (int i = 0; i < 3; i++) {
				coins[i][index - 3] = (coins[i][index - 3].equals("H") ? "T" : "H");
			}
			check(coins, index + 1, call);
		} else if (index == 6) {
			// 좌상향 대각선 \
			isSelected[index] = true;
			for (int i = 0; i < 3; i++) {
				coins[i][i] = (coins[i][i].equals("H") ? "T" : "H");
			}
			check(coins, index + 1, call + 1);
//			System.out.println("index : " + index);

			// 원상태 복구
			isSelected[index] = false;
			for (int i = 0; i < 3; i++) {
				coins[i][i] = (coins[i][i].equals("H") ? "T" : "H");
			}
			check(coins, index + 1, call);
		} else if (index == 7) {
			// 우상향 대각선 /
			isSelected[index] = true;
			for (int i = 0; i < 3; i++) {
				coins[i][2 - i] = (coins[i][2 - i].equals("H") ? "T" : "H");
			}
			check(coins, index + 1, call + 1);
//			System.out.println("index : " + index);
			
			// 원상태 복구
			isSelected[index] = false;
			for (int i = 0; i < 3; i++) {
				coins[i][2 - i] = (coins[i][2 - i].equals("H") ? "T" : "H");
			}
			check(coins, index + 1, call);
		}

	}
}
