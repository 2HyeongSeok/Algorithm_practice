package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_2635_수이어가기 {
	
	static List<Integer> temp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int maxSize = 0;
		List<Integer> results = new ArrayList<Integer>();
		for(int i = 1; i <= N; i++) {
			temp = new ArrayList<Integer>();
			make(N, i, 0);
			if(maxSize < temp.size()) {
				// 더 크면 갱신해야함
				maxSize = temp.size();
				results = temp;
			}
		}
		sb.append(maxSize).append("\n");
		for(int i = 0; i < results.size(); i++) {
			sb.append(results.get(i)).append(" ");
		}
		System.out.println(sb);
	}
	
	static void make(int pre, int cur, int call) {
		if(cur < 0) {
			temp.add(pre);
			return;
		}
		
		temp.add(pre); 
		make(cur, pre - cur, call + 1);
	}
}
