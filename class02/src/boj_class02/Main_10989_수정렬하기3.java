package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10989_수정렬하기3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[10001];
		for(int i = 0; i < N; i++) {
			nums[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i = 1; i < 10001; i++) {
			for(int j = 0; j < nums[i]; j++) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
		
	}
}
