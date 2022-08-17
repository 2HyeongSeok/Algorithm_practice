package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] form = br.readLine().toCharArray();
		String value = "";
		int num = 0;
		Deque<Integer> numStack = new ArrayDeque<>();
		Deque<Character> operStack = new ArrayDeque<>();
		
		for(int i = 0,size = form.length; i < size; i++) {
			if(form[i] == '-') {
				// - 부호가 들어오면 지금까지 더한 num 숫자와 -부호를 스택에 각각 저장하기
				if(!value.equals("")) num += Integer.parseInt(value);
				numStack.offer(num);
				operStack.offer(form[i]);
				
				// 초기화
				value = "";
				num = 0;
			}else if(form[i] == '+') {
				// + 부호가 들어오면 스택에 넣지않고 바로 num에 이전까지 숫자 더해주기
				num += Integer.parseInt(value);
				
				// 초기화
				value = "";
			}else if(form[i] - '0' >= 0 && form[i] - '0' <= 9){
				// 숫자면 String으로 계속 이어붙임 -> 나중에 int형으로 바꾸기 위함
				value += form[i];
			}
		}
		// 엔터 입력 시 나머지 연산 처리해서 스택에 넣어주기
		num += Integer.parseInt(value);
		numStack.offer(num);

		while(numStack.size() > 1) {
			int numFront = numStack.poll();
			int numBack = numStack.poll();
			operStack.poll();
			
			// 담겨있는 연산 부호는 -뿐이므로 연산한 뒤 다시 제일 앞에 넣어줌
			// 앞에서부터 계산해야 하기 때문
			numStack.offerFirst(numFront - numBack);
		}
		
		System.out.println(numStack.poll());
	}
}
