package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2527_직사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[] firstX = new int[2];
		int[] firstY = new int[2];
		int[] secondX = new int[2];
		int[] secondY = new int[2];
		for(int t = 1; t <= 4; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			firstX[0] = Integer.parseInt(st.nextToken());
			firstY[0] = Integer.parseInt(st.nextToken());
			firstX[1] = Integer.parseInt(st.nextToken());
			firstY[1] = Integer.parseInt(st.nextToken());
			secondX[0] = Integer.parseInt(st.nextToken());
			secondY[0] = Integer.parseInt(st.nextToken());
			secondX[1] = Integer.parseInt(st.nextToken());
			secondY[1] = Integer.parseInt(st.nextToken());
			
			if(firstX[0] > secondX[1] || secondX[0] > firstX[1] || firstY[0] > secondY[1] || secondY[0] > firstY[1]) {
				// 겹치지 않는 경우
				sb.append("d").append("\n");
			}else if((firstX[0] == secondX[1] && firstY[0] == secondY[1]) 
					|| (firstX[1] == secondX[0] && firstY[0] == secondY[1]) 
					|| (firstX[0] == secondX[1] && firstY[1] == secondY[0]) 
					|| (firstX[1] == secondX[0] && firstY[1] == secondY[0])) {
				// 한 점에서 만남
				sb.append("c").append("\n");
			}else if(firstX[0] == secondX[1] || firstX[1] == secondX[0] || firstY[0] == secondY[1] || firstY[1] == secondY[0]) {
				// 이미 앞에서 겹치는 경우와 한 점에서 만나는 경우를 배제했으므로
				// 서로의 반대편 x좌표끼리, y좌표끼리 같은지를 판단하면 된다!
				
				// 선분
				sb.append("b").append("\n");
			}else {
				// 직사각형
				sb.append("a").append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
