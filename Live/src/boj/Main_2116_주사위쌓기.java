package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2116_주사위쌓기 {
	static int[][] topIdxArr;
	static int[][] bottomIdxArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		topIdxArr = new int[6][N];
		bottomIdxArr = new int[6][N];
		int[][] dice = new int[N][6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 인덱스 : 0-5 마주보고, 1-3 마주보고, 2-4 마주봄
			dice[i][0] = Integer.parseInt(st.nextToken());
			dice[i][1] = Integer.parseInt(st.nextToken());
			dice[i][2] = Integer.parseInt(st.nextToken());
			dice[i][3] = Integer.parseInt(st.nextToken());
			dice[i][4] = Integer.parseInt(st.nextToken());
			dice[i][5] = Integer.parseInt(st.nextToken());
		}

		for (int topIdx = 0; topIdx < 6; topIdx++) {
			topIdxArr[topIdx][0] = topIdx;
			switch (topIdx) {
			case 0: // 0번째 인덱스가 첫번째 주사위의 윗면이라면
				bottomIdxArr[topIdx][0] = 5;
				check(dice, dice[0][topIdx], 1, topIdx); // 다음 주사위의 아랫면 값으로 재귀 호출
				break;
			case 1: // 1번째
				bottomIdxArr[topIdx][0] = 3;
				check(dice, dice[0][topIdx], 1, topIdx);
				break;
			case 2: // 2번째
				bottomIdxArr[topIdx][0] = 4;
				check(dice, dice[0][topIdx], 1, topIdx);
				break;
			case 3: // 3번째
				bottomIdxArr[topIdx][0] = 1;
				check(dice, dice[0][topIdx], 1, topIdx);
				break;
			case 4: // 4번째
				bottomIdxArr[topIdx][0] = 2;
				check(dice, dice[0][topIdx], 1, topIdx);
				break;
			case 5: // 5번째
				bottomIdxArr[topIdx][0] = 0;
				check(dice, dice[0][topIdx], 1, topIdx);
				break;
			default:
				break;
			}
		}
		
		// topIdxArr, bottomIdxArr 배열에 모든 탑 경우의 수 적혀있음
		int maxSum = 0;
		for(int i = 0; i < 6; i++) {
			int sum = 0;
			for(int j = 0; j < N; j++) {
				for(int k = 6; k > 0; k--) {
					if(dice[j][topIdxArr[i][j]] != k && dice[j][bottomIdxArr[i][j]] != k) {
						sum += k; // 최대값 k를 찾아서 더함
						break;
					}
				}
			}
			maxSum = maxSum > sum ? maxSum : sum;
		}

		System.out.println(maxSum);
	}

	static void check(int[][] dice, int bottom, int cnt, int curTopIdx) { // 받아올 땐 다음 주사위이므로 아랫면
		if(cnt == dice.length) {
			// 모든 주사위 찾아봄! 기저조건!!
			return;
		}
		
		int index = 0;
		for (int i = 0; i < 6; i++) {
			if (bottom == dice[cnt][i]) {
				index = i; // 아랫면 인덱스 찾고
				break;
			}
		}
		
		bottomIdxArr[curTopIdx][cnt] = index;
		int topIdx = 0;
		switch (index) {
		case 0: // 0번째 인덱스가 cnt번째 주사위의 아랫면이라면
			topIdx = 5;
			topIdxArr[curTopIdx][cnt] = topIdx;
			check(dice, dice[cnt][topIdx], cnt + 1, curTopIdx); // (cnt + 1)번째 주사위의 아랫면 값으로 재귀 호출
			break;
		case 1: // 1번째
			topIdx = 3;
			topIdxArr[curTopIdx][cnt] = topIdx;
			check(dice, dice[cnt][topIdx], cnt + 1, curTopIdx);
			break;
		case 2: // 2번째
			topIdx = 4;
			topIdxArr[curTopIdx][cnt] = topIdx;
			check(dice, dice[cnt][topIdx], cnt + 1, curTopIdx);
			break;
		case 3: // 3번째
			topIdx = 1;
			topIdxArr[curTopIdx][cnt] = topIdx;
			check(dice, dice[cnt][topIdx], cnt + 1, curTopIdx);
			break;
		case 4: // 4번째
			topIdx = 2;
			topIdxArr[curTopIdx][cnt] = topIdx;
			check(dice, dice[cnt][topIdx], cnt + 1, curTopIdx);
			break;
		case 5: // 5번째
			topIdx = 0;
			topIdxArr[curTopIdx][cnt] = topIdx;
			check(dice, dice[cnt][topIdx], cnt + 1, curTopIdx);
			break;
		default:
			break;
		}

	}
}
