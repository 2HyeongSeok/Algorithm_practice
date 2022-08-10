package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
	// 순열과 관련된 전역변수
	static Integer[] numbers;
	static List<Integer[]> permNumbers = new ArrayList<>();
	static boolean[] isSelected = new boolean[6];

	// 맵 정보와 관련된 전역변수
	static int[][] map;
	
	// rotate 정보와 관련된 전역변수
	static Map<Integer, Integer[]> tempMaps = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		numbers = new Integer[K];
		
		map = new int[N + 1][M + 1];
		int[][] baseMap = new int[N + 1][M + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= M; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				baseMap[i][j] = value;
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Integer[] temp = new Integer[3];
			temp[0] = Integer.parseInt(st.nextToken());
			temp[1] = Integer.parseInt(st.nextToken());
			temp[2] = Integer.parseInt(st.nextToken());
			
			tempMaps.put(i, temp); // 맵에 저장			
		}
		
		perm(0, K); // 순열 돌리고
		
		for(int i = 0; i < permNumbers.size(); i++) { // 저장된 순열 하나씩 확인
			for(int p = 1; p <= N; p++) {
				for(int q = 1; q <= M; q++) {
					map[p][q] = baseMap[p][q];
				}
			}
			
			for(int k = 0; k < K; k++) {
				Integer[] tempRotate = tempMaps.get(permNumbers.get(i)[k]);
				rotate(tempRotate[0], tempRotate[1], tempRotate[2]);
			}

			// 최소값 계산
			for(int m = 1; m <= N; m++) {
				int sum = 0;
				for(int n = 1; n <= M; n++) {
					sum += map[m][n];
				}
				min = min > sum ? sum : min;
			}
		}
		
		System.out.println(min);
	}
	
	static void rotate(int row, int col, int size) {
		if(size == 0) { // 기저조건
			return;
		}
		
		int rowStartIndex = row - size;
		int rowEndIndex = row + size;
		int colStartIndex = col - size;
		int colEndIndex = col + size;

		// 시계방향으로 회전
		// (0, 0) 값 저장 후 왼쪽 열부터
		int temp = map[rowStartIndex][colStartIndex];
		for(int i = rowStartIndex; i < rowEndIndex; i++) // 왼쪽
			map[i][colStartIndex] = map[i + 1][colStartIndex];
		for(int i = colStartIndex; i < colEndIndex; i++) // 아래쪽
			map[rowEndIndex][i] = map[rowEndIndex][i + 1];
		for(int i = rowEndIndex; i > rowStartIndex; i--) // 오른쪽
			map[i][colEndIndex] = map[i - 1][colEndIndex];
		for(int i = colEndIndex; i > colStartIndex + 1; i--) // 아래쪽
			map[rowStartIndex][i] = map[rowStartIndex][i - 1];
		map[rowStartIndex][colStartIndex + 1] = temp;
		
		rotate(row, col, size - 1);
	}
	
	static void perm(int cnt, int K) { // K개로 만들 수 있는 순열!!
		if(cnt == K) {
			Integer[] tempNumbers = new Integer[K];
			for(int i = 0; i < K; i++) {
				tempNumbers[i] = numbers[i];
			}
			permNumbers.add(tempNumbers); // 가능한 경우들을 ArrayList에 저장
			return;
		}
		
		for(int i = 0; i < K; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			numbers[cnt] = i;
			
			perm(cnt + 1, K);
			
			isSelected[i] = false;
		}
	}
}
