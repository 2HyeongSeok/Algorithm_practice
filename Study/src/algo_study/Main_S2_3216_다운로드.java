package algo_study;

import java.io.*;
import java.util.*;

public class Main_S2_3216_다운로드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		// V시간이 지나고 나서야 D를 실행할 수 있으므로 처음 D값을 0으로 저장하기 위함
		// 다운로드 받는 시간이 없으니깐 마지막 V는 0!
		int[][] musics = new int[N+1][2]; 
		
		musics[0][0] = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int length = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			musics[i+1][0] = length;
			musics[i][1] = time;
		}
		musics[N][1] = 0;
		
		// 시간 누적
		// 맨 마지막 행은 무조건 음수이므로 굳이 안함!
		// 마지막 행부터 초행까지 각 행별로 V-D 진행해서 t에 누적하는데
		// 누적된 t 값이 0보다 작거나 같다면 들을 수 있다는 의미 -> t = 0으로 초기화해주고
		// t가 0보다 크다면 그 시간만큼 대기해야 한다는 의미 -> t에 누적
		int t = 0;
		for(int i = N-1; i >= 0; i--) {
			t = t + musics[i][1] - musics[i][0] <= 0 ? 0 : t + musics[i][1] - musics[i][0];
		}
		
		System.out.println(t);
	}
}
