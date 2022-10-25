package algo_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S5_1094_막대기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int length = 64;

		int X = Integer.parseInt(br.readLine());

		int count = 0;
		if (X == 64)
			count = 1; // 64cm라면 무조건 1개
		else {
			int sum = 0; // 길이의 합을 누적시킬 변수
			int end = length; // 이분탐색을 위한 최대길이 변수
			while (end > 1) { // 길이가 1보다 큰 동안에는 반으로 자를 수 있음
				int mid = end / 2; // 반으로 자르기

				if (sum + mid == X) { // 이전에 합쳐둔 막대 + 지금 구한 반쪽 막대와 X의 길이가 같으면
					count++; // 필요한 막대 개수 1개 올리고
					break; // 반복문 탈출
				}

				if (sum + mid > X) { // 이전에 합쳐둔 막대 + 지금 구한 반쪽 막대가 X보다 길면
					end = mid; // 하나 버리고 최대 길이 반으로 줄이기
					continue; // 다시 반복
				} else { // 이전에 합쳐둔 막대 + 지금 구한 반쪽 막대가 X보다 짧으면
					sum += mid; // 막대 합치고
					count++; // 필요한 막대 개수 1개 올리고
					end = mid; // 더 사용할 막대의 최대 길이를 반쪽 막대 길이로 줄이기
				}
			}
		}
		sb.append(count).append("\n"); // 테스트 케이스별 출력 스트링 만들기

		System.out.println(sb); // 전체 결과 출력
	}
}
