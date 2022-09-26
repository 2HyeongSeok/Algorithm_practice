package algo_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1991_트리순회 {
	static class Node{
		char value, left, right;
		
		public Node(char value, char left, char right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	static Map<Character, Node> map;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			char parent = st.nextToken().charAt(0);
			char lChild = st.nextToken().charAt(0);
			char rChild = st.nextToken().charAt(0);
			
			map.put(parent, new Node(parent, lChild, rChild));
		}
		
		preOrder('A');
		sb.append("\n");
		inOrder('A');
		sb.append("\n");
		postOrder('A');		
		
		System.out.println(sb);
	}
	
	static void preOrder(char value) {
		Node node = map.get(value);
		if(node != null) {
			sb.append(node.value);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	static void inOrder(char value) {
		Node node = map.get(value);
		if(node != null) {
			inOrder(node.left);
			sb.append(node.value);
			inOrder(node.right);
		}
	}
	
	static void postOrder(char value) {
		Node node = map.get(value);
		if(node != null) {
			postOrder(node.left);
			postOrder(node.right);
			sb.append(node.value);
		}
	}
}
