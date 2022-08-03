package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2578_빙고 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 빙고판 저장
		int[][] map = new int[5][5];
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 사회자 숫자 일차원 배열로 저장
		int[] nums = new int[25];
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				nums[i * 5 + j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] rowCheck = new int[5]; // 행마다 불린 칸 몇개인지 체크
		int[] colCheck = new int[5]; // 열마다 불린 칸 몇개인지 체크
		int rdDigonal = 0; // 오른쪽 아래 대각선 \ 체크
 		int luDigonal = 0; // 왼쪽 위 대각선 / 체크
		int bingoCount = 0; // 빙고 개수
		boolean isFind; // 빙고맵에서 찾았으면 사회자의 다음 수 찾기 위해 break
		
		for(int n = 0; n < 25; n++) {
			isFind = false;
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					if(map[i][j] == nums[n]) {
						// 사회자가 부른 수에 해당하는 칸 찾음!
						rowCheck[i]++;
						colCheck[j]++;
						if(i == j) rdDigonal++;
						if(i + j == 4) luDigonal++;
						if(rowCheck[i] == 5 || colCheck[j] == 5 || rdDigonal == 5 || luDigonal == 5) {
							// 한 줄이 완성되면
							// 임시로 값 바꿔야 다시 안들어옴!
							if(rowCheck[i] == 5) {
								bingoCount++;
								rowCheck[i]++;
							}
							if(colCheck[j] == 5) {
								bingoCount++;
								colCheck[j]++;
							}
							if(rdDigonal == 5) {
								bingoCount++;
								rdDigonal++;
							}
							if(luDigonal == 5) {
								bingoCount++;
								luDigonal++;
							}
							
							if(bingoCount >= 3) {
								// 3빙고면 몇번째인지 출력하고 종료
								System.out.println(n + 1);
								return;
							}
						}
						isFind = true;
						break;
					}
				}
				if(isFind) break;
			}
		}
	}
}
