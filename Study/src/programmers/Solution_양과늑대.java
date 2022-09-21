package programmers;

import java.util.*;

class Solution_양과늑대 {
	static int maxCount = 0;
    static int[] info;
    static int[][] edges;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.edges = edges;
        ArrayList<Integer> list = new ArrayList<>(); // 갈 수 있는, 방문 아직 안한 노드들!!

		list.add(0);
		dfs(0, 0, 0, list);
        
        return maxCount;
    }
    
    static void dfs(int sheep, int wolf, int curr, ArrayList<Integer> next) {
		if (info[curr] == 0) {
			// 양이면
			sheep++;
		} else if (info[curr] == 1) {
			// 늑대라면
			if (sheep <= wolf + 1) { // 갈 수 없음
				return;
			} 
			wolf++;
		}
		
		maxCount = maxCount < sheep ? sheep : maxCount;
        
		ArrayList<Integer> list = new ArrayList<>(); // 리스트 복사
		list.addAll(next);
		list.remove(list.indexOf(curr)); // 현재 인덱스에 해당하는 list 멤버를 지움
        
		for (int[] edge : edges) {
			if (edge[0] == curr) { // 현재 노드가 부모노드인 노드들 추가
				if (!list.contains(edge[1])) {
					list.add(edge[1]);
				}
			}
		}

		for (Integer newInt : list) {
			dfs(sheep, wolf, newInt, list);
		}
	}
}