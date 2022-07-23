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
		int answer = 0;
		
		for(int i = 0; i < k; i++) {
			lens[i] = Integer.parseInt(br.readLine());
		}

		int maxPow = 30; // 2^30 부터 체크
		maxLen = (int) Math.pow(2, maxPow);
		int cnt = 0;

		for (int i = 0; i < k; i++) {
			cnt += lens[i] / maxLen;
		}
		maxPow--;

		if (cnt >= n) {
			answer = max_plus(lens, maxLen, k, n, maxPow);
		} else {
			answer = max_minus(lens, maxLen, k, n, maxPow);
		}
		
		System.out.println(answer);
	}

	static int max_plus(int[] lens, int maxLen, int k, int n, int maxPow) {
		maxLen += (int) Math.pow(2, maxPow);

		int cnt = 0;
		for (int i = 0; i < k; i++) {
			cnt += lens[i] / maxLen;
		}

		maxPow--;
		if(maxPow == -1 && cnt == n) {
			return maxLen;
		}else {
			if (cnt >= n) {
				if(maxPow == -1) {
					maxPow = 0;
				}
				// 최대 길이로 나눈 개수 총합이 n보다 크거나 같으면 최대 길이가 더 길어질 수 있음!
				return max_plus(lens, maxLen, k, n, maxPow);
			} else {
				if(maxPow == -1) {
					maxPow = 0;
				}
				// n보다 작다면 이 길이보다 짧아야함
				return max_minus(lens, maxLen, k, n, maxPow);
			}
		}
	}

	static int max_minus(int[] lens, int maxLen, int k, int n, int maxPow) {
		maxLen -= (int) Math.pow(2, maxPow);

		int cnt = 0;
		for (int i = 0; i < k; i++) {
			cnt += lens[i] / maxLen;
		}

		maxPow--;
		if(maxPow == -1 && cnt == n) {
			return maxLen;
		}else {
			if (cnt >= n) {
				if(maxPow == -1) {
					maxPow = 0;
				}
				// 최대 길이로 나눈 개수 총합이 n보다 크거나 같으면 최대 길이가 더 길어질 수 있음!
				return max_plus(lens, maxLen, k, n, maxPow);
			} else {
				if(maxPow == -1) {
					maxPow = 0;
				}
				// n보다 작다면 이 길이보다 짧아야함
				return max_minus(lens, maxLen, k, n, maxPow);
			}
		}
	}
}
