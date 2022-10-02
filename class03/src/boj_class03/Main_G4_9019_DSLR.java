package boj_class03;

import java.io.*;
import java.util.*;

// D : 2 * n
// S : n - 1
// L : 왼쪽으로 한 칸 이동
// R : 오른쪽으로 한 칸 이동
public class Main_G4_9019_DSLR {
	static boolean[] visited;
	static String answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			String src = st.nextToken();
			int dest = Integer.parseInt(st.nextToken());

			answer = "";
			visited = new boolean[10000];
			bfs(src, dest, "");
			
			sb.append(answer);
		}
		
		System.out.println(sb);
	}
	
	static void bfs(String src, int dest, String result) {
		ArrayDeque<String[]> queue = new ArrayDeque<>();
		int srcNum = Integer.parseInt(src);
		queue.offer(new String[] {src, result});
		visited[srcNum] = true;
				
		while(!queue.isEmpty()) {
			String[] cur = queue.poll();
			src = cur[0];
			result = cur[1];
			srcNum = Integer.parseInt(src);
			
			if(srcNum == dest) {
				answer = result + "\n";
				return;
			}

			for(int i = 0; i < 4; i++) {
				switch(i) {
				case 0: // 2배
					int srcNumTemp = (srcNum * 2) % 10000;
					if(!visited[srcNumTemp]) {
						queue.offer(new String[] {Integer.toString(srcNumTemp), result + "D"});
						visited[srcNumTemp] = true;
					}
					break;
				case 1: // n-1
					if(srcNum >= 1) {
						if(!visited[srcNum - 1]) {
							queue.offer(new String[] {Integer.toString(srcNum - 1), result + "S"});
							visited[srcNum - 1] = true;
						}
					}else {
						if(!visited[9999]) {
							queue.offer(new String[] {"9999", result + "S"});
							visited[9999] = true;
						}
					}
					break;
				case 2: // left
					int leftTemp = (srcNum % 1000) * 10 + srcNum / 1000;
					
					if(!visited[leftTemp]) {
						queue.offer(new String[] {Integer.toString(leftTemp), result + "L"});
						visited[leftTemp] = true;
					}
					break;
				case 3: // right;
					int rightTemp = (srcNum % 10) * 1000 + srcNum / 10;
					
					if(!visited[rightTemp]) {
						queue.offer(new String[] {Integer.toString(rightTemp), result + "R"});
						visited[rightTemp] = true;
					}
					break;
				}
			}
		}
	}
}
