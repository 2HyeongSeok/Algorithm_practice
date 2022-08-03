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
		
		int[] hList = new int[9];
		int total9 = 0;
		for(int i = 0; i < 9; i++) {
			hList[i] = Integer.parseInt(br.readLine());
			total9 += hList[i];
		}
		Arrays.sort(hList); // 오름차순 정렬
		int remain = total9 - 100; // 100 넘어가는 만큼을 찾아야함
		
		// 난쟁이들 키 순회하면서 remain과 같아지는 두 명 찾고, 그 둘을 제외한 사람들의 키를 StringBuilder에 저장 후 출력
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(i == j) continue;
				if(hList[i] + hList[j] == remain) {
					for(int k = 0; k < 9; k++) {
						if(k == i || k == j) continue;
						sb.append(hList[k]).append("\n");
					}
					System.out.println(sb);
					return;
				}
			}
		}
	}
}
