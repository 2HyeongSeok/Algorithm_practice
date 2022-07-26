package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1966_프린터큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Queue<Integer> queue;
		
		for(int i = 0; i < num; i++) {
			queue = new LinkedList<>();
			String[] line = br.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int M = Integer.parseInt(line[1]);
			
			int[] maxArr = new int[N];
			String[] importances = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				int temp = Integer.parseInt(importances[j]);
				queue.offer(temp);
				maxArr[j] = temp;
			}
			Integer[] integerArray = Arrays.stream(maxArr).boxed().toArray(Integer[]::new);
			Arrays.sort(integerArray, Collections.reverseOrder()); // sorting
			
			int index = 0;
			while(index < N) {
				if(integerArray[index] == queue.peek()) {
					// 가장 우선순위가 높으면 빼기
					// 단 M과 일치하면 해당 index 출력하고 종료
					if(M == 0) {
						System.out.println(index + 1);
						break;
					}
					index++;
					queue.remove();
				}else {
					// 우선순위가 가장 높은게 아니면 다시 뒤로 추가
					if(M == 0) {
						M = queue.size();
					}
					queue.offer(queue.poll());
				}
				M--;
			}
		}
	}
}
