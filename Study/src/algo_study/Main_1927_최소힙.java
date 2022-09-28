package algo_study;

import java.io.*;
import java.util.*;

public class Main_1927_최소힙 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int value = Integer.parseInt(br.readLine());
			
			if(value == 0) {
				if(pq.isEmpty()) sb.append("0\n");
				else sb.append(pq.poll()).append("\n");
			}else {
				pq.offer(value);
			}
		}
		
		System.out.println(sb);
	}
}
