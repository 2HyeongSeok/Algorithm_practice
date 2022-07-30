package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2798_블랙잭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		
		int[] arr = new int[N];
		line = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(line[i]);
		}
		
		int max = 0;
		int sum = 0;
		for(int i = 0; i < N - 2; i++) {
			for(int j = i + 1; j < N - 1; j++) {
				for(int k = j + 1; k < N; k++) {
					sum = arr[i] + arr[j] + arr[k];
					
					if(sum > max && sum <= M)
						max = sum;
				}
			}
		}
		
		System.out.println(max);
	}
}
