package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.print.attribute.HashAttributeSet;


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
		
//		// 첫 사람
//		String[] line = br.readLine().split(" ");
//		age.add(Integer.parseInt(line[0]));
//		name.add(line[1]);
//		
//		for(int i = 1; i < N; i++) {
//			// 두번째부터 N번째 사람
//			line = br.readLine().split(" ");
//			
//			int thisAge = Integer.parseInt(line[0]);
//			String thisName = line[1];
//			
//			int len = age.size();
//			for(int k = 0; k < len; k++) {
//				if(thisAge < age.get(k)) {
//					age.add(k, thisAge);
//					name.add(k, thisName);
//					break;
//				}
//				if(k == len - 1) {
//					age.add(thisAge);
//					name.add(thisName);
//				}
//			}
//		}
//		for(int i = 0; i < N; i++) {
//			sb.append(age.get(i)).append(" ").append(name.get(i)).append("\n");
//		}
		
		System.out.println(sb);
	}
}
