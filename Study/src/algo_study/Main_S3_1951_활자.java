package algo_study;

import java.io.*;

public class Main_S3_1951_활자 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String number = br.readLine();
		int N = Integer.parseInt(number);
		int tempN = N;
		
		int[] counter = new int[number.length()];
		int index = 0;
		while(tempN >= 10) {
			counter[index++]++;
			tempN /= 10;
		}
		
		long ans = 0;
		int newIdx = 0;
		while(newIdx < index) {
			ans += 9 * (long)(Math.pow(10, newIdx)) * (newIdx + 1);
			newIdx++;
		}
		
		ans += (N - (long)(Math.pow(10, index)) + 1) * number.length();
		
		System.out.println(ans % 1234567);
	}
}
