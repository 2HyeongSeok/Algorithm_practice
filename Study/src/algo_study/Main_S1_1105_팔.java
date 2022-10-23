package algo_study;

import java.io.*;
import java.util.*;

public class Main_S1_1105_팔 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String strL = st.nextToken();
		String strR = st.nextToken();
		
		if(strL.length() != strR.length()) {
			sb.append(0);
		}else {
			int count = 0;
			for(int i = 0; i < strL.length(); i++) {
				if(strL.charAt(i) == strR.charAt(i)) {
					if(strL.charAt(i) == '8')
						count++;
				}else {
					break;
				}
			}
			
			sb.append(count);
		}
		
		System.out.println(sb);
	}
}
