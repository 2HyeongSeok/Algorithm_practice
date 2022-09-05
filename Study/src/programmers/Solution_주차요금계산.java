package programmers;

import java.io.*;
import java.util.*;

public class Solution_주차요금계산 {

	class Car implements Comparable<Car> {
		int carNum, totalTime;

		Car(int carNum, int totalTime) {
			super();
			this.carNum = carNum;
			this.totalTime = totalTime;
		}

		@Override
		public int compareTo(Car o) {
			return this.carNum - o.carNum;
		}
	}

	public int[] solution(int[] fees, String[] records) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Map<Integer, Integer> carList = new HashMap<>(); // 주차장에 있는 차 목록
		Map<Integer, Integer> costList = new HashMap<>(); // 주차장에 왔었던 차 별로 누적시간 저장해둔 목록
		ArrayList<Integer> carNums = new ArrayList<>(); // 주차장에 들어왔다가 나가지 않은 차 목록 저장

		for (int i = 0, size = records.length; i < size; i++) {
			st = new StringTokenizer(records[i], " ");
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), ":");
			// 시 * 60 + 분
			int time = Integer.parseInt(st2.nextToken()) * 60 + Integer.parseInt(st2.nextToken());
			int carNum = Integer.parseInt(st.nextToken());
			String carFlag = st.nextToken();

			if (carFlag.equals("IN")) {
				// 들어온 케이스 -> 맵에 (차 번호, 입장 시간) 기록
				// System.out.println("carNum : " + carNum + ", time = " + time);
				carList.put(carNum, time);
				carNums.add(carNum);
			} else {
				// 나가는 케이스 -> 맵에서 꺼내고, 누적 시간 계산
				int accumTime = time - carList.remove(carNum);
				carNums.remove(carNums.indexOf(carNum)); // 나간 차 빼주기

				if (costList.containsKey(carNum)) {
					// 기존에 이미 들어왔었던 자동차라면 누적시간 더해주고
					int totalTime = accumTime + costList.remove(carNum);
					costList.put(carNum, totalTime);
				} else {
					// 없었다면 새롭게 추가
					costList.put(carNum, accumTime);
				}
			}
		}

		// 다 처리한 후, 만약 carList에 남아있다면 23:59로 처리해야함
		// System.out.println("carNums 크기 : " + carNums.size());
		for (int i = 0, size = carNums.size(); i < size; i++) {
			int carNum = carNums.get(i);
			int lastTime = (23 * 60 + 59) - carList.remove(carNum);
			if (costList.containsKey(carNum)) {
				// 기존에 이미 들어왔었던 자동차라면 누적시간 더해주고
				int totalTime = lastTime + costList.remove(carNum);
				costList.put(carNum, totalTime);
			} else {
				// 없었다면 새롭게 추가
				costList.put(carNum, lastTime);
			}
		}

		PriorityQueue<Car> pq = new PriorityQueue<>();
		int N = 0;
		for (Integer key : costList.keySet()) {
			N++;
			pq.offer(new Car(key, costList.get(key)));
		}

		// 빌 때까지 뺀다
		int[] answer = new int[N];
		int index = 0;
		while (!pq.isEmpty()) {
			Car tempCar = pq.poll();
			// System.out.println("차 번호 : " + tempCar.carNum + ", 누적 시간 : " +
			// tempCar.totalTime);
			if (tempCar.totalTime < fees[0]) {
				answer[index++] = fees[1];
			} else {
				answer[index++] = (int) (Math.ceil((double) (tempCar.totalTime - fees[0]) / fees[2])) * fees[3]
						+ fees[1];
			}
		}

		// int[] answer = {};
		return answer;
	}
}
