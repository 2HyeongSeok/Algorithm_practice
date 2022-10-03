package boj_class03;

import java.io.*;
import java.util.*;

public class Main_S3_9375_패션왕신해빈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			Map<String, Integer> map = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			int[] counter = new int[n+1]; // 최대 n+1가지 의상 종류
			
			int index = 0;
			for(int k = 0; k < n; k++) {
				st = new StringTokenizer(br.readLine(), " ");
				String val = st.nextToken();
				String key = st.nextToken();
				map.put(key, map.getOrDefault(key, index++));
				counter[map.get(key)]++;
			}
			
			int result = 1;
			for(int i = 0; i < index; i++) {
				result *= counter[i]+1;
			}
			result--; // 아무것도 입지 않은 상태는 1가지
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}
}
