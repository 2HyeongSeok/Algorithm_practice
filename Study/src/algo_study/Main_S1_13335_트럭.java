package algo_study;

import java.io.*;
import java.util.*;

public class Main_S1_13335_트럭 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 트럭의 수
		int w = Integer.parseInt(st.nextToken()); // 다리의 길이
		int L = Integer.parseInt(st.nextToken()); // 다리의 최대 하중
		
		int[] list = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, Integer> onBridge = new HashMap<>();
		int index = 0, time = 0, weight = 0;
		while(index < list.length) {
			time++; // 시간 더하고

			if(onBridge.containsKey(time - w)) {
				weight -= onBridge.remove(time - w);
			}
			
			if(weight + list[index] <= L) { // 더 올라갈 수 있다면
				onBridge.put(time, list[index]);
				weight += list[index];
				index++;
			}
		}
		
		time += (w); // 마지막엔 올라가자마자 종료되므로
		
		System.out.println(time);
	}
}
