package boj_class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {
	static int count = 0;
	static int maxRow;
	static int maxCol;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int size = (int)Math.pow(2, N);
		maxRow = size;
		maxCol = size;
		
		search(size, r, c);
		
		System.out.println(count);
	}
	
	static void search(int size, int r, int c) { // 큰 사각형마다 4가지 케이스가 있으므로 재귀
		if(size == 1) {
			return;
		}
		
		size /= 2;
		int tempCount = (int)Math.pow(size, 2);
		maxRow /= 2;
		maxCol /= 2;
		
		if(r < maxRow && c < maxCol) {
			search(size, r, c);
		}else if(r < maxRow && c >= maxCol) {
			c -= size;	
			count += tempCount;
			
			search(size, r, c);
		}else if(r >= maxRow && c < maxCol) {
			r -= size;
			count += tempCount * 2;
			
			search(size, r, c);
		}else {
			// r, c : 재귀에서 부른 다음 사각형에서는 index가 절반으로 줄기 때문에 size만큼 빼줌
			r -= size; 
			c -= size;
			count += tempCount * 3; // 누적해서 더해주는 값
						
			search(size, r, c);
		}
	}
}
