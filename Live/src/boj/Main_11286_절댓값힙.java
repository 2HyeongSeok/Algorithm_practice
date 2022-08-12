package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11286_절댓값힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> nums = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
				return Math.abs(o1) - Math.abs(o2);
			}
			
		});
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(nums.isEmpty()) {
					// 배열이 비어있음
					sb.append("0\n");
				}else {
					// 배열이 비어있지 않으면 절댓값이 가장 작은거 찾아서 출력하고 제거
					sb.append(nums.poll()).append("\n");
				}
			}else {
				nums.add(num);
			}
		}
		
		System.out.println(sb);
		
	}
}
