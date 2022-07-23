package boj_class01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class class01_1330 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		int a = Integer.parseInt(line[0]);
		int b = Integer.parseInt(line[1]);
			
		if(a < b) {
			System.out.println("<");
		}else if(a == b) {
			System.out.println("==");
		}else {
			System.out.println(">");
		}
	}
}
	