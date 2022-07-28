package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2751_수정렬하기2 {
	public static int[] arr;
	public static int[] sorted;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		
		arr = new int[size];
		sorted = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(0, size - 1);
		
		for(int i = 0; i < size; i++) {
			System.out.println(arr[i]);
		}
	}
	
	// merge sort
	static void mergeSort(int left, int right) {
		int mid;
		
		if(left < right) {
			mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}
	
	static void merge(int left, int mid, int right) {
		int l = left;
		int m = mid + 1;
		int index = left;
		
		while(l <= mid && m <= right) {
			if(arr[l] <= arr[m])
				sorted[index++] = arr[l++];
			else
				sorted[index++] = arr[m++];
		}
		if(l > mid) {
			for(int i = m; i <= right; i++) {
				sorted[index++] = arr[i];
			}
		}else {
			for(int i = l; i <= mid; i++) {
				sorted[index++] = arr[i];
			}
		}
		
		for(int i = left; i <= right; i++) {
			arr[i] = sorted[i];
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
