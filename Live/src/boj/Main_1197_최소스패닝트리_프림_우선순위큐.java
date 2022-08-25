package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리_프림_우선순위큐 {

	static class Node {
		int vertex, weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static class Vertex{
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
	}

	static int[] parent;
	static Node[] adjList;
	static int V, E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new Node[V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}

		int[] minEdge = new int[V + 1];
		boolean[] visited = new boolean[V + 1];

		Arrays.fill(minEdge, Integer.MAX_VALUE); // 무한대로 초기화

		minEdge[1] = 0; // 초기 시작지점
		int result = 0;
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);
		pq.offer(new Vertex(1, minEdge[1]));
		
		int count = 0;
		while(!pq.isEmpty()) {
			// 방문하지 않은 정점 중 최소비용 선택
			Vertex minVertex = pq.poll();
			
			if(visited[minVertex.no]) continue;
			
			// 신장트리에 추가
			visited[minVertex.no] = true;
			result += minVertex.weight;
			if(++count == V) break;
			
			// 새롭게 추가되는 정점과 포함되지 않은 정점들의 기존 최소비용 비교 후 갱신
			for(Node temp = adjList[minVertex.no]; temp != null; temp = temp.next) {
				if(!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
					pq.offer(new Vertex(temp.vertex, minEdge[temp.vertex])); // 최소비용 갱신된 것들 추가
				}
			}
		}

		System.out.println(result);

	}
}