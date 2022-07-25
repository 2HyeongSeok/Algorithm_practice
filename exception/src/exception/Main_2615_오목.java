package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2615_오목 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = 19;
		int[][] map = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			String[] line = br.readLine().split(" ");
			for(int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(line[j]); // 맵 저장
			}
		}
		
		int[] dr = {1, 0, 1, 1}; // 하 우 좌하 우하
		int[] dc = {0, 1, -1, 1}; // 상, 좌, 좌상, 우상은 이미 앞의 경우에 걸러내짐!
		int nr, nc;
		int count;
        boolean flag = false;
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(map[i][j] == 1 && !flag) {
					// 흰 바둑알
					for(int k = 0; k < 4; k++) {
						count = 1; // 여기서부터 다시 세기
						nr = i + dr[k];
						nc = j + dc[k];
						
						if(nr < 0 || nr >= size || nc < 0 || nc >= size)
							continue;
						while((nr >= 0 && nr < size) &&(nc >= 0 && nc < size)) {
							if(map[nr][nc] == 1) {
								nr += dr[k];
								nc += dc[k];
								count++;
							}else {
								break;
							}
						}
						if(count == 5) {
							if(i - dr[k] >= 0 && j - dc[k] >= 0 && map[i-dr[k]][j-dc[k]] == 1) {
								// 앞에꺼 봤는데 1이다? 그럼 6개인것
								continue;
							}
							if(k == 2) {
								// 좌하의 경우 출력하는 좌표가 끝 nr, nc여야함
								System.out.println("1\n" + (i + 5) + " " + (j - 3)); // i 값은 4 증가 + 1 = 총 5 증가, j 값은 4 감소 + 1 = 총 3 감소
							}else {
								System.out.println("1\n" + (i+1) + " " + (j+1));
							}
							flag = true;
						}
					}
				}else if(map[i][j] == 2 && !flag) {
					// 검은 바둑알
					for(int k = 0; k < 4; k++) {
						count = 1; // 여기서부터 다시 세기
						nr = i + dr[k];
						nc = j + dc[k];
						
						if(nr < 0 || nr >= size || nc < 0 || nc >= size)
							continue;
						while((nr >= 0 && nr < size) &&(nc >= 0 && nc < size)) {
							if(map[nr][nc] == 2) {
								nr += dr[k];
								nc += dc[k];
								count++;
							}else {
								break;
							}
						}
						if(count == 5) {
							if(i - dr[k] >= 0 && j - dc[k] >= 0 && map[i-dr[k]][j-dc[k]] == 2) {
								// 앞에꺼 봤는데 2이다? 그럼 6개인것
								continue;
							}
							if(k == 2) {
								// 좌하의 경우 출력하는 좌표가 끝 nr, nc여야함
								System.out.println("2\n" + (i + 5) + " " + (j - 3)); // i 값은 4 증가 + 1 = 총 5 증가, j 값은 4 감소 + 1 = 총 3 감소
							}else {
								System.out.println("2\n" + (i+1) + " " + (j+1));
							}
							flag = true;
						}
					}
				}else {
					continue;
				}
			}
		}
        if(flag == false) System.out.println("0");
	}
}