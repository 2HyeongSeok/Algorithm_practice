package boj_class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11279_최대힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int value = Integer.parseInt(br.readLine());
			if(value == 0) {
				if(queue.isEmpty()) sb.append("0\n");
				else sb.append(queue.poll()).append("\n");
			}else {
				queue.offer(value);
			}
		}
		
		System.out.println(sb);
	}
}
