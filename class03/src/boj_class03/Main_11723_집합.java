package boj_class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11723_집합 {
	
	static int flag = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String oper = st.nextToken();
			int x = 0;
			if(oper.contains("add")) {
				x = Integer.parseInt(st.nextToken());
				add(x);
			}else if(oper.contains("remove")) {
				x = Integer.parseInt(st.nextToken());
				remove(x);
			}else if(oper.contains("check")) {
				x = Integer.parseInt(st.nextToken());
				sb.append(check(x)).append("\n");
			}else if(oper.contains("toggle")) {
				x = Integer.parseInt(st.nextToken());
				toggle(x);
			}else if(oper.contains("all")) {
				all();
			}else {
				empty();
			}
		}
		System.out.println(sb);
	}
	
	static void add(int x) {
		if((flag & 1 << x) == 0) 
			flag |= 1 << x; // 1로 바꾸기
	}
	
	static void remove(int x) {
		if((flag & 1 << x) != 0) 
			flag ^= 1 << x; // 0으로 바꾸기
	}
	
	static int check(int x) {
		if((flag & 1 << x) != 0) return 1;
		else return 0;
	}
	
	static void toggle(int x) {
		if((flag & 1 << x) != 0)
			remove(x);
		else 
			add(x);
	}
	
	static void all() {
		for(int i = 1; i <= 20; i++) {
			add(i);
		}
	}
	
	static void empty() {
		for(int i = 1; i <= 20; i++) {
			remove(i);
		}
	}
}
