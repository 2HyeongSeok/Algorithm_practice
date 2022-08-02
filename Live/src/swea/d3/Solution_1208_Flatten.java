package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1208_Flatten {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++){
			int dumpNum = Integer.parseInt(br.readLine());
			int[] dumpArr = new int[100];
			String[] line = br.readLine().split(" ");
			for(int i = 0; i < 100; i++) {
				dumpArr[i] = Integer.parseInt(line[i]);
			}
			sb.append("#").append(test_case).append(" ");
			dump(dumpArr, dumpNum);
		}
		
		System.out.println(sb);
	}
	
	static void dump(int[] dumpArr, int dumpNum) {
		Arrays.sort(dumpArr);
		// 기저조건
		if( dumpArr[dumpArr.length - 1] - dumpArr[0] <= 1 || dumpNum == 0) {
			sb.append(dumpArr[dumpArr.length - 1] - dumpArr[0]).append("\n");
			return;
		}
		dumpArr[dumpArr.length - 1]--;
		dumpArr[0]++;
		dump(dumpArr, dumpNum - 1);
	}
}

