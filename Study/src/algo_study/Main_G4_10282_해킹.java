package algo_study;

import java.io.*;
import java.util.*;

public class Main_G4_10282_해킹 {
	static ArrayList<Integer>[] list;
	static Map<Integer, Integer> map;
	static int[] visited;
	static int finalTime, finalCount;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()); // 컴퓨터 수
			int d = Integer.parseInt(st.nextToken()); // 의존성 수
			int c = Integer.parseInt(st.nextToken()) - 1; // 컴퓨터의 번호
			
			visited = new int[n];
			Arrays.fill(visited, Integer.MAX_VALUE);
			
			list = new ArrayList[n];
			for(int i = 0; i < n; i++) {
				list[i] = new ArrayList<>();
			}
			
			map = new HashMap<>();
			for(int k = 0; k < d; k++) {
				st = new StringTokenizer(br.readLine());
				// a가 b를 의존하며, b 감염 s초 후 a도 감염
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				int s = Integer.parseInt(st.nextToken());
				
				list[b].add(a);
				map.put(b*10000 + a, s);
			}
			
			finalCount = 1;
			finalTime = Integer.MAX_VALUE;
			dfs(c, 0);
			sb.append(finalCount).append(" ").append(finalTime).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int index, int time) {
		for(int next : list[index]) {
			int nextTime = time + map.get(index * 10000 + next);
			if(visited[next] > nextTime) {
				if(visited[next] == Integer.MAX_VALUE) { // 첫 방문이라면
					finalCount++;
					visited[next] = finalTime = nextTime;
					dfs(next, nextTime);					
				}else {
					visited[next] = finalTime = nextTime;
					dfs(next, nextTime);					
				}
			}
		}
	}
}
