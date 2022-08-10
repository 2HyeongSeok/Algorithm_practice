package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14696_딱지놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < N; t++) {
			int[] aCounter = new int[5]; // 4:별 3:동그라미 2:네모 1:세모
			int[] bCounter = new int[5];
			
			st = new StringTokenizer(br.readLine(), " "); // A가 내는 딱지에 나온 그림의 총 개수와 (1~4)
			int aCards = Integer.parseInt(st.nextToken());
			for(int i = 0; i < aCards; i++) {
				int cardNum = Integer.parseInt(st.nextToken());
				aCounter[cardNum]++;
			}
			
			st = new StringTokenizer(br.readLine(), " "); // B가 내는 딱지에 나온 그림의 총 개수와 (1~4)
			int bCards = Integer.parseInt(st.nextToken());
			for(int i = 0; i < bCards; i++) {
				int cardNum = Integer.parseInt(st.nextToken());
				bCounter[cardNum]++;
			}
			
			for(int i = 4; i >= 1; i--) {
				if(aCounter[i] == bCounter[i]) {
					if(i == 1) sb.append("D").append("\n");	
					continue;
				}else if(aCounter[i] > bCounter[i]) {
					sb.append("A").append("\n");
					break;
				}else {
					sb.append("B").append("\n");
					break;
				}
			}
		}
		
		System.out.println(sb);
	}
}
