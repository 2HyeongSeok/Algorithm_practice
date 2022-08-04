package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2564_경비원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		
		int num = Integer.parseInt(br.readLine()); // 상점의 수
		
		// num개의 상점 위치 - 1북 2남 3서 4동
		int[] dirs = new int[num];
		int[] diss = new int[num];
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			dirs[i] = dir;
			diss[i] = dis;
		}
		
		// 동근이의 위치
		st = new StringTokenizer(br.readLine(), " ");
		int dongDir = Integer.parseInt(st.nextToken());
		int dongDis = Integer.parseInt(st.nextToken());
		
		int disSum = 0;
		for(int i = 0; i < num; i++) {
			if(dongDir == dirs[i]) {
				disSum += Math.abs(dongDis - diss[i]);
				continue;
			}
			int direction = dongDir + dirs[i];
			int distance = dongDis + diss[i];
			switch(direction) {
			case 3:
				// 북-남
				if(distance <= col) {
					disSum += distance + row;
				}else {
					disSum += 2 * col - distance + row;
				}
				break;
			case 4:
				// 북-서
				disSum += distance;
				break;
			case 5:
				// 북-동 or 남-서
				if(dongDir == 1) {
					// 북-동 (동근 북)
					disSum += col - dongDis + diss[i];
				}else if(dongDir == 4){
					// 북-동 (동근 동)
					disSum += dongDis + col - diss[i];
				}else if(dongDir == 2){
					// 남-서 (동근 남)
					disSum += dongDis + row - diss[i];
				}else {
					// 남-서 (동근 서)
					disSum += row - dongDis + diss[i];
				}
				break;
			case 6:
				// 남-동
				if(dongDir == 2) {
					// 동근 남
					disSum += col - dongDis + row - diss[i];
				}else {
					// 동근 동
					disSum += row - dongDis + col - diss[i];
				}
				break;
			case 7:
				// 동-서
				if(distance <= row) {
					disSum += distance + col;
				}else {
					disSum += 2 * row - distance + col;
				}
				break;
			default:
				break;
			}
		}
		
		System.out.println(disSum);
	}
}
