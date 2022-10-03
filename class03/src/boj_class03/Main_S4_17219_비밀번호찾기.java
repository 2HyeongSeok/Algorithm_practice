package boj_class03;

import java.io.*;
import java.util.*;

public class Main_S4_17219_비밀번호찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, String> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map.put(st.nextToken(), st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			sb.append(map.get(br.readLine())).append("\n");
		}
		
		System.out.println(sb);
	}
}
