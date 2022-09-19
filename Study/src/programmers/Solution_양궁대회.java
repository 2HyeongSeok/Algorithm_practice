package programmers;

import java.util.*;

class Solution_양궁대회 {
	static int[] info, info_ryan, answer;
	static int n, score_apeach, score_ryan, max_diff = 0;
	static PriorityQueue<int[]> queue;

	public int[] solution(int n, int[] info) {
		this.n = n;
		this.info = info;
		info_ryan = new int[11];

		queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				for (int i = 10; i >= 0; i--) {
					if (o1[i] != o2[i])
						return o2[i] - o1[i];
				}
				return 0;
			}
		});

		dfs(0, 0);

		if (queue.isEmpty())
			answer = new int[] { -1 };
		else
			answer = queue.poll();
		return answer;
	}

	static void dfs(int start, int count) {
		if (count == n) {
			score_apeach = 0;
			score_ryan = 0;

			// n발 다 쏘고 난 후! 점수 비교해야함
			for (int i = 0; i < 11; i++) {
				if (info_ryan[i] > info[i]) {
					// ryan이 이김
					score_ryan += (10 - i);
				} else {
					// 둘 다 맞춘게 없으면 스킵해야함
					if (info[i] == 0)
						continue;

					// apeach가 이김
					score_apeach += (10 - i);
				}
			}

			if (score_ryan > score_apeach) {
				if (max_diff < score_ryan - score_apeach) { // 점수가 더 높으면
					// ( 일단 제일 높은 10점부터 중복순열을 돌리므로, 가장 나중에 나온 케이스가 낮은 점수를 많이 쏜 케이스일 것이라고 생각함 )
					max_diff = score_ryan - score_apeach;
					queue.clear();
					queue.offer(info_ryan.clone());
				} else if (max_diff == score_ryan - score_apeach) {
					queue.offer(info_ryan.clone());
				}
			}

			return;
		}

		for (int i = start; i < 11; i++) {
			info_ryan[i]++;
			dfs(i, count + 1);
			info_ryan[i]--;
		}
	}
}