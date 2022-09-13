package programmers;

import java.util.*;

public class Solution_수식최대화 {
	static int N;
    static long answer = 0;
    static char[] opers;
    static char[] selected;
    public long solution(String expression) {
        int[] operExist = new int[3];
        String tempExpression = expression.replaceAll("[0-9]", "");
        for(int i = 0, size = tempExpression.length(); i < size; i++){
            if(operExist[0] == 0 && tempExpression.charAt(i) == '*')
                operExist[0] = 1;
            if(operExist[1] == 0 && tempExpression.charAt(i) == '+')
                operExist[1] = 1;
            if(operExist[2] == 0 && tempExpression.charAt(i) == '-')
                operExist[2] = 1;
            
            if(operExist[0] + operExist[1] + operExist[2] == 3){
                // 3개 다 사용하므로 미리 break 가능
                break;
            }
        }
        
        if(operExist[0] + operExist[1] + operExist[2] == 3){
            N = 3;
            opers = new char[]{'*', '+', '-'};
            selected = new char[3];
        }else if(operExist[0] + operExist[1] + operExist[2] == 2){
            N = 2;
            selected = new char[2];
            if(operExist[0] == 1 && operExist[1] == 1){
                opers = new char[]{'*', '+'};
            }else if(operExist[0] == 1 && operExist[2] == 1){
                opers = new char[]{'*', '-'};
            }else if(operExist[1] == 1 && operExist[2] == 1){
                opers = new char[]{'+', '-'};
            }
        }else{
            // 1개일 때
            N = 1;
            selected = new char[1];
            if(operExist[0] == 1) opers = new char[]{'*'};
            else if(operExist[1] == 1) opers = new char[]{'+'};
            else if(operExist[2] == 1) opers = new char[]{'-'};
        }
        
        perm(expression, 0, 0);
        
        return answer;
    }
    
    static void perm(String expression, int count, int flag){
        if(count == N){
            // N개가 다 뽑혔다면
            Deque<Long> nums;
            Deque<Character> operands;
            String number;
            for(int k = 0; k < N; k++){
                char thisOper = selected[k];
                nums = new ArrayDeque<>();
                operands = new ArrayDeque<>();
                number = "";
                for(int i = 0, size = expression.length(); i < size; i++){
                    char value = expression.charAt(i);
                    
                    if((value - '0') >= 0 && (value - '0') <= 9){
                        // 숫자면 이어서 숫자 String만들기
                        number += Character.toString(value);
                        if(i == size - 1){ // 마지막이면 바로 숫자 Deque에 추가
                            nums.offerLast(Long.parseLong(number));
                            
                            if(operands.peekLast() == thisOper){
                                long secondNum = nums.pollLast();
                                long firstNum = nums.pollLast();
                                operands.pollLast();
                                if(thisOper == '*') nums.offerLast(firstNum * secondNum);
                                else if(thisOper == '+') nums.offerLast(firstNum + secondNum);
                                else nums.offerLast(firstNum - secondNum);
                            }
                        }
                    }else{
                        // 문자가 나오면 지금까지 나왔던거 숫자 Deque에 저장
                        // 만약 연이어서 문자가 나온다면 음수인 것
                        if(number.equals("")) {
                            number += value;
                            continue;
                        }
                        
                        nums.offerLast(Long.parseLong(number));
                        number = "";
                        if(operands.isEmpty()){ // 비어있다면 일단 첫 연산자이므로 offer
                            operands.offerLast(value);
                        }else{ // 비어있지 않다면 이제 우선순위에 따라 연산 시작
                            if(operands.peekLast() == thisOper){
                                long secondNum = nums.pollLast();
                                long firstNum = nums.pollLast();
                                operands.pollLast();
                                if(thisOper == '*') {
                                    nums.offerLast(firstNum * secondNum);
                                }
                                
                                else if(thisOper == '+') nums.offerLast(firstNum + secondNum);
                                else nums.offerLast(firstNum - secondNum);
                                operands.offerLast(value);
                            }else{
                                operands.offerLast(value);
                            }
                        }
                    }
                }
                if(k < N-1){
                    expression = Long.toString(nums.pollFirst());
                    for(int p = 0, length = nums.size(); p < length; p++){
                        expression += Character.toString(operands.pollFirst());
                        expression += Long.toString(nums.pollFirst());
                    }
                }else{
                    long result = nums.poll();
                    answer = answer > Math.abs(result) ? answer : Math.abs(result);
                }
            }
            return;
        }
        for(int i = 0; i < N; i++){
            if((flag & 1 << i) != 0) continue;
            
            selected[count] = opers[i];
            perm(expression, count + 1, flag | 1<< i);
        }
    }
}
