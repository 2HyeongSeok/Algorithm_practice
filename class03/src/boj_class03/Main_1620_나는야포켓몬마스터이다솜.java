package boj_class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620_나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer, String> poketmons = new HashMap<>();
		Map<String, Integer> poketmons2 = new HashMap<>();
		
		for(int i = 1; i <= N; i++) {
			String name = br.readLine();
			poketmons.put(i, name);
			poketmons2.put(name, i);
		}
		
		for(int i = 0; i < M; i++) {
			String question = br.readLine();
			if(question.matches("[0-9]+")) {
				int key = Integer.parseInt(question);
				sb.append(poketmons.get(key)).append("\n");
			}else {
				String key2 = question;
				sb.append(poketmons2.get(key2)).append("\n");
			}
		}
		System.out.println(sb);
	}
}
