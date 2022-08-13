package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_11650_좌표정렬하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(!map.containsKey(x)) {
				// key = 해당 인덱스의 결과물이 없을 경우 새로 ArrayList 추가
				ArrayList<Integer> ys = new ArrayList<>();
				ys.add(y);
				map.put(x, ys);
			}else {
				ArrayList<Integer> temp = map.remove(x); // 삭제한 결과물에 현재 값 추가한 다음 다시 put
				temp.add(y);
				map.put(x, temp);
			}
		}
		
		int count = 0;
		for(int i = -100000; i <= 100000; i++) {
			if(count == N)
				break;
			
			if(map.containsKey(i)) {
				ArrayList<Integer> resultsY = map.get(i);
				Collections.sort(resultsY);
				for(int k = 0; k < resultsY.size(); k++) {
					sb.append(i).append(" ").append(resultsY.get(k)).append("\n");
				}
				count++;
			}else {
				continue;
			}
		}
		
		System.out.println(sb);
	}
}
