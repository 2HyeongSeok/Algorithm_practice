package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1735_분수합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		int a = Integer.parseInt(line[0]);
		int b = Integer.parseInt(line[1]);
		
		String[] line2 = br.readLine().split(" ");
		int c = Integer.parseInt(line2[0]);
		int d = Integer.parseInt(line2[1]);
		
		// a, b 약분, c, d 약분
		int min = Math.min(a, b);
		for(int i = min; i >= 1; i--) {
			if(a % i == 0 && b % i == 0) {
				a /= i;
				b /= i;
				break;
			}
		}
		min = Math.min(c, d);
		for(int i = min; i >= 1; i--) {
			if(c % i == 0 && d % i == 0) {
				c /= i;
				d /= i;
				break;
			}
		}
		
		int temp = b; // b 값이 바뀌기 때문에 미리 저장!
		a *= d;
		b *= d;
		c *= b;
		d *= b;
		
		
	}
}
