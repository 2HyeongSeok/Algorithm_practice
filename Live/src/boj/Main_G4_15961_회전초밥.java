package boj;

import java.io.*;
import java.util.*;

public class Main_G4_15961_회전초밥 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 종류
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		
		int[] numbers = new int[N];
		int[] counting = new int[d+1];
		
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		int maxLength = 0;
		int s = 0, e = 0, real_e = 0, length = 0; // 투포인터 사용
		while(s < N) {
			if(e - s < k) {
				if(counting[numbers[real_e]] == 0) length++; // value가 0이라면 새롭게 추가 됐으므로 길이도 더함
				counting[numbers[real_e]]++;
				e++;
				real_e++;
			}else if(e - s == k) {
				// 종류 수 갱신하고
				if(counting[c] >= 1) maxLength = maxLength > length ? maxLength : length;
				else maxLength = maxLength > length + 1 ? maxLength : length + 1;
				
				// 가장 오래된거 제거하고 s증가
				if(counting[numbers[s]] == 1) length--; // value가 1이라면 마지막 원소이므로 삭제될 때 길이도 빼야함
				counting[numbers[s]]--;
				s++;
			}
			
			if(e == N) real_e = 0;
		}
		
		System.out.println(maxLength);
	} 
}
