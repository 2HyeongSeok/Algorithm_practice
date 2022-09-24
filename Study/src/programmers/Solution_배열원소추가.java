package programmers;

import java.util.*;

class Solution_배열원소추가 {
    public int solution(int[][] queries) {
        int answer = 0;

        // map의 Integer[] -> [0] : 원소의 수, [1] : 배열의 크기
        Map<Integer, Integer[]> map = new HashMap<>();
        for(int i = 0; i < queries.length; i++){
            int arrNum = queries[i][0];
            int elements = queries[i][1];

            if(map.containsKey(arrNum)){
                // 이미 존재한다면
                Integer[] arrTemp = map.get(arrNum);
                int curElements = arrTemp[0];
                int curArrSize = arrTemp[1];
                elements += curElements;
                if(arrNum <= curArrSize) map.put(arrNum, new Integer[]{elements, curArrSize});
                else{
                    int newArrSize = find(curElements);
                    map.put(arrNum, new Integer[]{curElements, newArrSize});
                    answer += curElements;
                }
            }else{
                // 없다면
                int newArrSize = find(elements);
                map.put(arrNum, new Integer[]{elements, newArrSize});
            }
        }
        
        return answer;
    }
    

    static int find(int number){
        int index = 0;
        while((int)Math.pow(2, index) < number){
            index++;
        }
        return (int)Math.pow(2, index);
    }
}