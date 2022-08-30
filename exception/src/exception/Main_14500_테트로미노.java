package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		
		map = new int[row][col];
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				visited = new boolean[row][col];
				visited[i][j] = true;
				dfs(i, j, 0, 0);
			}
		}
		
		for(int i = 1; i < row - 1; i++) { 
			int temp;
			for(int j = 0; j < col - 1; j++) { // 'ㅏ' 모양
				temp = map[i-1][j] + map[i][j] + map[i+1][j] + map[i][j+1];
				maxValue = maxValue > temp ? maxValue : temp;
			}
			
			for(int j = col - 1; j > 0; j--) { // 'ㅓ' 모양
				temp = map[i-1][j] + map[i][j] + map[i+1][j] + map[i][j-1];
				maxValue = maxValue > temp ? maxValue : temp;
			}
		}
		
		for(int j = 1; j < col - 1; j++) { 
			int temp;
			for(int i = 0; i < row - 1; i++) { // 'ㅜ' 모양
				temp = map[i][j-1] + map[i][j] + map[i][j+1] + map[i+1][j];
				maxValue = maxValue > temp ? maxValue : temp;
			}
			
			temp = 0;
			for(int i = row - 1; i > 0; i--) { // 'ㅗ' 모양
				temp = map[i][j-1] + map[i][j] + map[i][j+1] + map[i-1][j];
				maxValue = maxValue > temp ? maxValue : temp;
			}
		}
		
		System.out.println(maxValue);
	}
	
	static void dfs(int r, int c, int count, int value) {
		if(count == 4) {
			maxValue = maxValue > value ? maxValue : value;
			return;
		}
		
		for(int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			
			if(nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
			
			if(!visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, count + 1, value + map[r][c]);
				visited[nr][nc] = false;
			}
		}
		
	}
}
