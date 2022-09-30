package algo_study;

import java.io.*;
import java.util.*;

public class Main_14888_연산자끼워넣기 {
	static char[] selected;
	static int[] arr, opers;
	static int N, minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		opers = new int[4];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++) {
			opers[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1, arr[0]);
		System.out.println(maxVal);
		System.out.println(minVal);
	}
	
	static void dfs(int count, int value) {
		if(count == N) {
			minVal = minVal < value ? minVal : value;
			maxVal = maxVal > value ? maxVal : value;
			return;
		}
		
		for(int k = 0; k < 4; k++) {
			if(opers[k] > 0) {
				opers[k]--;
				
				switch(k) {
				case 0:
					dfs(count + 1, value + arr[count]);
					break;
				case 1:
					dfs(count + 1, value - arr[count]);
					break;
				case 2:
					dfs(count + 1, value * arr[count]);
					break;
				case 3:
					dfs(count + 1, (-1) * ((-value) / arr[count]));
					break;
				}
				
				opers[k]++;
			}
			
		}
	}
}
