package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_18111_마인크래프트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
		}
		Collections.sort(arr);

		// 제거하는 작업 2초, 쌓는 작업 1초
		
		PriorityQueue<int[]> timeMap = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return o2[0] - o1[0]; // 시간이 같으면 높이가 높은순!
				return o1[1] - o2[1]; // 시간은 짧은 순!
			}
		});

		int maxHeight = arr.get(arr.size() - 1);
		int minHeight = arr.get(0);
		for(int destHeight = maxHeight; destHeight >= minHeight; destHeight--) {
			int sum = 0;
			for (int j = 0; j < arr.size(); j++) {
				if(destHeight <= arr.get(j)) break; // 높이 차이가 없는 경우
				
				// 높이 차이
				sum += destHeight - arr.get(j); 
			}

			int plusBlocks = 0;
			for (int k = arr.size() - 1; k >= 0; k--) {
				// i + 1 번째 인덱스부터 마지막 인덱스까지는 깎는 경우이므로 블록개수에 더해줌
				if(arr.get(k) <= destHeight) break;
				plusBlocks += arr.get(k) - destHeight;
			}
			B += plusBlocks;

			if (sum <= B) {
				// 가능한 경우 Priority Queue에 저장!!
				int[] temp = new int[] { destHeight, 2 * plusBlocks + sum };
				timeMap.add(temp); // 높이와 시간에 대해서 맵에 저장
			}

			B -= plusBlocks; // 기존 B 값으로 되돌리기 (다음 케이스 해야함)
		}

		int[] result = timeMap.poll();
		sb.append(result[1]).append(" ").append(result[0]);
		System.out.println(sb);
	}
}
