package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13300_방배정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] boyCounter = new int[7];
		int[] girlCounter = new int[7];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			if(gender == 1) 
				// 남학생
				boyCounter[grade]++;
			else 
				// 여학생
				girlCounter[grade]++;
		}
		
		int totalRoomNumbers = 0;
		for(int i = 1; i < 7; i++) {
			totalRoomNumbers += (boyCounter[i] + K - 1) / K; // 이렇게 계산해야 0명은 방 배정X / 1 ~ K명까지 한 방으로 배정
			totalRoomNumbers += (girlCounter[i] + K - 1) / K;
		}
		
		System.out.println(totalRoomNumbers);
	}
}
