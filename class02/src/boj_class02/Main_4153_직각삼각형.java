package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4153_직각삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String[] line = br.readLine().split(" ");
			if(line[0].equals("0") && line[1].equals("0") && line[2].equals("0")) break;
			
			int a = (int) Math.pow(Integer.parseInt(line[0]), 2);
			int b = (int) Math.pow(Integer.parseInt(line[1]), 2);
			int c = (int) Math.pow(Integer.parseInt(line[2]), 2);
	
			if(a + b == c || b + c == a || c + a == b)
				sb.append("right").append("\n");
			else
				sb.append("wrong").append("\n");
		}
		
		System.out.println(sb);
	}
}
