package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2304_창고다각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		List<Integer> dots = new ArrayList<>();
		List<Integer> heights = new ArrayList<>();
		int topIdx = 0;
		int topMax = 0;

		st = new StringTokenizer(br.readLine(), " "); // 첫 값
		dots.add(Integer.parseInt(st.nextToken()));
		heights.add(Integer.parseInt(st.nextToken()));
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int dot = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			for(int j = 0; j < i; j++) {
				// 입력받은 인덱스를 오름차순으로 ArrayList에 저장하기 위한 파트
				if(dots.get(j) > dot) {
					dots.add(j, dot);
					heights.add(j, height);
					break;
				}
				if(j == i - 1) {
					dots.add(dot);
					heights.add(height);
				}
			}
		}
		
		// 최대 높이와 해당 인덱스 찾기!
		for(int i = 0; i < dots.size(); i++) {
			if(topMax < heights.get(i)) {
				topMax = heights.get(i);
				topIdx = i;
			}
		}
		
		// 제일 높은 기둥보다 왼쪽
		int tempMax = heights.get(0);
		int tempIdx = dots.get(0);
		int size = 0;
		for(int i = 0; i < topIdx; i++) {
			if(tempMax > heights.get(i + 1)) {
				continue;
			}else {
				// 크기 더해주고 최대 높이와 해당 인덱스 수정
				size += tempMax * (dots.get(i + 1) - tempIdx);
				tempMax = heights.get(i + 1);
				tempIdx = dots.get(i + 1);
			}
		}
		
		// 제일 높은 기둥
		size += topMax;
		
		// 제일 높은 기둥보다 오른쪽
		tempMax = heights.get(N - 1);
		tempIdx = dots.get(N - 1);
		for(int i = N - 1; i > topIdx; i--) {
			if(tempMax > heights.get(i - 1)) {
				continue;
			}else {
				// 크기 더해주고 최대 높이와 해당 인덱스 수정
				size += tempMax * (tempIdx - dots.get(i - 1));
				tempMax = heights.get(i - 1);
				tempIdx = dots.get(i - 1);
			}
		}
		
		System.out.println(size);
	}
}
