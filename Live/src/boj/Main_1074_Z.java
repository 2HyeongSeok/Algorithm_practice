package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int size = (int)Math.pow(2, N);
		int max = size * size;
		find(max, size, r, c);
		
		System.out.println(ans);
	}
	
	static void find(int max, int size, int r, int c) {
		if(size == 1) return;
	
		size /= 2;
		max /= 4;
		if(r < size && c < size) {
			find(max, size, r, c);
		}else if(r < size && c >= size) {
			ans += max;
			find(max, size, r, c - size);
		}else if(r >= size && c < size) {
			ans += max * 2;
			find(max, size, r - size, c);
		}else {
			ans += max * 3;
			find(max, size, r - size, c - size);
		}
	}
}
