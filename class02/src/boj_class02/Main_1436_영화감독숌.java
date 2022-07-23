package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1436_영화감독숌 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		int start_index = 0;
		int start_num = 665;
		
		while(start_index < num) {
			start_num++;
			if(Integer.toString(start_num).contains("666")) {
				start_index++;
				}
		}
		
		System.out.println(start_num);
	}
}