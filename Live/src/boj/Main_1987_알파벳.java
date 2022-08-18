package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	static char[][] map;
	static boolean[] visited;
	static int R, C;
	static int count, maxMoved = 1;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = line[j];
			}
		}

		int i = 0, j = 0; // 처음은 따로 해줘야 재귀에서 시작점인지 조건문 타지 않아도 됨
		for (int k = 0; k < 4; k++) {
			visited = new boolean[26]; // 0:A, 25:Z
			visited[map[i][j] - 'A'] = true; 
			count = 1;
			
			int nr = dr[k] + i;
			int nc = dc[k] + j;

			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;
			
			if(!visited[map[nr][nc] - 'A']) {
				count++;
				visited[map[nr][nc] - 'A'] = true; 
				recur(nr, nc);
			}
		}
		
		System.out.println(maxMoved);
	}
	
	static void recur(int i, int j) {	
		
		for (int k = 0; k < 4; k++) {
			int nr = dr[k] + i;
			int nc = dc[k] + j;

			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;
			
			if(!visited[map[nr][nc] - 'A']) {
				visited[map[nr][nc] - 'A'] = true;	
				count++;
				
				recur(nr, nc);
				
				visited[map[nr][nc] - 'A'] = false;	
				count--;
			}
		}
		
		// 다 돌고 나면 저장!
		maxMoved = maxMoved > count ? maxMoved : count;
	}
}
