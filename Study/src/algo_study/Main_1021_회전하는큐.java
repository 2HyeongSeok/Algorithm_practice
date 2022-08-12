package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1021_회전하는큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		ArrayList<Integer> queue = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++)
			queue.add(i);
		
		st = new StringTokenizer(br.readLine(), " ");
		int count = 0;
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int top = queue.get(0);

			int index = queue.indexOf(num);
			if((num < top && index <= queue.size() / 2) || (num > top && index <= queue.size() / 2)) {
				// 왼쪽으로 이동
				
				while(true) {
					queue.add(queue.remove(0));
					count++;
					if(queue.get(0) == num) {
						queue.remove(0);
						break;
					}
				}
			}else if((num > top && index > queue.size() / 2) || (num < top && index > queue.size() / 2)) {
				// 오른쪽으로 이동
				while(true) {
					queue.add(0, queue.remove(queue.size() - 1));
					count++;
					if(queue.get(0) == num) {
						queue.remove(0);
						break;
					}
				}
			}else {
				// 같으면 빼면된다!
				queue.remove(0);
			}
		}
		
		System.out.println(count);
	}
}
