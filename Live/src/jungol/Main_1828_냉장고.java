package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1828_냉장고 {
	
	static class Chem implements Comparable<Chem>{
		int min, max;

		public Chem(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}

		@Override
		public int compareTo(Chem o) {
			return this.max - o.max;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Chem[] chemList = new Chem[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Chem chem = new Chem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			chemList[i] = chem;
		}
		Arrays.sort(chemList);
		
		int refriCount = 0;
		boolean finFlag = false; // 마지막까지 다 돌았는지?
		boolean[] visited = new boolean[N]; // 이미 방문한 곳인지 체크
		
		int size = chemList.length;
		for(int i = 0; i < size; i++) {
			if(visited[i]) continue; // 이미 체크한 화학물품이면 스킵
			
			// 체크하지 않은 화학물품이라면
			visited[i] = true;
			refriCount++;
			for(int j = i + 1; j < size; j++) {
				if(chemList[j].min > chemList[i].max) {
					// 더이상 i번째 화학물품이랑은 비교할 필요 X이므로
					break;
				}
				
				visited[j] = true;
				if(j == size - 1) {
					// 마지막까지 다 체크한 것이므로
					finFlag = true;
				}
			}
			if(finFlag) break;
		}
		
		System.out.println(refriCount);
		
	}
}
