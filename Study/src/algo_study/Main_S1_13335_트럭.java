package algo_study;

import java.io.*;
import java.util.*;

public class Main_S1_13335_Ʈ�� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // Ʈ���� ��
		int w = Integer.parseInt(st.nextToken()); // �ٸ��� ����
		int L = Integer.parseInt(st.nextToken()); // �ٸ��� �ִ� ����
		
		int[] list = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, Integer> onBridge = new HashMap<>();
		int index = 0, time = 0, weight = 0;
		while(index < list.length) {
			time++; // �ð� ���ϰ�

			if(onBridge.containsKey(time - w)) {
				weight -= onBridge.remove(time - w);
			}
			
			if(weight + list[index] <= L) { // �� �ö� �� �ִٸ�
				onBridge.put(time, list[index]);
				weight += list[index];
				index++;
			}
		}
		
		time += (w); // �������� �ö��ڸ��� ����ǹǷ�
		
		System.out.println(time);
	}
}
