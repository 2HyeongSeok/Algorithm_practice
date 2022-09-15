package programmers;

public class Solution_k진수에서소수개수구하기 {
	static int answer = 0;
    public int solution(int n, int k) {
        String[] numArr = Integer.toString(n, k).split("0");
        for(int i = 0; i < numArr.length; i++){
            if(isPrime(numArr[i])) answer++;
        }
        
        return answer;
    }
    
    static boolean isPrime(String number){        
        if(number.equals("")) return false; // 00 이어서 나왔을 때
        
        long returnNumber = Long.parseLong(number);
        
        if(returnNumber == 1) return false; // 1이면
        for(int i = 2; i <= (long)(Math.sqrt(returnNumber)); i++){
            if(returnNumber % i == 0) return false; // 소수가 아니면
        }
        return true;
    }
}
