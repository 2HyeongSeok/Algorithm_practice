package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GM0812 {
	static char[] src = {'a', 'b', 'c', 'd'};

    public static void main(String[] args) {
        // 1. src로 구성할 수 있는 모든 부분집합을 출력하시오.
        System.out.println("부분집합");
        powerset();
        // 2. src에서 3개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
        System.out.println("조합");
         makeCombination(3,new char[3], 0);
        // 3. src에서 3개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
        System.out.println("순열");
         makePermutation(3, new char[3], new boolean[src.length]);
    }

    static void powerset() {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 1; i<= src.length; i++) {
    		int flag = 0;
    		sb.append("[");
    		for(int k = 1; k <= i; k++) {
    			if((flag & 1 << k) != 0) continue;
    			
    			sb.append(src[k]);
    			flag |= 1 << k;
    			
    			if(k == i) sb.append("]");
    			else sb.append(", ");
    		}
    	}
    }
    
    static void makeCombination(int toChoose, char [] choosed, int startIdx) {
        
    }
    
    static void makePermutation(int toChoose, char [] choosed, boolean [] visited) {
        
    }
}
