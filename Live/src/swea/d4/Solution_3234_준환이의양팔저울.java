package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3234_준환이의양팔저울 {
	static int[] Ws, selected;
	static boolean[] visited;
	static int totalCount;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			totalCount = 0;
			int N = Integer.parseInt(br.readLine());
			Ws = new int[N];
			selected = new int[N];
			visited = new boolean[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				Ws[i] = Integer.parseInt(st.nextToken());
			}

			// 구현부
			permutation(N, 0, 0);
			
			sb.append(totalCount).append("\n");
		}
		System.out.println(sb);
	}

	static void permutation(int N, int cnt, int flagP) {
		if (cnt == N) {
			checkAndSum(0, 0, N, 0);
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flagP & 1 << i) != 0)
				continue;

			selected[cnt] = Ws[i];
			permutation(N, cnt + 1, flagP | 1 << i);
		}
	}

	static void checkAndSum(int leftSum, int rightSum, int N, int count) {
		if (count == N) { // 가능한 경우이므로 count올리고 종료
			totalCount++;
			return;
		}

		// 왼쪽에 더하기
		checkAndSum(leftSum + selected[count], rightSum, N, count + 1);

		// 오른쪽에 더할 수 있으면 더하는 케이스 계산
		// 더할 수 없다면 왼쪽만 계산하러 가면 된다..
		if (leftSum >= rightSum + selected[count]) {
			checkAndSum(leftSum, rightSum + selected[count], N, count + 1);
		}
	}
}