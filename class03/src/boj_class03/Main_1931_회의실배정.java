package boj_class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1931_회의실배정 {
	public static class Use implements Comparable<Use>{
		int start, end;

		public Use(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Use o) {
			// TODO Auto-generated method stub
			if(this.end == o.end) return this.start - o.start;
			return this.end - o.end;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Use[] use = new Use[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Use temp = new Use(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			use[i] = temp;
		}
		Arrays.sort(use);
		
		int count = 0, end_time = 0;
		for(int i = 0; i < N; i++) {
			if(end_time <= use[i].start) {
				// 끝난 시간이 다음 강의실 시작 시간보다 빠르거나 같다면 끝난 시간 갱신
				end_time = use[i].end;
				count++;
			}
		}
		System.out.println(count);
	}
}
