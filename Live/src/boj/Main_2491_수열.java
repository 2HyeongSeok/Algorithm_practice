package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2491_수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		// N이 1이면 max=1, 1보다 크면 max=2 시작
		int max = N > 1 ? 2 : 1;
		// 자기 자신은 기본적으로 포함하므로 최소 길이 1
		int asceCnt = 1;
		int descCnt = 1;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) 
			nums[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N - 1; i++) {
			if(nums[i] < nums[i + 1]) {
				asceCnt++;

				// descCnt 초기화 전 max로 저장할지 여부 판단
				max = max < descCnt ? descCnt : max;
				descCnt = 1;
			}else if(nums[i] == nums[i + 1]) {
				asceCnt++;
				descCnt++;
				
			}else {
				descCnt++;
				
				// asceCnt 초기화 전 max로 저장할지 여부 판단
				max = max < asceCnt ? asceCnt : max;
				asceCnt = 1;				
			}
			
			if(i == N - 2) {
				// 마지막까지 카운팅 하고 있으면 따로 체크해줘야함
				int tempMax = asceCnt > descCnt ? asceCnt : descCnt;
				max = tempMax > max ? tempMax : max;
			}
		}
		System.out.println(max);
	}
}
