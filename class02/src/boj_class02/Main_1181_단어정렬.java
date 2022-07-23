package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Main_1181_단어정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<String>();
		
		for(int i = 0; i < size; i++) {
			set.add(br.readLine()); // 중복 제거
		}
		
		size = set.size(); // 단어 개수
		String[] arr = new String[size];
		int index = 0;
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			arr[index] = iter.next(); // 배열에 단어들 저장
			index++;
		}
		
		Arrays.sort(arr); // 알파벳 순으로 정렬 -> 이제 길이 순으로 정렬하면 끝
		int len = 1;
		String[] ans_arr = new String[size];
		int ans_index = 0;
		
		while(len <= 50) {
			for(int i = 0; i < size; i++) {
				if(arr[i].length() == len) {
					ans_arr[ans_index] = arr[i];
					ans_index++;
				}
			}
			len++;
		}
		
		for(int i = 0; i < size; i++) {
			System.out.println(ans_arr[i]);
		}
	}
}
