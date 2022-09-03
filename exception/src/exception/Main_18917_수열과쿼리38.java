package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18917_수열과쿼리38 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int M = Integer.parseInt(br.readLine());
		long totalSum = 0;
		long totalXOR = 0;
		int oper, x;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			oper = Integer.parseInt(st.nextToken());

			switch (oper) {
			case 1:
				x = Integer.parseInt(st.nextToken());
				totalSum += x;
				totalXOR ^= x;
				break;
			case 2:
				x = Integer.parseInt(st.nextToken());
				totalSum -= x;
				totalXOR ^= x;
				break;
			case 3:
				sb.append(totalSum).append("\n");
				break;
			case 4:
				sb.append(totalXOR).append("\n");
				break;
			default:
				break;
			}
		}
		
		System.out.println(sb);
	}
}
