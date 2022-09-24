package boj_class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_7662_이중우선순위큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			TreeMap<Integer, Integer> queue = new TreeMap<>();

			int k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String oper = st.nextToken();
				int value = Integer.parseInt(st.nextToken());

				if (oper.equals("I")) {
					queue.put(value, queue.getOrDefault(value, 0) + 1); // 해당 숫자 개수 누적해서 map에 가지고 있기
				} else { // "D"
					if(!queue.isEmpty()) {
						if (value == 1) {
							// 최대값
							int maxVal = queue.lastKey();
							if(queue.put(maxVal,  queue.get(maxVal) - 1) == 1) { // 빼기 전 값이 1이라면 삭제
								queue.remove(maxVal);
							}
						} else {
							// 최소값
							int minVal = queue.firstKey();
							if(queue.put(minVal,  queue.get(minVal) - 1) == 1) { // 빼기 전 값이 1이라면 삭제
								queue.remove(minVal);
							}
						}
					}					
				}
			}

			if(queue.isEmpty()) sb.append("EMPTY\n");
			else sb.append(queue.lastKey()).append(" ").append(queue.firstKey()).append("\n");
		}

		System.out.println(sb);
	}
}
