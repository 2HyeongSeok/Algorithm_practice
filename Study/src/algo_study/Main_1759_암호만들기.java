package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {
	static char[] selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		selected = new char[L];
		
		char[] list = br.readLine().replaceAll(" ", "").toCharArray();
		Arrays.sort(list);
		comb(L, list, 0, 0, 0);
		
		System.out.println(sb);
	}
	
	static void comb(int L, char[] list, int cnt, int start, int flag) {
		if(cnt == L) {
			int jaCount = 0, moCount = 0;;
			for(int i = 0; i < L; i++) {
				if("aeiou".contains(Character.toString(selected[i])))
					moCount++;
				else 
					jaCount++;
			}
			
			if(moCount >= 1 && jaCount >= 2) {
				String temp = new String(selected);
				sb.append(temp).append("\n");
			}
			
			return;
		}
		
		for(int i = start, len = list.length; i < len; i++) {
			if((flag & 1 << i) != 0) continue;
			
			selected[cnt] = list[i];
			comb(L, list, cnt + 1, i + 1, flag | 1 << i);
		}
	}
}
