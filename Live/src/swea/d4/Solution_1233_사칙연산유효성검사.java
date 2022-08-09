package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");

			int N = Integer.parseInt(br.readLine());

			boolean okFlag = true;
			for(int i = 0; i < N; i++) {
				// 정점 정보 받기
				st = new StringTokenizer(br.readLine(), " ");
				String curIndex = st.nextToken(); // 불필요
				
				if(st.countTokens() == 3) {
					if(!"+-*/".contains(st.nextToken())) {
						okFlag = false;
						for(int j = i + 1; j < N; j++) {
							br.readLine();
						}
						break;
					}
				}else {
					if("+-*/".contains(st.nextToken())) {
						okFlag = false;
						for(int j = i + 1; j < N; j++) {
							br.readLine();
						}
						break;
					}
				}
				
			}
			
			// 내 방법 => 시간 낭비가 심함..
//			// 방문할 노드 하나씩 빼면서 연산 가능한지!!
//			if(N % 2 == 0) okFlag = false;
//			else {
//				for(int i = N; i >= 3; i -= 2) { // 정점 2,3 -> 정점 1 연산까지만 해야하므로
//					if(arr[i-1].matches("-?\\d+") && arr[i].matches("-?\\d+")) {
//						// 둘 다 숫자일 때만 연산이 가능함!
//						if(arr[i/2].equals("+") || arr[i/2].equals("-") || arr[i/2].equals("*") || arr[i/2].equals("/")) arr[i/2] = "1"; // 연산 결과의 정확도가 중요한게 아니므로 값은 무조건 1로 치환
//						else {
//							okFlag = false;
//							break;
//						}
//					}else {
//						okFlag = false;
//						break;
//					}
//				}
//			}
			if(!okFlag) sb.append(0).append("\n");
			else sb.append(1).append("\n");
		}
		
		System.out.println(sb);
	}
}