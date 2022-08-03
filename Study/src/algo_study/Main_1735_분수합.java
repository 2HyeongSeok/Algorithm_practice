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
		
		int bTemp = b; // b 값이 바뀌기 때문에 미리 저장!
		a *= d;
		b *= d;
		c *= bTemp;
		d *= bTemp;
		
		int child = a + c;
		int parent = b;
		
		// gcd
		int gcdVal = gcd(child, parent);
		System.out.println(child / gcdVal + " " + parent / gcdVal);
	}
	
	static int gcd(int a, int b) {
		if(a % b == 0)
			return b;
		return gcd(b, a % b);
	}
}
