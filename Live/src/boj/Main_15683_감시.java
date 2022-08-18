package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	static char[][] map;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int zeroCount = 0;
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String line = br.readLine().replaceAll(" ", "");
			char[] lines = line.toCharArray();
			for(int j = 0; j < M; j++) {
				// 0 : 빈 칸, 6 : 벽, 1~5 : CCTV 종류
				map[i][j] = lines[j];
			}
		}
//		System.out.println(zeroCount);
		
		for(int k = 5; k >= 1; k--) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == (char)(k + '0')) {
						switch(map[i][j]) {
						case '1':
							cctv1(i, j); 
							break;
						case '2':
							cctv2(i, j); 
							break;
						case '3':
							cctv3(i, j); 
							break;
						case '4':
							cctv4(i, j); 
							break;
						case '5':
							cctv5(i, j); 
							break;
						default:
							break;
						}
						for(int m = 0; m < N; m++) {
							System.out.println(Arrays.toString(map[m]));
						}
						System.out.println();
					}
				}
			}
		}
		
		
		for(int i = 0; i < N; i++) { // 감시 가능한 곳 cover 카운팅
			for(int j = 0; j < M; j++) {
				if(map[i][j] == '0') zeroCount++;
			}
		}
		
		System.out.println(zeroCount); // 결과
		
	}

	// 감시를 최대한 할 수 있는 방향을 골랐을 때, 빈 칸인 0을 #으로 대체하기 위한 메소드
	static void drawDirection(int i, int j, ArrayList<Integer> list) { 
		for(int l = 0; l < list.size(); l++) {
			switch(list.get(l)) {
			case 0: // 상
				for(int k = i - 1; k >= 0; k--) {
					if(map[k][j] == '6') break;
					if(map[k][j] == '0') map[k][j] = '#';
				}
				break;
			case 1: // 하
				if(i < N-1) {
					for(int k = i + 1; k < N; k++) {
						if(map[k][j] == '6') break;
						if(map[k][j] == '0') map[k][j] = '#';
					}
				}
				break;
			case 2: // 좌
				if(j > 0) {
					for(int k = j - 1; k >= 0; k--) {
						if(map[i][k] == '6') break;
						if(map[i][k] == '0') map[i][k] = '#';
					}
				}
				break;
			case 3: // 우
				if(j < M-1) {
					for(int k = j + 1; k < M; k++) {
						if(map[i][k] == '6') break;
						if(map[i][k] == '0') map[i][k] = '#';
					}
				}
				break;
			}
		}
	}

	// 어느 방향으로 감시를 해야 최대한 사각지대를 줄일 수 있는지 count를 세서 비교하기 위함
	static int[] checkDirection(int i, int j) {
		int[] counts = new int[4];
		int upCount = 0, downCount = 0, leftCount = 0, rightCount = 0;
		
		if(i > 0) { // 상
			for(int k = i - 1; k >= 0; k--) {
				if(map[k][j] == '6') break;
				if(map[k][j] == '0') upCount++;
			}
			counts[0] = upCount;
		}
		if(i < N-1) { // 하
			for(int k = i + 1; k < N; k++) {
				if(map[k][j] == '6') break;
				if(map[k][j] == '0') downCount++;
			}
			counts[1] = downCount;
		}
		if(j > 0) { // 좌
			for(int k = j - 1; k >= 0; k--) {
				if(map[i][k] == '6') break;
				if(map[i][k] == '0') leftCount++;
			}
			counts[2] = leftCount;
		}
		if(j < M-1) { // 우
			for(int k = j + 1; k < M; k++) {
				if(map[i][k] == '6') break;
				if(map[i][k] == '0') rightCount++;
			}
			counts[3] = rightCount;
		}
		
		return counts;
	}
	
	static void cctv1(int i, int j) { // 한 방향
		int result = 0, index = 0;
		ArrayList<Integer> list = new ArrayList<>();
		int[] UDLRCount = checkDirection(i, j);
		
		for(int k = 0; k < 4; k++) {
			if(result < UDLRCount[k]) {
				result = UDLRCount[k];
				index = k;
			}
		}
//		System.out.println(index);
		list.add(index); // 최대로 감시할 수 있는 방향 저장
		drawDirection(i, j, list);
	}
	
	static void cctv2(int i, int j) { // 대칭 방향(2방향)
		ArrayList<Integer> list = new ArrayList<>();
		int[] UDLRCount = checkDirection(i, j);
		
		int udCount = UDLRCount[0] + UDLRCount[1];
		int lrCount = UDLRCount[2] + UDLRCount[3];
		
//		System.out.println("udCount : " + udCount + ", lrCount : " + lrCount );
		if(udCount > lrCount) { // 최대로 감시할 수 있는 방향 저장
			list.add(0);
			list.add(1);
		}else {
			list.add(2);
			list.add(3);
		}
		drawDirection(i, j, list);
	}
	
	static void cctv3(int i, int j) { // ㄱ자 or ㄴ자 방향(2방향)
		int result = 0;
		int[] temp = new int[2];
		ArrayList<Integer> list = new ArrayList<>();
		
		int[] UDLRCount = checkDirection(i, j);
		
		 // 최대로 감시할 수 있는 방향 저장
		int urCount = UDLRCount[0] + UDLRCount[3];
		if(urCount > result) {
			result = urCount;
			temp[0] = 0;
			temp[1] = 3;
		}
		int rdCount = UDLRCount[1] + UDLRCount[3];
		if(rdCount > result) {
			result = rdCount;
			temp[0] = 1;
			temp[1] = 3;
		}
		int dlCount = UDLRCount[1] + UDLRCount[2];
		if(dlCount > result) {
			result = dlCount;
			temp[0] = 1;
			temp[1] = 2;
		}
		int luCount = UDLRCount[0] + UDLRCount[2];
		if(luCount > result) {
			result = luCount;
			temp[0] = 0;
			temp[1] = 2;
		}
		list.add(temp[0]);
		list.add(temp[1]);
		drawDirection(i, j, list);
	}
	
	static void cctv4(int i, int j) { // ㅗ방향(3방향)
		int result = 0, index = 0;
		ArrayList<Integer> list = new ArrayList<>();
		
		int[] UDLRCount = checkDirection(i, j);
		int totalCount = 0;
		
		for(int k = 0; k < 4; k++)
			totalCount += UDLRCount[k];
				
		for(int k = 0; k < 4; k++) {
			if(result < totalCount - UDLRCount[k]) { // 선택되지 않은 방향 저장했다가
				result = totalCount - UDLRCount[k];
				index = k;
			}
		}
		
		for(int k = 0; k < 4; k++) { // 그 방향 빼고 더해준 뒤 색칠하러 감
			if(index != k) {
				list.add(k);
			}
		}
		drawDirection(i, j, list);
	}
	
	static void cctv5(int i, int j) { // 모든 방향(4방향)
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int k = 0; k < 4; k++) {
			list.add(k);
		}
		drawDirection(i, j, list);
	}
}
