package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			List<Integer> grams = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				grams.add(Integer.parseInt(st.nextToken()));
			}
			
			// 무게 내림차순 정렬
			Collections.sort(grams, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return -1 * (o1 - o2);
				}
				
			});
			
			int tempMax = 0;
			for(int i = 0; i < N - 1; i++) {
				for(int j = i + 1; j < N; j++) {
					if(grams.get(i) + grams.get(j) <= M) {
						tempMax = Math.max(tempMax, grams.get(i)+grams.get(j));
						break;
					}
				}
			}
			
			if(tempMax == 0) sb.append("-1").append("\n");
			else sb.append(tempMax).append("\n");
		}
		System.out.println(sb);
	}
}
