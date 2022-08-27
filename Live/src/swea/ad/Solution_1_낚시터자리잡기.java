package swea.ad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1_낚시터자리잡기 {

	static boolean[] selected, selected2;
	static int[] selectedPerm, entrans, people;
	static int minMoved, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			entrans = new int[3];
			people = new int[3];
			selectedPerm = new int[3];
			minMoved = Integer.MAX_VALUE;

			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				entrans[i] = Integer.parseInt(st.nextToken());
				people[i] = Integer.parseInt(st.nextToken());
			}

			perm(0, 0);

			sb.append("#").append(t).append(" ").append(minMoved).append("\n");
		}
		System.out.println(sb);
	}

	static void perm(int cnt, int flag) {
		if (cnt == 3) {
			// 여기서 자리배치 해야함..
			selected = new boolean[N + 1];
			selected2 = new boolean[N + 1];
			selected[0] = true;
			selected2[0] = true;
			arrange(); // 배치하는 메소드
			return;
		}

		for (int i = 0; i < 3; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			selectedPerm[cnt] = i;
			perm(cnt + 1, flag | 1 << i);
		}
	}

	static void arrange() {
		int count = 0, count2 = 0;
		for (int i = 0; i < 3; i++) {
			int index = selectedPerm[i];

			if (people[index] == 0) // 대기자가 한명도 없다면
				continue;

			int tempI = 0, tempI2 = 0;
			for (int k = 0; k < people[index]; k++) {
				// 왼쪽부터 배치 했을 때의 경우
				while (true) {
					if (entrans[index] - tempI > 0 && !selected[entrans[index] - tempI]) {
						selected[entrans[index] - tempI] = true;
						count += tempI + 1;
						break;
					}
					if (entrans[index] + tempI <= N && !selected[entrans[index] + tempI]) {
						selected[entrans[index] + tempI] = true;
						count += tempI + 1;
						break;
					}
					tempI++;
					// 둘 다 통과했다면 더 반복해야함!
				}
				
				// 오른쪽부터 배치 했을 때의 경우
				while (true) {
					if (entrans[index] + tempI2 <= N && !selected2[entrans[index] + tempI2]) {
						selected2[entrans[index] + tempI2] = true;
						count2 += tempI2 + 1;
						break;
					}
					if (entrans[index] - tempI2 > 0 && !selected2[entrans[index] - tempI2]) {
						selected2[entrans[index] - tempI2] = true;
						count2 += tempI2 + 1;
						break;
					}
					tempI2++;
					// 둘 다 통과했다면 더 반복해야함!
				}
			}
		}

		minMoved = minMoved < count ? minMoved : count;
		minMoved = minMoved < count2 ? minMoved : count2;
	}
}
