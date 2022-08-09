package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9095_123더하기 {
	static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			count = 0;
			int dest = Integer.parseInt(br.readLine());
			check(1, dest);
			check(2, dest);
			check(3, dest);
			
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
	
	static void check(int total, int dest) {
		// 기저 조건
		if(total > dest) return;
		else if(total == dest) {
			count++;
			return;
		}if(total < dest) {
			check(total + 1, dest);
			check(total + 2, dest);
			check(total + 3, dest);
		}
	}
}
