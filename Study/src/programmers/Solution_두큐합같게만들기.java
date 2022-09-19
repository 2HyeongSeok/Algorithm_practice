package programmers;

import java.util.*;

class Solution_두큐합같게만들기{
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> info1 = new ArrayDeque<>();
		Queue<Integer> info2 = new ArrayDeque<>();
		
		long sum_queue1 = 0, sum_queue2 = 0; // 처음엔 길이가 같으므로
		int answer = 0;
        
		for(int i = 0; i < queue1.length; i++) {
			info1.offer(queue1[i]);
			sum_queue1 += queue1[i];
			info2.offer(queue2[i]);
			sum_queue2 += queue2[i];
		}
		
		while(sum_queue1 != sum_queue2) {
			if(sum_queue1 > sum_queue2) {
				// queue2가 합이 더 작다면 queue1에서 하나 빼와야 함
				sum_queue1 -= info1.peek();
				sum_queue2 += info1.peek();
				info2.offer(info1.poll());
			}else {
				// queue1가 합이 더 작다면 queue2에서 하나 빼와야 함
				sum_queue2 -= info2.peek();
				sum_queue1 += info2.peek();
				info1.offer(info2.poll());
			}
			answer++;
            
            // 최대 이동회수는 [1,2,1,2] [1,1,10,2] 일 때 
            // 오른쪽 큐가 [1,1,10] 이동하고 (length - 1)
            // 왼쪽 큐가 전체 + [1,1] 이동해야하므로 (length + (length - 2))
            // 따라서 아래처럼 수식이 세워졌음
			if(answer > (queue1.length - 1) + (queue2.length + queue1.length - 2)) {
				answer = -1;
				break;
			}
		}
        return answer;
    }
}