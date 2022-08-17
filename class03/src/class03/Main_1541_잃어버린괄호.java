package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] form = br.readLine().toCharArray();
		String value = "";
		ArrayList<Integer> nums = new ArrayList<>();
		for(int i = 0,size = form.length; i < size; i++) {
			if(form[i] == '+' || form[i] == '-') {
				nums.add(Integer.parseInt(value));
			}
		}
	}
}
