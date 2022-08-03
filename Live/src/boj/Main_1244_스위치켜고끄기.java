package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1244_스위치켜고끄기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());

		int[] buttons = new int[num + 1]; // 인덱스와 번호 같게끔 통일
		String[] line = br.readLine().split(" ");
		for (int i = 1; i <= num; i++) {
			if (line[i - 1].equals("0"))
				buttons[i] = 0;
			else
				buttons[i] = 1;
		}
		int num2 = Integer.parseInt(br.readLine());
		int button, gender;

		for (int i = 0; i < num2; i++) {
			String[] info = br.readLine().split(" ");
			gender = Integer.parseInt(info[0]); // 1 남자 / 2 여자
			button = Integer.parseInt(info[1]); // 1 ~ num

			if (gender == 1) {
				// 남학생
				int dup = button;
				while (dup <= num) {
					// 배수에 해당하는 버튼들 결과 뒤집기
					if (buttons[dup] == 1)
						buttons[dup] = 0;
					else
						buttons[dup] = 1;
					dup += button; // 배수로 늘림
				}
			} else {
				// 여학생
				int minus = button - 1;
				int plus = button + 1;
				while (minus >= 1 && plus <= num) {
					if (buttons[minus] == buttons[plus]) {
						// 양쪽이 같으면 뒤집기!
						if (buttons[minus] == 1)
							buttons[minus] = buttons[plus] = 0;
						else
							buttons[minus] = buttons[plus] = 1;
						minus--;
						plus++;
					} else {
						break;
					}
				}

				// 여학생 - 무조건 본인은 뒤집어야함!
				if (buttons[button] == 1)
					buttons[button] = 0;
				else
					buttons[button] = 1;
			}
		}
		for (int i = 1; i <= num; i++) {
			sb.append(buttons[i]).append(" ");
			if (i % 20 == 0)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}