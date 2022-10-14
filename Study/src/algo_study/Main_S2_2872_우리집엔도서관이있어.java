package algo_study;

import java.io.*;

public class Main_S2_2872_우리집엔도서관이있어 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] books = new int[N + 1];

		int maxIdx = 0;
		for (int i = 1; i <= N; i++) {
			books[i] = Integer.parseInt(br.readLine());
			if (books[i] == N)
				maxIdx = i;
		}

		int count = 1;
		int value = books[maxIdx];
		for (int i = maxIdx - 1; i > 0; i--) {
			if(value - books[i] == 1) {
				count++;
				value = books[i];
			}
		}

		int ans = N - count;
		System.out.println(ans);
	}
}
