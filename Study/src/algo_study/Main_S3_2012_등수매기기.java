package algo_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S3_2012_등수매기기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(numbers);

		long ans = 0;
		for(int i = 1; i <= N; i++) {
			ans += Math.abs(numbers[i-1] - i);
		}
		System.out.println(ans);
	}
}
