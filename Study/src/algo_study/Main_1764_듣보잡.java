package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 듣도 못한
		int M = Integer.parseInt(st.nextToken()); // 보도 못한
		
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		ArrayList<String> dbx = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			String bxTemp = br.readLine();
			if(!set.add(bxTemp)) { // 보도 못한 이름들은 어차피 중복되게 들어오지 않으므로
				// false라면 추가 실패이므로 중복 있다는 뜻
				if(dbx.isEmpty()) dbx.add(bxTemp); // 처음
				else {
					
					for(int k = 0; k < dbx.size(); k++) {
						if(dbx.get(k).compareTo(bxTemp) > 0) {
							dbx.add(k, bxTemp);
							break;
						}
						if(k == dbx.size() - 1) {
							dbx.add(bxTemp);
							break;
						}
					}
				}
			}
		}
		
		sb.append(dbx.size()).append("\n");
		for(int i = 0; i < dbx.size(); i++) {
			sb.append(dbx.get(i)).append("\n");
		}
		
		System.out.println(sb);
	}
}
