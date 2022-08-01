import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution_D3_원재의메모리복구하기
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            String[] line = br.readLine().split("");
            int len = line.length;

            int[] arr = new int[len];
            for(int i = 0; i < len; i++){
                arr[i] = Integer.parseInt(line[i]);
            }

            int check = 0;
            int count = 0;
            for(int i = 0; i < len; i++){
                if(check == 0){
                    if(arr[i] == 1){
                        check = 1;
                        count++;
                    }
                }else{
                    if(arr[i] == 0){
                        check = 0;
                        count++;
                    }
                }
            }
            sb.append("#" + test_case + " " + count + "\n");
		}
		
		System.out.println(sb);
	}
}