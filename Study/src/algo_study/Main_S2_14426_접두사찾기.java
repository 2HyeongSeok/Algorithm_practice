package algo_study;

import java.io.*;
import java.util.*;

public class Main_S2_14426_접두사찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] S = new String[N];
		for(int i = 0; i < N; i++) {
			S[i] = br.readLine();
		}
		
		int count = 0;
		String[] checking = new String[M];
		for(int i = 0; i < M; i++) {
			boolean find = false;
			checking[i] = br.readLine();
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < checking[i].length(); k++) {
					if(S[j].charAt(k) != checking[i].charAt(k)) {
						break;
					}
					
					if(k == checking[i].length() - 1) {
						count++;
						find = true;
						break;
					}
				}
				if(find) break;
			}
		}
		System.out.println(count);
	}
}
