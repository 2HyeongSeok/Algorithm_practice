package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2309_일곱난쟁이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[] hList = new int[9];
		int total9 = 0;
		for(int i = 0; i < 9; i++) {
			hList[i] = Integer.parseInt(br.readLine());
			total9 += hList[i];
		}
		int remain = total9 % 100;
		
		int[] resList = new int[7];
		int a = -1;
		int b = -1;
		boolean isFin = false;
		for(int i = 0; i < 9; i++) {
			int sum = hList[i];
			for(int j = 0; j < 9; j++) {
				if(i == j) continue;
				if(sum + hList[j] == remain) {
					a = i;
					b = j;
					isFin = true;
					break;
				}
			}
			if(isFin) break;
		}
		
		int index = 0;
		for(int i = 0; i < 9; i++) {
			if(i == a || i == b) continue;
			resList[index++] = hList[i];
		}
		
		Arrays.sort(resList);
		
		for(int i = 0; i < 7; i++) {
			sb.append(resList[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}
