package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	static int[] isSelected;
	
	static ArrayList<Integer[]> house;
	static ArrayList<Integer[]> chickenHouse;
	
	static int[][] map;
	
	static int resMinDistance = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		isSelected = new int[M];

		map = new int[N + 1][N + 1];
		house = new ArrayList<>();
		chickenHouse = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				// 각 집에 대한 정보를 ArrayList에 저장하기 위함
				Integer[] temp = new Integer[2];
				temp[0] = i;
				temp[1] = j;

				switch (map[i][j]) {
				case 1:
					house.add(temp);
					break;
				case 2:
					chickenHouse.add(temp);
					break;
				default:
					break;
				}
			}
		}
		
		comb(N, M, 0, 0, 0);
		System.out.println(resMinDistance);
	}
	
	// M개 고르는 조합
	static void comb(int N, int M, int count, int start, int flag) {
		if(count == M) {
			// 여기서 최소거리 구해야할듯?
			int tempCityDistance = 0;
			for(int i = 0; i < house.size(); i++) {
				int minDistance = Integer.MAX_VALUE;

				// 각 집에서 치킨집까지 거리 최소 찾기 위함
				for(int j = 0; j < M; j++) {
					int index = isSelected[j];
					
					int tempDistance = Math.abs(house.get(i)[0] - chickenHouse.get(index)[0]) + Math.abs(house.get(i)[1] - chickenHouse.get(index)[1]);
					minDistance = minDistance < tempDistance ? minDistance : tempDistance; // 집과 치킨집의 최소거리 갱신
				}
				tempCityDistance += minDistance; // 각 집마다 최소거리 구한걸 더해줌 -> 도시의 치킨거리 최소값
			}
			resMinDistance = resMinDistance < tempCityDistance ? resMinDistance : tempCityDistance; // 도시의 치킨거리 최소값들 중에서 최소값 찾기
			return;
		}
		
		// 비트마스킹을 이용한 조합
		for(int i = start; i < chickenHouse.size(); i++) {
			if((flag & 1 << i) != 0) continue;
			
			isSelected[count] = i;
			comb(N, M, count + 1, i + 1, flag | 1 << i);
		}
	}
}
