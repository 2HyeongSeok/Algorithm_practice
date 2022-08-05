package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891_DNA비밀번호 {

	static int aCnt;
	static int cCnt;
	static int gCnt;
	static int tCnt;
	static int total = 0;
	static int[] dest;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int sLen = Integer.parseInt(st.nextToken());
		int pLen = Integer.parseInt(st.nextToken());

		char[] arr = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine(), " ");
		int[] count = new int[4];
		dest = new int[4];
		for(int i = 0; i < 4; i++) {
			dest[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < pLen; i++) {
			switch (arr[i]) {
			case 'A':
				count[0]++;
				break;
			case 'C':
				count[1]++;
				break;
			case 'G':
				count[2]++;
				break;
			case 'T':
				count[3]++;
				break;
			default:
				break;
			}
		}

		sub(arr, count, 0, pLen);

		System.out.println(total);
	}

	static void sub(char[] arr, int[] count, int index, int pLen) {
		int counting = 0;
		for(int i = 0; i < 4; i++) {
			if(count[i] >= dest[i]) counting++;
		}
		if(counting == 4) total++;
		
		if (index + pLen >= arr.length) {
			// 기저조건
			return;
		}
		
		char lastTemp = arr[index]; // 처음 자리 char 기억
		
		switch(lastTemp) { // 처음 값 다시 빼고
		case 'A':
			count[0]--;
			break;
		case 'C':
			count[1]--;
			break;
		case 'G':
			count[2]--;
			break;
		case 'T':
			count[3]--;
			break;
		default:
			break;
		}
				
		switch(arr[index + pLen]) { // 다음 값 더하고
		case 'A':
			count[0]++;
			break;
		case 'C':
			count[1]++;
			break;
		case 'G':
			count[2]++;
			break;
		case 'T':
			count[3]++;
			break;
		default:
			break;
		}

		// 재귀로 체크
		sub(arr, count, index + 1, pLen);
	}
}
