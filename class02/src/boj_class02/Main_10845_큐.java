package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10845_큐 {
	
	static int[] queue = new int[10000]; // 최대 만개 푸시 가능
	static int total = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int res;
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			if(line.charAt(1) == 'u') {
				String[] lines = line.split(" ");
				push(Integer.parseInt(lines[1]));
				continue;
			}
			if(line.equals("pop")) {
				res = pop();
				sb.append(res).append("\n");
			}else if(line.equals("size")) {
				res = size();
				sb.append(res).append("\n");
			}else if(line.equals("empty")) {
				if(empty()) sb.append("1\n");
				else sb.append("0\n");
			}else if(line.equals("front")) {
				res = front();
				sb.append(res).append("\n");
			}else if(line.equals("back")) {
				res = back();
				sb.append(res).append("\n");
			}
		}
		System.out.println(sb);
		
	}
	
	
	static void push(int k) {
		queue[total++] = k;
	}
	
	static int pop() {
		if(empty()) return -1;
		int result = queue[0];
		for(int i = 0; i < total - 1; i++) {
			queue[i] = queue[i + 1];
		}
		total--;
		return result;
	}
	
	static int size() {
		return total;
	}
	
	static boolean empty() {
		if (total == 0) return true;
		else return false;
	}
	
	static int front() {
		if(empty()) return -1;
		return queue[0];
	}
	
	static int back() {
		if(empty()) return -1;
		return queue[total - 1];
	}
}
