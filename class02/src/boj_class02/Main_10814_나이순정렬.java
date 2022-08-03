package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_10814_나이순정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<Integer, ArrayList<String>> person = new HashMap<Integer, ArrayList<String>>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			if(person.get(age) == null) {
				ArrayList<String> nameList = new ArrayList<>();
				nameList.add(name);
				person.put(age, nameList);
			}else {
				person.get(age).add(name);
			}
		}
		
		for(int i = 1; i <= 200; i++) {
			if(person.get(i) != null) {
				int len = person.get(i).size();
				for(int k = 0; k < len; k++) {
					sb.append(i).append(" ").append(person.get(i).get(k)).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}
