package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2805_나무자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		
		long max = 0;
		int[] lens = new int[N];
		line = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			lens[i] = Integer.parseInt(line[i]);
			if( max < lens[i] ) max = lens[i];
		}
		
		long start = 0;
		long end = max;
		// 이분탐색 해야할 듯
		// 나무 최대 높이 10억 -> 2의 31제곱?
		while(start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			
			for(int len : lens) {
				if(len > mid) {
					sum += len - mid;
				}
			}
			
			if(sum >= M) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		
		System.out.println(end);
	}
}
