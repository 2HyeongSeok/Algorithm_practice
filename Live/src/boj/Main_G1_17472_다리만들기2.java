package boj;

import java.io.*;
import java.util.*;

public class Main_G1_17472_다리만들기2 {
	static int rows, cols;
	static int[][] map, labeledMap;
	static boolean[][] visited;
	
	static int[] parent;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		rows = Integer.parseInt(st.nextToken());
		cols = Integer.parseInt(st.nextToken());
		
		map = new int[rows][cols];
		labeledMap = new int[rows][cols];
		visited = new boolean[rows][cols];
		for(int i = 0; i < rows; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < cols; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬에 번호 부여하기
		int index = 1;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++){
				if(!visited[i][j] && map[i][j] == 1)
					numbering(index++, i, j);
			}
		}
		
//		for(int i = 0; i < rows; i++) {
//			System.out.println(Arrays.toString(labeledMap[i]));
//		}
		
		--index;
		parent = new int[index];
		make(index);
		
		int[][] edges = new int[16][3]; // 섬 6개가 최대 -> 간선 최대 수는 6x5 / 2 = 15
		Map<String, Integer> existed = new HashMap<>(); // 중복 처리를 위한 해시맵
		
		// 일직선 거리들 구해서 edge list에 넣기
		// 우측과 하단만 보면서 가면 된다
		int edgeIndex = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(labeledMap[i][j] != 0) {
					// 오른쪽
					int rightCount = 0;
					for(int k = j + 1; k < cols; k++) {
						if(labeledMap[i][k] == 0) rightCount++;
						else if(labeledMap[i][j] == labeledMap[i][k]) { // 자신과 같다면 구하는게 의미가 없음
							break;
						}else { // 자신과 다른 섬 번호면 edges에 추가
							if(rightCount > 1) {
								String key = Integer.toString(labeledMap[i][j]-1) + "" + Integer.toString(labeledMap[i][k]-1);
								if(!existed.containsKey(key)) {
									edges[edgeIndex++] = new int[] {labeledMap[i][j]-1, labeledMap[i][k]-1, rightCount};
									existed.put(key, edgeIndex - 1);									
								}else { // 이미 있다면 더 작은 값 넣어야함
									if(rightCount < edges[existed.get(key)][2])
										edges[existed.get(key)] = new int[] {labeledMap[i][j]-1, labeledMap[i][k]-1, rightCount};
								}
							}
							break;
						}
					}
					// 아래
					int bottomCount = 0;
					for(int k = i + 1; k < rows; k++) {
						if(labeledMap[k][j] == 0) bottomCount++;
						else if(labeledMap[i][j] == labeledMap[k][j]) { // 자신과 같다면 구하는게 의미가 없음
							break;
						}else { // 자신과 다른 섬 번호면 edges에 추가
							if(bottomCount > 1) {
								String key = Integer.toString(labeledMap[i][j]-1) + "" + Integer.toString(labeledMap[k][j]-1);
								if(!existed.containsKey(key)) {
									edges[edgeIndex++] = new int[] {labeledMap[i][j]-1, labeledMap[k][j]-1, bottomCount};
									existed.put(key, edgeIndex - 1);
								}else {
									if(bottomCount < edges[existed.get(key)][2])
										edges[existed.get(key)] = new int[] {labeledMap[i][j]-1, labeledMap[k][j]-1, bottomCount};
								}
							}
							break;
						}
					}
				}
			}
		}
		
		int[][] edgeList = new int[edgeIndex][3];
		for(int i = 0; i < edgeIndex; i++) {
			for(int j = 0; j < 3; j++) {
				edgeList[i][j] = edges[i][j];
			}
		}
		
		Arrays.sort(edgeList, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
			
		});
		
//		for(int i = 0; i < edgeIndex; i++) {
//			System.out.println(Arrays.toString(edgeList[i]));
//		}
		
		// 크루스칼 이용해서 최소 합 구하기
		int sum = 0, count = 0;
		for(int i = 0; i < edgeIndex; i++) {
			if(find(edgeList[i][0]) != find(edgeList[i][1])) {
				sum += edgeList[i][2];
				union(edgeList[i][0], edgeList[i][1]);
				if(++count == index - 1) break;
			}
		}
		
		if(count == index - 1 && sum != 0)
			System.out.println(sum);
		else
			System.out.println(-1);
	}
	
	static void make(int index) {
		for(int i = 0; i < index; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a > b) parent[b] = a;
		else parent[a] = b;
	}
	
	static void numbering(int index, int row, int col) { // 섬에 번호 부여하는 bfs
		ArrayDeque<Integer[]> queue = new ArrayDeque<>();
		
		labeledMap[row][col] = index; // 새 맵에다가 번호 부여하기
		visited[row][col] = true;
		queue.offer(new Integer[] {row, col});
		
		while(!queue.isEmpty()) {
			Integer[] cur = queue.poll();
			row = cur[0];
			col = cur[1];
			
			for(int k = 0; k < 4; k++) {
				int nr = row + dr[k];
				int nc = col + dc[k];
				
				if(nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited[nr][nc]) continue;
				
				if(map[nr][nc] == 1) {
					labeledMap[nr][nc] = index;
					visited[nr][nc] = true;
					queue.offer(new Integer[] {nr, nc});
				}
			}
		}
	}
}
