package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Map<Integer, ArrayList<Integer>> vector = new HashMap<>();
		Map<Integer, Integer> parent = new HashMap<>();
		Queue<Integer> queue = new ArrayDeque<>();

		int a, b;
		ArrayList<Integer> temp;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			// Map에 저장 key = a, value = 기존 + b
			if (vector.containsKey(a))
				temp = vector.remove(a);
			else
				temp = new ArrayList<Integer>();

			temp.add(b);
			vector.put(a, temp);

			// key = b, value = 기존 + a
			if (vector.containsKey(b))
				temp = vector.remove(b);
			else
				temp = new ArrayList<Integer>();

			temp.add(a);
			vector.put(b, temp);
		}

		queue.offer(1);

		while (!queue.isEmpty()) { // BFS
			int next = queue.poll();

			// 다음 노드가 존재하는지 확인
			ArrayList<Integer> tempList = vector.get(next);
			if (!tempList.isEmpty()) {
				for (int k = 0, size = tempList.size(); k < size; k++) {
					if (!parent.containsKey(tempList.get(k))) {
						// 방문하지 않았다면
						queue.offer(tempList.get(k));
						parent.put(tempList.get(k), next);
					}
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			sb.append(parent.get(i)).append("\n");
		}

		System.out.println(sb);
	}
}