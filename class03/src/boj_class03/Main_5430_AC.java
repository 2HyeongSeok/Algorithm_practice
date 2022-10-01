package boj_class03;

import java.io.*;
import java.util.*;

public class Main_5430_AC {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			char[] p = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().replace("[", "").replace("]", "").split(",");			
			ArrayDeque<Integer> numArr = new ArrayDeque<>();
			for(int i = 0; i < n; i++) {
				numArr.offer(Integer.parseInt(arr[i]));
			}
			
			boolean nextFlag = false;
			boolean rFlag = false; // false면 기본, true면 뒤집힘
			for(int i = 0; i < p.length; i++) {
				if(nextFlag) break;
				
				switch(p[i]) {
				case 'R':
					if(rFlag) rFlag = false;
					else rFlag = true;
					break;
				case 'D':
					if(n > 0) {
						if(rFlag) {
							// 뒤집힌 상태 O -> 뒤에서 빼야함
							numArr.pollLast();
							n--;
						}else {
							// 뒤집힌 상태 X -> 앞에서 빼야함
							numArr.poll();
							n--;
						}
					}else {
						sb.append("error\n");
						nextFlag = true;
					}
					break;
				}
			}
			
			if(nextFlag) continue;
			
			if(n == 0) sb.append("[]\n");
			else {
				if(rFlag) { // 뒤집어서 출력해야함
					sb.append("[").append(numArr.pollLast());
					for(int i = 1; i < n; i++) {
						sb.append(",").append(numArr.pollLast());
					}
					sb.append("]\n");
				}else { // 원래 순서대로 출력해야함
					sb.append("[").append(numArr.poll());
					for(int i = 1; i < n; i++) {
						sb.append(",").append(numArr.poll());
					}
					sb.append("]\n");
				}
			}
		}
		
		System.out.println(sb);
		
	}
}
