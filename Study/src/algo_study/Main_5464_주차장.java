package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5464_주차장 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] prices = new int[N];
		for (int i = 0; i < N; i++) {
			prices[i] = Integer.parseInt(br.readLine()); // 단위 무게당 요금
		}
		int[] cars = new int[M + 1];
		for (int i = 1; i <= M; i++) {
			cars[i] = Integer.parseInt(br.readLine()); // 1 ~ M번 차량들의 무게
		}

		int curSize = 0;
		int totalCnt = 0;
		int totalPrice = 0;
		int[] curMap = new int[N];
		Queue<Integer> orders = new ArrayDeque<Integer>();
		for (int i = 0; i < 2 * M; i++) {
			// 탈출 조건
			if(totalCnt == M) break;
			
			int car = Integer.parseInt(br.readLine());		
			if (car > 0) {
				if (curSize < N) {
					for (int k = 0; k < N; k++) {
						if (curMap[k] == 0) {
							curMap[k] = car;
							totalPrice += prices[k] * cars[car];
							totalCnt++;
							curSize++;
							break;
						}
					}
				} else {
					orders.offer(car);
				}
			} else {
				for (int k = 0; k < N; k++) {
					if (curMap[k] == -car) {
						if (!orders.isEmpty()) {
							// 해당 인덱스에 orders가 있다면 대신 넣어주기!!
							int tempCar = orders.poll();
							curMap[k] = tempCar;
							totalPrice += prices[k] * cars[tempCar];
							totalCnt++;
						} else {
							// 해당 인덱스에 orders가 없다면 빼기만 하기!!
							curMap[k] = 0;
							curSize--;
						}
						break;
					}
				}
			}

		}
		System.out.println(totalPrice);
	}
}
