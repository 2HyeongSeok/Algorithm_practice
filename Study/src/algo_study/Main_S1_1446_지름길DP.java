package algo_study;

import java.io.*;
import java.util.*;

public class Main_S1_1446_지름길DP {
	static int N, D, size, minDist = Integer.MAX_VALUE;
	static ArrayList<Node> list;
	static boolean[] visited;

	static class Node implements Comparable<Node> {
		int from, to, dist;

		public Node(int from, int to, int dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.from - o.from;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		size = 0;
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			if (to <= D && (to - from) > dist) {
				list.add(new Node(from, to, dist));
				size++;
			}
		}
		Collections.sort(list);

		int[] dp = new int[D+1];
		Arrays.fill(dp, 10000);
		
		dp[0] = 0;
		for(int i = 0; i <= D; i++) {
			if(i >= 1) {
				dp[i] = Math.min(dp[i-1] + 1, dp[i]);
			}
			
			for(int k = 0; k < size; k++) {
				Node cur = list.get(k);
				if(i == cur.from) {
					dp[cur.to] = Math.min(dp[cur.to], dp[cur.from] + cur.dist);
				}
			}
		}
		
		System.out.println(dp[D]);
	}
}
