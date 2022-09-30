package algo_study;

import java.io.*;
import java.util.*;

public class Main_14888_연산자끼워넣기 {
	static char[] selected, opers;
	static int[] arr;
	static int N, minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		opers = new char[N-1];
		selected = new char[N-1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int index = 0;
		for(int i = 0; i < 4; i++) {
			int count = Integer.parseInt(st.nextToken());
			for(int j = 0; j < count; j++) {
				char oper = '+';
				
				switch(i){
					case 0:
						oper = '+';
						break;
					case 1:
						oper = '-';
						break;
					case 2:
						oper = '*';
						break;
					case 3:
						oper = '/';
						break;
				}
				
				opers[index++] = oper;
			}
		}
		
		perm(0, 0);
		System.out.println(maxVal);
		System.out.println(minVal);
	}
	
	static void perm(int count, int flag) {
		if(count == N-1) {
			int value = arr[0];
			for(int i = 0; i < N-1; i++) {
				switch(selected[i]) {
				case '+':
					value += arr[i+1];
					break;
				case '-':
					value -= arr[i+1];
					break;
				case '*':
					value *= arr[i+1];
					break;
				case '/':
					if(value > 0) value /= arr[i+1];
					else {
						value = -value;
						value /= arr[i+1];
						value = -value;
					}
					break;
				}
			}
			
			minVal = minVal < value ? minVal : value;
			maxVal = maxVal > value ? maxVal : value;
			
			return;
		}
		
		for(int i = 0; i < N-1; i++) {
			if((flag & 1 << i) != 0) continue;
			
			selected[count] = opers[i];
			perm(count + 1, flag | 1 << i);
		}
	}
}
