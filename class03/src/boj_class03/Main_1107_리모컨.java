package boj_class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1107_리모컨 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String target = br.readLine(); // 이동하려는 채널
		int targetNum = Integer.parseInt(target);

		int M = Integer.parseInt(br.readLine()); // 고장난 버튼 수

		if (M == 0) {
			int min = target.length() < Math.abs(targetNum - 100) ? target.length() : Math.abs(targetNum - 100);
			System.out.println(min);
			return;
		}

		String broken = br.readLine(); // 고장난 채널들(번호 String)

		if (M == 10) {
			System.out.println(Math.abs(targetNum - 100));
			return;
		}
		
		if (targetNum == 100) {
			System.out.println(0);
			return;
		}

		int onlyUpDown = Math.abs(targetNum - 100);
		
		// 이동하려는 채널보다 작은 쪽
		int minNum = 1000001, minToUp = 0, len = 0;
		for(int i = targetNum; i >= 0; i--) {
			String tempI = Integer.toString(i);
			boolean findFlag = false;
			for(int j = 0; j < tempI.length(); j++) {
				if(broken.contains(Character.toString(tempI.charAt(j)))) break;
				
				if(j == tempI.length() - 1) 
					findFlag = true;
			}
			
			if(findFlag) {
				minNum = Integer.parseInt(tempI);
				len = tempI.length();
				break;
			}
		}
		minToUp = Math.abs(minNum - targetNum) + len;

		// 이동하려는 채널보다 큰 쪽
		int maxNum = 1000001, maxToDown;
		for(int i = targetNum; i <= 1000000; i++) {
			String tempI = Integer.toString(i);
			boolean findFlag = false;
			for(int j = 0; j < tempI.length(); j++) {
				if(broken.contains(Character.toString(tempI.charAt(j)))) break;
				
				if(j == tempI.length() - 1) 
					findFlag = true;
			}
			
			if(findFlag) {
				maxNum = Integer.parseInt(tempI);
				len = tempI.length();
				break;
			}
		}
		maxToDown = Math.abs(maxNum - targetNum) + len;
		
		if(maxToDown >= minToUp && onlyUpDown >= minToUp) System.out.println(minToUp);
		else if(maxToDown >= onlyUpDown && minToUp >= onlyUpDown) System.out.println(onlyUpDown);
		else System.out.println(maxToDown);
	}
}
