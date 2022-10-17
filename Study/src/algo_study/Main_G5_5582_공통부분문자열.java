package algo_study;

import java.io.*;

public class Main_G5_5582_공통부분문자열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		char[] shorts, longs;
		int len;
		// 짧은 문자열을 shorts에, 긴 문자열을 longs에 저장
		if(a.length() > b.length()) {
			shorts = b.toCharArray();
			len = (b.length() - 1) * 2 + a.length();
			longs = new char[len];
			for(int i = b.length() - 1; i < b.length() + a.length() - 1; i++) {
				longs[i] = a.charAt(i - b.length() + 1);
			}		
		}else {
			shorts = a.toCharArray();
			len = (a.length() - 1) * 2 + b.length();
			longs = new char[len];
			for(int i = a.length() - 1; i < a.length() + b.length() - 1; i++) {
				longs[i] = b.charAt(i - a.length() + 1);
			}
		}
		
		int maxLen = 0;
		for(int i = 0; i < len - shorts.length + 1; i++) {
			int count = 0;
			for(int j = i; j < i + shorts.length; j++) {
				if(shorts[j-i] == longs[j]) { // 같을 동안 카운팅
					count++;
					
					// 마지막까지 갔으면 갱신 해봐야함
					if(j == i + shorts.length) maxLen = maxLen > count ? maxLen : count;
				} else {
					// 갱신 후 초기화
					maxLen = maxLen > count ? maxLen : count;
					count = 0;
				}
			}
		}
		
		System.out.println(maxLen);
	}
}
