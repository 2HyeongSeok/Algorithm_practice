package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main_2108_통계학 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int sum = 0; // 산술평균을 위한 총합
		double avg = 0; // 산술평균
		int roundAvg = 0; // 산술평균 반올림
		int center = 0; // 중앙값
		int mostCount = 0; // 최빈값 카운트
		int range = 0; // 최대값과 최소값 차이
		int[] arr = new int[N];
		int[] countArr = new int[8001]; // -4000~4000
		ArrayList<Integer> mostArr = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			countArr[arr[i] + 4000]++; // 최빈값을 위한 카운트
			sum += arr[i]; // 합 구하기
		}
		avg = (double)sum / N;
		roundAvg = (int)Math.round(avg); // 1. 산술평균 구함!
		sb.append(roundAvg).append("\n");
		
		Arrays.sort(arr); // 정렬
		center = arr[N/2]; // 2. 중앙값 구함!
		sb.append(center).append("\n");
		
		mostCount = countArr[0];
		mostArr.add(-4000);
		int count = 1;

		for(int i = 1; i < 8001; i++) {
			if(countArr[i] > mostCount) {
				mostCount = countArr[i];
				mostArr.clear();
				mostArr.add(i - 4000);
				count = 1;
			} else if(countArr[i] == mostCount) {
				// 최빈값 여러개
				mostArr.add(i - 4000);
				count++;
			}
		}
		
		if(count == 1)
			sb.append(mostArr.get(0)).append("\n");
		else {
			Collections.sort(mostArr);
			System.out.println(mostArr);
			sb.append(mostArr.get(1)).append("\n");
		}

		range = arr[N - 1] - arr[0]; // 4. 최대값과 최소값 차이
		sb.append(range).append("\n");
		
		System.out.println(sb);
	}
}