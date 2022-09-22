package programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Solution_등산코스정하기 {
	
	static int n = 7;
	static int[][] paths = { { 1, 4, 4 }, { 1, 6, 1 }, { 1, 7, 3 }, { 2, 5, 2 }, { 3, 7, 4 }, { 5, 6, 6 } }; // 연결 좌표들과 intensity
	static int[] gates = {1}; // 출입구 번호
	static int[] summits = {2, 3,4}; // 산봉우리
	
	static boolean[] selected;
	static int finalIntensity = Integer.MAX_VALUE, finalSummit = 0;
	
	static Map<Integer, Integer> gatesMap = new HashMap<>();
	static ArrayList<Integer> intensityList = new ArrayList<>();
	
	public static void main(String[] args) {		
		// 가는 경우만 생각해도 될듯
		
		int length = gates.length;
		int nodes = n - length;
		
		ArrayList<Integer[]>[] list = new ArrayList[n+1];
		for(int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < paths.length; i++) {
			list[paths[i][0]].add(new Integer[] {paths[i][1], paths[i][2]}); // 인접 노드 번호와 intensity 값 저장
			list[paths[i][1]].add(new Integer[] {paths[i][0], paths[i][2]}); // 반대도 저장
		}
		
		for(int i = 0; i < length; i++) { // containsKey 이용하기 위해
			gatesMap.put(gates[i], gates[i]);
		}
		
		for(int i = 0; i < length; i++) {
			int start = gates[i];
			
			// 다른 게이트 방문하지 않도록 방문처리하기
			selected = new boolean[n+1];
			for(int k = 0; k < length; k++) {
				if(i == k) continue;
				selected[gates[k]] = true; 
			}
			System.out.println("start : " + start);
			bfs(start, list);
		}
		
		int[] result = {finalSummit, finalIntensity};
		System.out.println(Arrays.toString(result));
		
	}
	
	static void bfs(int start, ArrayList<Integer[]>[] list) {
		Queue<Integer[]> queue = new ArrayDeque<>();
		boolean meetSummit = false;
		int maxIntensity = 0;
		queue.offer(new Integer[] {start, maxIntensity});
		
		while(!queue.isEmpty()) {
			Integer[] cur = queue.poll();
			int curIdx = cur[0];
			maxIntensity = cur[1];
			selected[curIdx] = true;
			
			System.out.println("curIdx = " + curIdx + ", maxIntensity = " + maxIntensity);
			// 기저조건
			// 산봉우리 중 하나라면 intensity 비교 후 더 작은 것으로 갱신하고 탈출!!
			for(int i = 0; i < summits.length; i++) {
				if(curIdx == summits[i]) {
					if(maxIntensity < finalIntensity) {
						finalIntensity = maxIntensity;
						finalSummit = curIdx;
						System.out.println("final : " +finalSummit+ ", " + finalIntensity);
						meetSummit = true;
						break;
					}else if(maxIntensity == finalIntensity) {
						finalSummit = finalSummit > curIdx ? curIdx : finalSummit;
						System.out.println("final : " +finalSummit+ ", " + finalIntensity);
						meetSummit = true;
						break;
					}
				}
			}
			
			if(meetSummit) {
				meetSummit = false;
				continue;
			}
			
			for(int i = 0; i < list[curIdx].size(); i++) {
				if(!selected[list[curIdx].get(i)[0]]) {
					int nextMax = maxIntensity > list[curIdx].get(i)[1] ? maxIntensity : list[curIdx].get(i)[1];
					queue.offer(new Integer[] {list[curIdx].get(i)[0], nextMax});
				}
			}
		}
	}
}
