package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_15829_Hashing {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger r = new BigInteger("31");;
		BigInteger M = new BigInteger("1234567891");
		int N = Integer.parseInt(br.readLine());
		
		BigInteger sum = new BigInteger("0");
		char[] c = br.readLine().toCharArray();
		for(int i = 0; i < N; i++) {
			int tempChar = c[i] - '0' - 48;
			BigInteger temp = new BigInteger("" + tempChar); // 'a' = 97 '0' = 48 이므로

			for(int j = 0; j < i; j++) { 
				temp = temp.multiply(r);
				temp = temp.mod(M);
			}
			sum = sum.add(temp);
			sum = sum.mod(M);
		}
		
		System.out.println(sum);
	}
}
