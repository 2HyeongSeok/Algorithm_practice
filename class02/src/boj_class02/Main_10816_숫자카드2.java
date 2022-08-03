package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10816_숫자카드2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[20000001];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[Integer.parseInt(st.nextToken()) + 10000000]++; // + 천만
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			// 이분탐색
			int start = -10000000;
			int end = 10000000;
			int mid = 0;
			while(start <= end) {
				mid = (start + end) / 2;
				if(mid == num) {
					break;
				}else if(num > mid) {
					start = mid + 1;
				}else {
					end = mid - 1;
				}
			}
			sb.append(nums[mid + 10000000]).append(" ");
		}
		System.out.println(sb);
		
	}
}
