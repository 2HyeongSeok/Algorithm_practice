package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2869_달팽이는올라가고싶다 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int day = (V - A) / (A - B); // (A-B) 미터만큼씩 올라가는데, 마지막 낮에 A미터를 올라가면 목표에 도달할 수 있으므로 (V-A)만큼만
		int height = (A - B) * day; // (A-B) 미터씩 day만큼 높이

		while(height < V) {
			height += A;
			day++;
			if(height < V)
				height -= B;
			else
				break;
		}
		
		System.out.println(day);
	}
}
