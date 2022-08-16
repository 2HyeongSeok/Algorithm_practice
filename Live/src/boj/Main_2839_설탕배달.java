package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_설탕배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int dupN = N;
		int count = 0;
		
		int val = dupN / 5; // 5킬로짜리 최대 몇개?
		int remain = dupN % 5; // 남은 킬로
		for(int i = val; i >= 0; i--) {
			count = i;
			if(remain % 3 == 0) {
				count += remain / 3;
				sb.append(count);
				break;
			}
			
			remain += 5; // 반복 할 때마다 5킬로짜리 한 개씩 뺀 것이므로 더해줌
			
			if(i == 0) {
				// 마지막까지 다 돌았는데 불가능하면 -1
				sb.append(-1);
			}
		}
		System.out.println(sb);
	}
}
