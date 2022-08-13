package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11651_좌표정렬하기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		// 우선순위 큐를 사용하여 해결해보기!
		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int[] temp = new int[] {x, y};
			priorityQueue.add(temp);
		}
		
		for(int i = 1; i <= N; i++) {
			int[] result = priorityQueue.poll();
			sb.append(result[0]).append(" ").append(result[1]).append("\n");
		}
		
		System.out.println(sb);
	}
}
