package boj_class01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class class01_1157 {
    public static void main(String args[]) throws IOException{
        int count_char[] = new int[26];
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 소문자로
        String lower_str = str.toLowerCase();

        for(int i = 0; i < lower_str.length(); i++){
            count_char[lower_str.charAt(i) - 'a'] += 1;
        }

        // 최대 반복 케이스 저장
        int maxInt = -1;
        int maxIndex = -1;
        boolean duplication = false;

        for(int i = 0; i < count_char.length; i++){
            if(maxInt < count_char[i]){
                maxInt = count_char[i];
                maxIndex = i;
                duplication = false;
            }
            else if(maxInt == count_char[i]){
                duplication = true;
            }
        }
        
        if(duplication == false){
            System.out.println((char)(maxIndex + 'a' - 32));
        }
        else{
            System.out.println("?");
        }

    }
}
