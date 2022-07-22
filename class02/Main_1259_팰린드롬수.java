package class_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1259_팰린드롬수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split("");
		int total_len, len;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			total_len = line.length;
			len = total_len / 2;
			if(total_len == 1 && line[0].equals("0")) {
				break;
			}else {
				// 홀수 : 중앙에 하나 뭐가 오던지 상관없음!
				// 짝수 : 앞뒤 비교해야함
				// 중앙 index 값 -> len
				
				if(total_len == 1) {
					sb.append("yes\n");
				}else {
					for(int i = 0; i < len; i++) {
						if(!line[i].equals(line[total_len - 1 - i])) {
							// 만약 다르면
							sb.append("no\n");
							break;
						}
						if(i == len - 1) {
							sb.append("yes\n");
						}
					}
				}
				
				line = br.readLine().split("");
			}
		}
		System.out.println(sb);
	}
}
