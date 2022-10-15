package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {
	
	static int maxValue = 0, row, col;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		visited = new boolean[row][col];
		map = new int[row][col];
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visited[i][j] = false;
			}
		}
		
		System.out.println(maxValue);
	}
	
	static void dfs(int r, int c, int count, int value) {
		if(count == 4) {
			maxValue = maxValue > value ? maxValue : value;
			return;
		}
		
		if(count == 2) { // ㅏ, ㅓ, ㅜ, ㅗ 모양을 위해서 bfs
			ArrayList<Integer> list = new ArrayList<>();
			
			int sum = 0;
			for(int k = 0; k < 4; k++) { // 모든 케이스 가능(ㅏ,ㅓ,ㅜ,ㅗ 제외)
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if(nr < 0 || nr >= row || nc < 0 || nc >= col || visited[nr][nc]) continue;
				
				list.add(map[nr][nc]);
				sum += map[nr][nc];
			}
			
			if(list.size() == 2) {
				maxValue = maxValue > sum + value ? maxValue : sum + value;
			}else if(list.size() == 3){
				int max = 0;
				for(int i = 0; i < 3; i++) {
					max = max > sum - list.get(i) ? max : sum - list.get(i);
				}
				maxValue = maxValue > max + value ? maxValue : max + value;
			}
		}
		
		for(int k = 0; k < 4; k++) { // 모든 케이스 가능(ㅏ,ㅓ,ㅜ,ㅗ 제외)
			int nr = r + dr[k];
			int nc = c + dc[k];
			
			if(nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
			
			if(!visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, count + 1, value + map[nr][nc]);
				visited[nr][nc] = false;
			}
		}
	}
}
