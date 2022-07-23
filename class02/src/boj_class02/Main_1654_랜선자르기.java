package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1654_랜선자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		int k = Integer.parseInt(line[0]);
		int n = Integer.parseInt(line[1]);
		int[] lens = new int[k];

		int maxLen = 0;
		int maxPow = 1;
		int L = 0;

		for (int i = 0; i < k; i++) {
			lens[i] = Integer.parseInt(br.readLine());
			if (L < lens[i]) {
				L = lens[i];
			}
		}

		for (int i = 30; i >= 0; i--) {
			if ((int) (L / Math.pow(2, i)) >= 1) {
				maxPow = i;
				break;
			}
		}
		maxLen = (int) Math.pow(2, maxPow);

		int cnt = 0;
		for (int i = 0; i < k; i++) {
			cnt += lens[i] / maxLen;
		}
		maxPow--;

		boolean isLastFlag = false;

		while (maxPow >= -1) {
			if (cnt >= n) {
				// 개수가 n보다 많으면
				maxLen += (int) Math.pow(2, maxPow);
				isLastFlag = true;
			} else {
				// 개수가 n보다 적으면
				if (isLastFlag == true) {
					maxLen -= (int) Math.pow(2, ++maxPow);
				} else {
					maxLen -= (int) Math.pow(2, maxPow);
				}
			}
			cnt = 0;
			for (int i = 0; i < k; i++) {
				cnt += lens[i] / maxLen;
			}
			maxPow--;
		}

		System.out.println(maxLen);
	}
}