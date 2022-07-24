package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1874_스택수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] base = new int[num]; // 기본 1 ~ num까지
		int index = 0; // 현재 인덱스 좌표
		int cnt = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < num; i++) {
			base[i] = i + 1;
		}
		
		sb.append("+"); // 처음엔 무조건 push
		
		for(int i = 0; i < num; i++) {
			int a = Integer.parseInt(br.readLine());
			
			while(index >= 0 && index < num) {
				if(base[index] == a) {
					for(int j = index; j < num - 1; j++) {
						base[j] = base[j + 1];
					}
					base[num - 1] = 0;
					sb.append("\n-");
					
					if(index == 0 && cnt < num - 1) {
						// 스택의 처음에 도달하면 인덱스 에러
						index = 0;
						sb.append("\n+");
					}else {
						index--;
					}
					break;
				}else {
					sb.append("\n+");
					index++;
				}
			}
			cnt++;
		}
		
		if(cnt == num && index < num)
			System.out.println(sb);
		else
			System.out.println("NO");
	}
}
