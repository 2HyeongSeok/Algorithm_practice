package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	
	static int R, C;
	static char[][] map;
	static boolean breakFlag;
	static int count = 0;
	static ArrayList<Integer[]> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i = 0; i < R; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j = 0; j < C; j++) {
				map[i][j] = line[j];
			}
		}
		
		for(int i = 0; i < R; i++) {
			// 파이프라인에서 출발
			breakFlag = false; // 끝까지 도달했으면 그 케이스를 저장하고 브레이크 하기 위한 플래그
			list = new ArrayList<>();
			
			if(map[i][0] == '.') {
				// 파이프라인 시작 가능한 곳
				// 재귀로 돌려! 인자 값으로 i, 다음 col값!
				
				recur(i, 1);
			}
			
			
		}
		
		System.out.println(count);
	}
	
	static void recur(int i, int col) {
		if(col == C - 1) { // 기저조건
			// 마지막 열까지 온 것이므로
			breakFlag = true;
			count++;
			
			return; 
		}
		
		for(int j = i - 1; j <= i + 1; j++) {
			// 파이프라인이 이동 가능한 오른쪽 위, 오른쪽, 오른쪽 아래 검사
			if(j < 0 || j >= R) continue; // 맵 밖으로 벗어날 순 없음
			
			if(map[j][col] == '.') {
				// 일단 다음으로 이동 가능하면 list에 추가
				map[j][col] = 'O'; // 바로 칠해버려
				
				recur(j, col+1);
				if(breakFlag) break; // 끝까지 갈 수 있음!! 더 이상 볼 필요 없음!
				
				// breakFlag를 타지 않았다는 건 끝까지 갈 수 있는 길이 없다는 것이므로
				// 길이 없으므로 방금 추가한 좌표 되돌리려고 했으나!!!!!!!!
				// 이 부분이 필요 없는 이유 : 다른 지점에서 출발하더라도 이 곳에 도착하면 마지막까지 도달할 수 없는건 똑같음!
//				map[j][col] = '.';
			}
		}
	}
}
