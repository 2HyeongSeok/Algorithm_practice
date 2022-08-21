package boj_class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1389_케빈베이컨의6단계법칙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer, ArrayList<Integer>> relations = new HashMap<>();
		ArrayList<Integer> relation;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if(relations.containsKey(k)) {
				// 이미 있다면
				relation = relations.remove(k);
			}else {
				relation = new ArrayList<>();
			}
			relation.add(v);
			relations.put(k, relation);
			
			if(relations.containsKey(v)) {
				relation = relations.remove(v);
			}else {
				relation = new ArrayList<>();
			}
			relation.add(k);
			relations.put(v, relation); // 그래프이므로 양방향 체크해야함
		}
		
		int minCount = Integer.MAX_VALUE;
		int minUser = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		Queue<Integer> tempQueue = new ArrayDeque<>();
		
		boolean[] visited; 
		for(int i = 1; i <= N; i++) { // 유저 수만큼 돌면서 체크
			int count = 1;
			int KBCount = 0;
			visited = new boolean[N+1];
			
			queue.offer(i);
			visited[i] = true;
			
			while(!queue.isEmpty()) {
				// 유저마다 BFS 돌리기! 
				ArrayList<Integer> temp = relations.get(queue.poll());
				int size = temp.size();
				for(int k = 0; k < size; k++) {
					if(!visited[temp.get(k)]) {
						visited[temp.get(k)] = true;
						tempQueue.offer(temp.get(k));

						// 유저별 새롭게 방문한 친구에 대해 깊이 더해줌
						KBCount += count;
					}
				}
				
				if(queue.isEmpty() && !tempQueue.isEmpty()) {
					// 깊이 체크
					queue = tempQueue;
					tempQueue = new ArrayDeque<>();
					count++;
				}
			}
			
			if(minCount > KBCount) {
				minCount = KBCount;
				minUser = i;
			}
		}
		
		System.out.println(minUser);
	}
}
