package class_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1018_체스판다시칠하기 {
	public static void main(String[] args) throws IOException {
		// "BWBWBWBW", "WBWBWBWB"
		char [][] bw = {{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},{'W', 'B', 'W', 'B', 'W', 'B' ,'W', 'B'},{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},{'W', 'B', 'W', 'B', 'W', 'B' ,'W', 'B'},{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},{'W', 'B', 'W', 'B', 'W', 'B' ,'W', 'B'},{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},{'W', 'B', 'W', 'B', 'W', 'B' ,'W', 'B'}};
		char [][] wb = {{'W', 'B', 'W', 'B', 'W', 'B' ,'W', 'B'},{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},{'W', 'B', 'W', 'B', 'W', 'B' ,'W', 'B'},{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},{'W', 'B', 'W', 'B', 'W', 'B' ,'W', 'B'},{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},{'W', 'B', 'W', 'B', 'W', 'B' ,'W', 'B'},{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		
		int n = Integer.parseInt(size[0]);
		int m = Integer.parseInt(size[1]);
		
		String[] arr = new String[n];
		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		
		// 배열 초기화
		char[][] arr_map = new char[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr_map[i][j] = arr[i].charAt(j);
			}
		}
		
		int count, count2;
		int min = 64;
		for(int i = 0; i <= n - 8; i++) {
			for(int j = 0; j <= m - 8; j++) {
				count = 0; // "BWBWBWBW" 케이스 불일치 counting -> 값이 크면 그만큼 일치도 낮다
				count2 = 0; // "WBWBWBWB" 케이스 counting -> 동일
				
				for(int p = i; p < i + 8; p++) {
					for(int q = j; q < j + 8; q++){
						if(arr_map[p][q] != bw[p - i][q - j]) {
							count++;
						}
						if(arr_map[p][q] != wb[p - i][q - j]) {
							count2++;
						}
					}
				}
				if(count < count2 && count < min) {
					min = count;
				}else if(count2 <= count && count2 < min) {
					min = count2;
				}
			}
		}
		System.out.println(min);
	}
}
