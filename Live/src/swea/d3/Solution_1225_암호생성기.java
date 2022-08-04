package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		for(int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine()); // 테케번호
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken())); // 큐에 저장
			}

			int index = 1;
			while(true) {
				int b = queue.poll() - index; // 큐의 첫번째 값 - index (1~5)
				if(b <= 0) {
					queue.offer(0); // 0보다 작아지면 0을 맨 뒤에 넣고 종료
					break;
				}
				
				if(index == 5) index = 1; // 사이클 끝나면 다시 index = 1
				else index++;
				
				queue.offer(b);
			}
			
			for(int i = 0; i < 8; i++) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
