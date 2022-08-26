package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {
	static class Node implements Comparable<Node>{
		int vertex, weight;

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		ArrayList<ArrayList<Node>> nodeList = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= V; i++) {
			nodeList.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			nodeList.get(from).add(new Node(to, weight));
		}
		
		int[] D = new int[V+1];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[K] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(K, D[K]));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int now = cur.vertex;
			int cost = cur.weight;
			
			if(cost > D[now]) continue; // 이미 더 크므로 스킵해도 된다!
			
			for(Node temp : nodeList.get(now)) {
				if(D[temp.vertex] > cost + temp.weight) { // 만약 현재 경로를 거쳐서 temp노드에 가는 것이, 기존의 tempNode까지의 최적해보다 더 좋다면 
					D[temp.vertex] = cost + temp.weight; // 기존의 tempNode의 최적해를 갱신하고
					pq.offer(new Node(temp.vertex, D[temp.vertex])); // pq에 해당 최적해를 이용한 최소비용 계산을 진행해야 함
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(D[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(D[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}
