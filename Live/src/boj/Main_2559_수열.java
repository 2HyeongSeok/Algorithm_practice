package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2559_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] temps = new int[N];
		ArrayList<Integer> tempSumList = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		int sum = 0;
		for(int i = 0; i < N; i++) {
			// 온도를 받을 때부터 계산해서 넣기도 가능 ? K일씩
			temps[i] = Integer.parseInt(st.nextToken());
			sum += temps[i];

			if(i >= K - 1) {
				tempSumList.add(sum);
				sum -= temps[i - K + 1]; // 이전 합은 빼야 함
			}
		}
		
		Collections.sort(tempSumList);
		
		System.out.println(tempSumList.get(N - K));
		
	}
}
