package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2231_분해합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int val = 0;
		boolean flag = false;
		
		for(int i = 0; i < num; i++) {
			val = i + (i / 100000) + (i % 100000 / 10000) + (i % 10000 / 1000) + (i % 1000 / 100) + (i % 100 / 10) + (i % 10);
			if(val == num) {
				flag = true;
				sb.append(i);
				break;
			}
		}
		
		if(!flag)
			sb.append(0);
		
		System.out.println(sb);
		
//		for(int i = 0; i <= num; i++) {
//			if(flag) {
//				if(num == 1000000) {
//					i = 999900;
//					val = i;
//					base = 100000;
//				}else if(num >= 100000) {
//					i = 99900;
//					val = i;
//					base = 10000;
//				}else if(num >= 10000) {
//					i = 9900;
//					val = i;
//					base = 1000;
//				}else if(num >= 1000) {
//					i = 900;
//					val = i;
//					base = 100;
//				}else if(num >= 100) {
//					i = 90;
//					val = i;
//					base = 10;
//				}else {
//					val = i;
//					base = 1;
//				}
//				flag = false;
//			}
//			
//			int j = i;
//			while(base >= 1) {
//				val += j / base;
//				j %= base;
//				base /= 10;
//			}
//			
//			if(val == num) {
//				sb.append(val);
//				break;
//			}
//			
//		}
//		System.out.println(sb.toString());
//		if(sb.toString() == null)
//			sb.append("0");
//		
//		System.out.println(sb);
	}
}
