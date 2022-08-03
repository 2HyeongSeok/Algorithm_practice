package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1873_상호의배틀필드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 테케 수 입력
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			// 높이 너비 입력
			String[] line = br.readLine().split(" ");
			int H = Integer.parseInt(line[0]);
			int W = Integer.parseInt(line[1]);
			
			// 맵 입력 + 전차 위치 파악
			int row = -1;
			int col = -1;
			char[][] map = new char[H][W];
			for(int i = 0; i < H; i++) {
				char[] lines = br.readLine().toCharArray();
				for(int j = 0; j < W; j++) {
					map[i][j] = lines[j];
					if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						row = i;
						col = j;
					}
				}
			}
			
			// 입력 개수 N과 길이 N인 문자열
			int N = Integer.parseInt(br.readLine());
			char[] input = br.readLine().toCharArray();
			
			// 문자열 처리
			for(int k = 0; k < N; k++) {
				switch(input[k]) {
				case 'U':
					// 위쪽으로 이동
					map[row][col] = '^'; // 현재 포신 방향 바꿈
					if(row - 1 >= 0 && map[row - 1][col] == '.') {
						// 이동 가능 -> 자기 자리 .으로 만들고 이동
						map[row][col] = '.';
						map[--row][col] = '^'; 
					}
					break;
				case 'D':
					// 아래쪽으로 이동
					map[row][col] = 'v'; // 현재 포신 방향 바꿈
					if(row + 1 < H && map[row + 1][col] == '.') {
						// 이동 가능 -> 자기 자리 .으로 만들고 이동
						map[row][col] = '.';
						map[++row][col] = 'v'; 
					}
					break;
				case 'L':
					// 왼쪽으로
					map[row][col] = '<'; // 현재 포신 방향 바꿈
					if(col - 1 >= 0 && map[row][col - 1] == '.') {
						// 이동 가능 -> 자기 자리 .으로 만들고 이동
						map[row][col] = '.';
						map[row][--col] = '<'; 
					}
					break;
				case 'R':
					// 오른쪽으로
					map[row][col] = '>'; // 현재 포신 방향 바꿈
					if(col + 1 < W && map[row][col + 1] == '.') {
						// 이동 가능 -> 자기 자리 .으로 만들고 이동
						map[row][col] = '.';
						map[row][++col] = '>'; 
					}
					break;
				case 'S':
					// 포탄 발사
					int index = 1;
					if(map[row][col] == '>') {
						// 오른쪽
						while(col + index < W) {							
							if(map[row][col + index] == '*'){
								// 벽돌
								map[row][col + index] = '.';
								break;
							}else if(map[row][col + index] == '#') {
								// 강철
								break;
							}
							index++;
						}
					}else if(map[row][col] == '<') {
						// 왼쪽
						while(col - index >= 0) {
							if(map[row][col - index] == '*'){
								// 벽돌
								map[row][col - index] = '.';
								break;
							}else if(map[row][col - index] == '#') {
								// 강철
								break;
							}
							index++;
						}
					}else if(map[row][col] == '^') {
						// 위
						while(row - index >= 0) {
							if(map[row - index][col] == '*'){
								// 벽돌
								map[row - index][col] = '.';
								break;
							}else if(map[row - index][col] == '#') {
								// 강철
								break;
							}
							index++;
						}
					}else if(map[row][col] == 'v') {
						// 아래
						while(row + index < H) {
							if(map[row + index][col] == '*'){
								// 벽돌
								map[row + index][col] = '.';
								break;
							}else if(map[row + index][col] == '#') {
								// 강철
								break;
							}
							index++;
						}
					}
					break;
				}
			}
			
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
