package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2605_줄세우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		ArrayList<Integer> arr = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		// 처음
		int index = 1;
		int num = Integer.parseInt(st.nextToken());
		arr.add(1);
		
		// 그다음
		for(int i = 2; i <= N; i++) {
			num = Integer.parseInt(st.nextToken());
			arr.add(index - num, i);
			index++;
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(arr.get(i)).append(" ");
		}
		
		System.out.println(sb);
	}
}
