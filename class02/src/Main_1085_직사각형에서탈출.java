package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1085_직사각형에서탈출 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		int x = Integer.parseInt(line[0]);
		int y = Integer.parseInt(line[1]);
		int w = Integer.parseInt(line[2]);
		int h = Integer.parseInt(line[3]);
		
		// 왼쪽 아래 꼭짓점은 (0, 0)
		// 오른쪽 위 꼭짓점은 (w, h)
		// 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램
		
		int answer; 
		int x_min = 1000, y_min = 1000; // 최대값을 가지고 있다가 최소값으로 저장
		if(x >= w - x) {
			x_min = w - x;
		}else {
			x_min = x;
		}
		if(y >= h - y) {
			y_min = h - y;
		}else {
			y_min = y;
		}
		
		answer = Math.min(x_min, y_min);
		System.out.println(answer);
	}
}
