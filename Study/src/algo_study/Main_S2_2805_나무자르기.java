package algo_study;

import java.io.*;
import java.util.*;

public class Main_S2_2805_나무자르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int maxHeight = 0;
		int[] trees = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			maxHeight = maxHeight > trees[i] ? maxHeight : trees[i];
		}
		
		long end = maxHeight;
		long start = 0;

		long totalLength = 0;
		long maxLength = 0;
		while (start <= end) {
			long mid = (start + end) / 2;

			totalLength = 0;
			for (int i = 0; i < N; i++) {
				if(trees[i] - mid <= 0) continue;
				totalLength += trees[i] - mid;
			}
			
			if (totalLength > M) {
				maxLength = maxLength > mid ? maxLength : mid;
				start = mid + 1;
			} else if (totalLength < M) {
				end = mid - 1;
			} else {
				maxLength = maxLength > mid ? maxLength : mid;
				break;
			}
		}

		System.out.println(maxLength);
	}
}
