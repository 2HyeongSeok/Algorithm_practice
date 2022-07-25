package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1920_수찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		String[] numsStr = br.readLine().split(" ");
		int[] nums = new int[num];
		for(int i = 0; i < num; i++) {
			nums[i] = Integer.parseInt(numsStr[i]);
		}
		Arrays.sort(nums);
		
		int checkNum = Integer.parseInt(br.readLine());
		String[] checkNumsStr = br.readLine().split(" ");

		int start;
		int end;
		int mid;
		boolean isExisted;
		
		for(int i = 0; i < checkNum; i++) {
			int n = Integer.parseInt(checkNumsStr[i]);
			start = 0;
			end = num - 1;
			mid = (start + end) / 2;
			isExisted = false;
			
			while(start <= end) {
				if(nums[mid] > n) {
					// 배열의 가운데 값이 n보다 크다? -> 앞쪽 범위 스캔
					end = mid - 1;
					mid = (start + end) / 2;
				}else if(nums[mid] == n) {
					isExisted = true;
					break;
				}else {
					start = mid + 1;
					mid = (start + end) / 2;
				}
			}
			
			if(isExisted)
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
}
