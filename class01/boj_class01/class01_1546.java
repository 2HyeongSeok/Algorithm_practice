package boj_class01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class class01_1546 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		String[] line = br.readLine().split(" ");
		int[] arr = new int[num];
		double[] arr2 = new double[num];
		
		int max = 0;
		double sum = 0;
		double avg;
		for(int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(line[i]);
			if(max < arr[i]) {
				max = arr[i];
			}
		}		
		
		for(int i = 0; i < num; i++) {
			arr2[i] = (double)arr[i] / max * 100;
			sum += arr2[i];
		}
		avg = sum / num;
		
		System.out.println(avg);
	}
}
