package algo_study;

import java.io.*;
import java.util.*;

public class Main_S1_1946_신입사원 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] grades = new int[N + 1];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				grades[b] = a;
			}
			
			int count = 1, min = grades[1];
			for(int i = 2; i < grades.length; i++) {
				if(grades[i] < min) {
					min = grades[i];
					count++;
					
					if(grades[i] == 1) break;					
				}
			}
			
			sb.append(count).append("\n");
		}
		
		System.out.println(sb);
	}
}
