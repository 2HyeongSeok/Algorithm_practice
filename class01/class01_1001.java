import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class class01_1001 {
    public static void main(String args[]) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String [] num_arr = bufferedReader.readLine().split(" ");
        int a = Integer.parseInt(num_arr[0]);
        int b = Integer.parseInt(num_arr[1]);

        System.out.println(a - b);
    }
}
