package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1289_원재의메모리복구하기 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        StringBuilder sb = new StringBuilder();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String line = br.readLine();
            int count;
            int len = line.length();
             
            if(line.charAt(0) == '1') count = 1;
            else count = 0;
 
            for(int i = 1; i < len; i++){
                if(line.charAt(i) != line.charAt(i - 1))
                    count++;
            }
            sb.append("#" + test_case + " " + count + "\n");
        }
         
        System.out.println(sb);
	}
}
