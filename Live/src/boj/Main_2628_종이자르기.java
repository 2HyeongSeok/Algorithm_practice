package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2628_종이자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());

		
		int N = Integer.parseInt(br.readLine()); // 점선의 개수
		List<Integer> rowNums = new ArrayList<Integer>();
		List<Integer> colNums = new ArrayList<Integer>();
		rowNums.add(0); // 첫 값
		colNums.add(0); 
		for(int k = 0; k < N; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken()); // 가로(0) 세로(1) 방향
			if(dir == 0) rowNums.add(Integer.parseInt(st.nextToken())); // 점선 번호
			else colNums.add(Integer.parseInt(st.nextToken()));
		}
		rowNums.add(row); // 마지막 값
		colNums.add(col);
		
		Collections.sort(rowNums); // 넓이 순차적 계산을 위해 오름차순 정렬
		Collections.sort(colNums);
		
		// 자른 부분들로 각각 넓이 구하기
		int maxSize = 0;
		for(int i = 1; i < rowNums.size(); i++) {
			for(int j = 1; j < colNums.size(); j++) {
				int size = (rowNums.get(i) - rowNums.get(i - 1)) * (colNums.get(j) - colNums.get(j - 1));
				maxSize = maxSize > size ? maxSize : size;
			}
		}
		
		System.out.println(maxSize);
	}
}
