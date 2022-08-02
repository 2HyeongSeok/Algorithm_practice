package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1210_Ladder1 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			// 테스트케이스 10개
			String caseNum = br.readLine();
			String[][] maps = new String[100][100];
			for(int i = 0; i < 100; i++) 
				maps[i] = br.readLine().split(" "); // 배열 저장
			
			int resultIndex = 0;
			for(int i = 0; i < 100; i++) 
				// 도착지점 좌표 찾음 (99, resultIndex)
				if(maps[99][i].equals("2")) resultIndex = i; 
			
			sb.append("#").append(t).append(" ");
			move(maps, 99, resultIndex);
		}
		
		System.out.println(sb);
	}
	
	static void move(String[][] maps, int row, int col) {
		// 기저조건
		if(row == 0) {
			sb.append(col).append("\n");
			return;
		}
		
		// 이전에 왔던 길이면 0으로 바꿔주는게 좋을듯?
		
		maps[row][col] = "0";
		if(col == 0) {
			if(maps[row][col + 1].equals("1")) move(maps, row, col + 1);
			else if(maps[row - 1][col].equals("1")) move(maps, row - 1, col);
		}else if(col == 99) {
			if(maps[row][col - 1].equals("1")) move(maps, row, col - 1);
			else if(maps[row - 1][col].equals("1")) move(maps, row - 1, col);
		}else {
			if(maps[row][col + 1].equals("1")) move(maps, row, col + 1);
			else if(maps[row][col - 1].equals("1")) move(maps, row, col - 1);
			else if(maps[row - 1][col].equals("1")) move(maps, row - 1, col);
		}
	}
}
