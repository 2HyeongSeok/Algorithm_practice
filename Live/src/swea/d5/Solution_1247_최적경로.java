package swea.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {
	
	static int N;
	static int[] selected;
	static int minDistance, distance;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int[] source, destination = new int[2];
		ArrayList<Integer[]> coordinates;
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			selected = new int[N];
			minDistance = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine(), " ");
			
			source = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; // 회사 좌표
			destination = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; // 집 좌표
			coordinates = new ArrayList<>();
			for(int i = 0; i < N; i++) { // N명의 고객 좌표
				Integer[] temp = new Integer[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
				coordinates.add(temp);
			}
			
			for(int i = 0; i < N; i++) {
				// N명의 고객들 사이의 거리 (모두 방문하는 경우마다 거리 구하기)
				// 시작점 i
				selected[0] = i;
				perm(coordinates, source, destination, 1, 0 | 1 << i);
			}
			
			sb.append("#").append(t).append(" ").append(minDistance).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void perm(ArrayList<Integer[]> coordinates, int[] source, int[] destination, int cnt, int flag) {
		if(cnt == N) { // 이미 i번째는 선택하고 들어옴
			
			// 회사 -> N명의 고객 (거리 찾기)
			distance = Math.abs(source[0] - coordinates.get(selected[0])[0]) + Math.abs(source[1] - coordinates.get(selected[0])[1]);

			// 순열 뽑힌거에서 거리 계산해야함
			for(int k = 0; k < N-1; k++) {
				distance += Math.abs(coordinates.get(selected[k])[0] - coordinates.get(selected[k+1])[0]) + Math.abs(coordinates.get(selected[k])[1] - coordinates.get(selected[k+1])[1]);
				if(distance > minDistance) return; // 너무 불필요한 계산 하지 않도록 중간에 끝내버리기
			}
			
			// N명의 고객 -> 집 (거리 찾기)
			distance += Math.abs(destination[0] - coordinates.get(selected[N-1])[0]) + Math.abs(destination[1] - coordinates.get(selected[N-1])[1]);
			
			minDistance = minDistance < distance ? minDistance : distance;
			
			return;
		}
		
		for(int k = 0; k < N; k++) {
			if((flag & 1 << k) != 0) continue;
			
			selected[cnt] = k;
			perm(coordinates, source, destination, cnt + 1, flag | 1 << k);
		}
	}
	
}
