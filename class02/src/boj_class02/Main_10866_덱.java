package boj_class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_10866_덱 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Deque deque = new Deque();
		int N = Integer.parseInt(br.readLine());
		
		int res;
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			if(line.contains("push_front")) {
				String[] lines = line.split(" ");
				deque.push_front(Integer.parseInt(lines[1]));
				continue;
			}else if(line.contains("push_back")) {
				String[] lines = line.split(" ");
				deque.push_back(Integer.parseInt(lines[1]));
				continue;
			}
			
			if(line.equals("front")) {
				res = deque.front();
				sb.append(res).append("\n");
			}else if(line.equals("back")) {
				res = deque.back();
				sb.append(res).append("\n");
			}else if(line.equals("size")) {
				res = deque.size();
				sb.append(res).append("\n");
			}else if(line.equals("empty")) {
				if(deque.empty()) sb.append("1\n");
				else sb.append("0\n");
			}else if(line.equals("pop_front")) {
				res = deque.pop_front();
				sb.append(res).append("\n");
			}else if(line.equals("pop_back")) {
				res = deque.pop_back();
				sb.append(res).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	
	static class Deque{
		static List<Integer> queue = new ArrayList<>();
		
		static void push_front(int x) {
			queue.add(0, x);
		}
		
		static void push_back(int x) {
			queue.add(x);
		}
		
		static int pop_front() {
			if(empty()) return -1;
			int result = queue.remove(0);
			return result;
		}
		
		static int pop_back() {
			if(empty()) return -1;
			int result = queue.remove(size() - 1);
			return result;
		}
		
		static int size() {
			return queue.size();
		}
		
		static boolean empty() {
			if(size() == 0) return true;
			else return false;
		}
		
		static int front() {
			if(empty()) return -1;
			int result = queue.get(0);
			return result;
		}
		
		static int back() {
			if(empty()) return -1;
			int result = queue.get(size() - 1);
			return result;
		}
	}
}
