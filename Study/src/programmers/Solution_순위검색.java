package programmers;

import java.util.*;

public class Solution_순위검색{
	
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        String[] info_one, query_one;
        int query_score;
        
        for(int i = 0; i < info.length; i++){
            info_one = info[i].split(" ");
            comb("", 0, info_one); // 가능한 문자열 조합 (-가 포함된!!)
        }
        
        // 참고한 부분
        ArrayList<String> list = new ArrayList<>(map.keySet());
        for(int i = 0; i < list.size(); i++){
            ArrayList<Integer> scores = map.get(list.get(i));
            Collections.sort(scores);
        }
        
        for(int i = 0; i < query.length; i++){
            query_one = (query[i].replace(" and ", "")).split(" "); // 하나의 문자열로 만들기
            query_score = Integer.parseInt(query_one[1]); // 점수
            
            answer[i] = search(query_one[0], query_score);
        }
        return answer;
    }
    
    static void comb(String str, int count, String[] info_one){ // 조합 짜는 메소드
        if(count == 4){
            // System.out.println(str);
            int score = Integer.parseInt(info_one[4]);
            if(!map.containsKey(str)){
                // 이전에 존재하지 않았다면
                ArrayList<Integer> scores = new ArrayList<>();
                scores.add(score);
                map.put(str, scores);
            }else{
                // 이전에 존재했다면
                map.get(str).add(score);
            }
            return;
        }
        
        comb(str+"-", count + 1, info_one);
        comb(str+info_one[count], count + 1, info_one);
    }
    
    static int search(String query, int score){ // 점수 찾는 메소드
        if(!map.containsKey(query)) return 0;
        else{
            ArrayList<Integer> scoreList = map.get(query);
            // Collections.sort(scoreList);
            
            int start = 0, end = scoreList.size() - 1;
            while(start <= end){
                int mid = (start+end)/2;
                
                if(score > scoreList.get(mid)) start = mid + 1;
                else end = mid - 1;
            }
            
            return scoreList.size() - start;
        }
    }
}