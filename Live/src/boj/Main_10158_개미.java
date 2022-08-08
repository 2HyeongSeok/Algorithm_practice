package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10158_개미 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		
		int tempW = t;
		int tempH = t;
		
		//// 가로
		if(tempW > 2 * w) {
			tempW %= 2 * w; // 반복 케이스 제거
		}
		
		if(tempW <= w - p) {
			p += tempW;
		}else if(tempW <= 2 * w - p) {
			p = w - (tempW - (w - p));
		}else {
			p = tempW - w - (w - p);
		}
		
		//// 세로
		if(t > 2 * h) {
			tempH %= 2 * h; // 반복 케이스 제거
		}
		if(tempH <= h - q) {
			q += tempH;
		}else if(tempH <= 2 * h - q) {
			q = h - (tempH - (h - q));
		}else {
			q = tempH - h - (h - q);
		}
		
		sb.append(p).append(" ").append(q);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
