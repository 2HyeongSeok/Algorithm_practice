package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_Contact {
	static Queue<Integer> queue;
	static boolean[] isVisited;
	static int[][] map;
	static int maxPerson;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int len = Integer.parseInt(st.nextToken()); // 전체 데이터 길이
			int source = Integer.parseInt(st.nextToken()); // 출발점
			map = new int[101][101]; // 인덱스로 표현하려고 (0 사용X)
			maxPerson = source; // 연결된 노드가 없으면 시작점이 곧 최대값

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < len / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				map[from][to] = 1; // 연결 정보 인접리스트로 저장
			}

			queue = new ArrayDeque<>(); // bfs를 위한 queue
			isVisited = new boolean[101]; // 방문했는지 파악

			queue.offer(source);
			isVisited[source] = true;

			bfs();

			sb.append("#").append(t).append(" ").append(maxPerson).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs() {
		Queue<Integer> tempQueue = new ArrayDeque<>();
		int tempPerson = 0; // 같은 깊이 탐색 시에 최대값 저장해 둘 변수

		while (!queue.isEmpty()) {
			int next = queue.poll();

			for (int i = 1; i <= 100; i++) {
				if (map[next][i] == 1 && !isVisited[i]) { // 방문하지 않았는데 간선이 있다!
					tempQueue.offer(i);
					isVisited[i] = true;
					tempPerson = tempPerson > i ? tempPerson : i; // 최대값 저장
				}
			}

			if (queue.isEmpty() && !tempQueue.isEmpty()) { // 기존 큐가 다 비었는데, 다음 너비 탐색할 곳이 있다면
				queue = tempQueue; // 기존 큐에 현재 임시로 담아둔 다음 너비 큐를 대입
				tempQueue = new ArrayDeque<>();
				maxPerson = tempPerson; // 최대치 갱신
				tempPerson = 0; // 다음 너비의 최대값 구하기 위해 초기화
			}
		}
	}
}
