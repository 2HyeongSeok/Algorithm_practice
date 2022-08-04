package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2477_참외밭 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] dirCnt = new int[5];
		int[] dir = new int[6];
		int[] dis = new int[6];
		int K = Integer.parseInt(br.readLine());
		int index = 0;
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			dir[i] = Integer.parseInt(st.nextToken());
			dis[i] = Integer.parseInt(st.nextToken());

			if (++dirCnt[dir[i]] == 2 && index == 0) {
				// 방향 카운팅 == 2면
				index = i;
			}
		}
		
		int mapSize = 0;

		// index는 2~4의 경우를 가짐!
		if(dir[index] == dir[index - 2]) {
			// 임의의 꼭짓점의 시작부분에 같은 방향의 값이 들어옴!
			// index의 다음 값, index - 2의 이전 값 이용
			if (index - 2 == 0) {
				// 배열의 5번째 인덱스는 마지막 값, index - 2 == 0인 경우임!
				mapSize = dis[index - 2] * dis[5] + dis[index] * dis[index + 1];
			} else {
				// index-2, index는 같은 방향
				mapSize = dis[index - 2] * dis[index - 3] + dis[index] * dis[index + 1];
			}
		}else if(dir[index] == dir[index - 4]) {
			// 임의의 꼭짓점의 시작과 끝쪽에 같은 방향의 값이 나뉘어 있을 때!
			// index의 이전 값, index-4의 다음 값 이용
			mapSize = dis[index - 4] * dis[index - 3] + dis[index] * dis[index - 1];
		}
		
		int totalK = mapSize * K;
		System.out.println(totalK);
	}
}
