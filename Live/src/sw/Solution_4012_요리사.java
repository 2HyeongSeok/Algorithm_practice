package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {

	static int[] selected;
	static int[] nonSelected;
	static int[][] resources;

	static int sum = 0;
	static int sum2 = 0;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());

			selected = new int[N / 2];
			nonSelected = new int[N / 2];
			resources = new int[N][N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					resources[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			comb(0, 0, 0, N / 2);

			sb.append(min).append("\n");
		}

		System.out.println(sb);
	}

	static void comb(int cnt, int start, int flag, int N) {
		if (cnt == N) {
			// 반으로 나누는 조합 중 2개 골라야함
			int index = 0;
			for (int i = 0; i < 2 * N; i++) {
				for (int j = 0; j < N; j++) {
					if (selected[j] == i) {
						break;
					}
					if (j == N - 1) {
						nonSelected[index] = i;
						index++;
					}
				}
			}

			// 2개 골라야함
			sum = 0;
			sum2 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j)
						continue;
					sum += resources[selected[i]][selected[j]];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j)
						continue;
					sum2 += resources[nonSelected[i]][nonSelected[j]];
				}
			}

			// 최소값 구하기
			min = min < Math.abs(sum - sum2) ? min : Math.abs(sum - sum2);

			return;
		}

		// 조합 재귀
		for (int i = start; i < 2 * N; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			selected[cnt] = i;
			comb(cnt + 1, i + 1, flag | 1 << i, N);
		}

	}
}
