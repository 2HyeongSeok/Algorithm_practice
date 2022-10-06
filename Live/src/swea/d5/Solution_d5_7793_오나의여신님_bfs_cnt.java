package swea.d5;

import java.io.*;
import java.util.*;

public class Solution_d5_7793_오나의여신님_bfs_cnt {
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			boolean[][] visited = new boolean[N][M];
			boolean ok = false;
			
			char[][] map = new char[N][M];
			Queue<int[]> q = new ArrayDeque<>();
			int[] S = null;
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'S')
						S = new int[] { i, j, 1, 0 }; // 수연
					else if (map[i][j] == '*') {
						q.offer(new int[] { i, j, 0, 0 }); // 악마
					}
				}
			}
			
			q.offer(S);
			visited[S[0]][S[1]] = true;
			
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				int row = cur[0];
				int col = cur[1];
				int ev = cur[2];
				int cnt = cur[3];
				
//				if(ev == 0)
//					System.out.println("악마 위치 : " + row + ", " + col);
//				else
//					System.out.println("수연이 위치 : " + row + ", " + col);
				
				if(map[row][col] == 'D') {
					sb.append("#").append(tc).append(" ").append(cnt).append("\n");
					ok = true;
					break;
				}
				
				// 다 이동
				for(int k = 0; k < 4; k++) {
					int nr = row + dr[k];
					int nc = col + dc[k];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					
					if(ev == 0 && (map[nr][nc] == 'S' || map[nr][nc] == '.')) {
						// 악마인데 돌이나 여신위치만 아니면 가도 되니까
						map[nr][nc] = '*';
						q.offer(new int[] {nr, nc, 0, cnt + 1});
					}
					if(!visited[nr][nc] && ev == 1 && (map[nr][nc] == '.' || map[nr][nc] == 'D')) {
						// 수연이 -> 갈 수 있거나, 여신 만나면
						if(map[row][col] == 'S') map[row][col] = '.';
						if(map[nr][nc] != 'D') 
							map[nr][nc] = 'S';
						q.offer(new int[] {nr, nc, 1, cnt + 1});
						visited[nr][nc] = true;
					}
				}
			}
			
			if(!ok)
				sb.append("#").append(tc).append(" GAME OVER").append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
