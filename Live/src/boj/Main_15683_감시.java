package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	static char[][] map;
	static int N, M, minCount = Integer.MAX_VALUE;
	static int[] selected;
	static Map<Integer, Integer[]> cctvs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int cctvCounter = 0;
		cctvs = new HashMap<>();
		map = new char[N][M];
		char[][] tempMap = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine().replaceAll(" ", "");
			char[] lines = line.toCharArray();
			for (int j = 0; j < M; j++) {
				// 0 : 빈 칸, 6 : 벽, 1~5 : CCTV 종류
				map[i][j] = lines[j];
				tempMap[i][j] = lines[j];
				if (map[i][j] - '0' >= 1 && map[i][j] - '0' <= 5) {
					cctvCounter++;
					cctvs.put(cctvCounter, new Integer[] { i, j });
				}
			}
		}

		selected = new int[cctvCounter];
		
		comb(tempMap, 0, cctvCounter);

		System.out.println(minCount); // 결과

	}

	static void comb(char[][] tempMap, int cnt, int cctvCounter) {
		if (cnt == cctvCounter) {
			// 여기서 이제 조합별로 사각지대 개수 검사해야함
			
			// 맵 초기화
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					map[i][j] = tempMap[i][j];
				}
			}
			
			int zeroCount = 0;
			
			for(int i = 1; i <= cctvs.size(); i++) {
				Integer[] arr = cctvs.get(i);
				switch(map[arr[0]][arr[1]]) {
				case '1':
					cctv1(arr[0], arr[1], selected[i - 1]);
					break;
				case '2':
					cctv2(arr[0], arr[1], selected[i - 1]);
					break;
				case '3':
					cctv3(arr[0], arr[1], selected[i - 1]);
					break;
				case '4':
					cctv4(arr[0], arr[1], selected[i - 1]);
					break;
				case '5': // 얘는 선택과 상관없이 모두 칠하므로
					cctv5(arr[0], arr[1]);
					break;
				default:
					break;
				}
			}
			
			for (int i = 0; i < N; i++) { // 감시 가능한 곳 cover 카운팅
				for (int j = 0; j < M; j++) {
					if (map[i][j] == '0')
						zeroCount++;
				}
			}
			minCount = minCount < zeroCount ? minCount : zeroCount;
			
			return;
		}

		for (int i = 1; i <= 4; i++) {
			selected[cnt] = i;
			comb(tempMap, cnt + 1, cctvCounter);
		}
	}

	// 감시를 최대한 할 수 있는 방향을 골랐을 때, 빈 칸인 0을 #으로 대체하기 위한 메소드
	static void drawDirection(int i, int j, ArrayList<Integer> list) {
		for (int l = 0; l < list.size(); l++) {
			switch (list.get(l)) {
			case 1: // 상
				for (int k = i - 1; k >= 0; k--) {
					if (map[k][j] == '6')
						break;
					if (map[k][j] == '0')
						map[k][j] = '#';
				}
				break;
			case 2: // 우
				if (j < M - 1) {
					for (int k = j + 1; k < M; k++) {
						if (map[i][k] == '6')
							break;
						if (map[i][k] == '0')
							map[i][k] = '#';
					}
				}
				break;
			case 3: // 하
				if (i < N - 1) {
					for (int k = i + 1; k < N; k++) {
						if (map[k][j] == '6')
							break;
						if (map[k][j] == '0')
							map[k][j] = '#';
					}
				}
				break;
			case 4: // 좌
				if (j > 0) {
					for (int k = j - 1; k >= 0; k--) {
						if (map[i][k] == '6')
							break;
						if (map[i][k] == '0')
							map[i][k] = '#';
					}
				}
				break;
			}
		}
	}
	
	// 1 : 위쪽 2 : 오른쪽 3 : 아래쪽 4 : 왼쪽
	static void cctv1(int i, int j, int mode) { // 한 방향(1,2,3,4 중)
		ArrayList<Integer> list = new ArrayList<>();

		list.add(mode); // 최대로 감시할 수 있는 방향 저장
		drawDirection(i, j, list);
	}

	static void cctv2(int i, int j, int mode) { // 대칭 방향(2방향)
		ArrayList<Integer> list = new ArrayList<>();
		
		if(mode == 1) { // 상하
			list.add(1);
			list.add(3);
		}else if(mode == 2) { // 좌우
			list.add(2);
			list.add(4);
		}else {
			// mode 3은 1과 동일하므로 굳이 할 필요 없고
			// mode 4도 2와 동일하므로 굳이 할 필요 없음
			return; 
		}

		drawDirection(i, j, list);
	}

	static void cctv3(int i, int j, int mode) { // ㄱ자 or ㄴ자 방향(2방향)
		ArrayList<Integer> list = new ArrayList<>();

		// 최대로 감시할 수 있는 방향 저장
		switch(mode) {
		case 1: // 우 상
			list.add(1);
			list.add(2);
			break;
		case 2: // 우 하
			list.add(2);
			list.add(3);
			break;
		case 3: // 좌 하
			list.add(3);
			list.add(4);
			break;
		case 4: // 좌 상
			list.add(4);
			list.add(1);
			break;
		}
		
		drawDirection(i, j, list);
	}

	static void cctv4(int i, int j, int mode) { // ㅗ방향(3방향)
		ArrayList<Integer> list = new ArrayList<>();

		switch(mode) {
		case 1: // 상 우 하
			list.add(1);
			list.add(2);
			list.add(3);
			break;
		case 2: // 우 하 좌
			list.add(2);
			list.add(3);
			list.add(4);
			break;
		case 3: // 하 좌 상
			list.add(3);
			list.add(4);
			list.add(1);
			break;
		case 4: // 좌 상 우
			list.add(4);
			list.add(1);
			list.add(2);
			break;
		}
		
		drawDirection(i, j, list);
	}

	static void cctv5(int i, int j) { // 모든 방향(4방향)
		ArrayList<Integer> list = new ArrayList<>();

		for (int k = 1; k <= 4; k++) {
			list.add(k);
		}
		drawDirection(i, j, list);
	}
}
