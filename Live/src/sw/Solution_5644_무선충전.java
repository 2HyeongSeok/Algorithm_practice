package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {

	static class BatteryCharger {
		int x, y;
		int c;
		int p;

		public BatteryCharger(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] aMove, bMove;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");

			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());

			aMove = new int[M];
			bMove = new int[M];
			BatteryCharger[] bc = new BatteryCharger[A + 1];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				aMove[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				bMove[i] = Integer.parseInt(st.nextToken());
			}

			ArrayList<Integer>[][] ableArray = new ArrayList[11][11];
			for (int m = 1; m <= 10; m++) {
				for (int n = 1; n <= 10; n++) {
					ableArray[m][n] = new ArrayList<Integer>();
				}
			}

			for (int i = 1; i <= A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				bc[i] = new BatteryCharger(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

				for (int m = 1; m <= 10; m++) {
					for (int n = 1; n <= 10; n++) {
						if (Math.abs(bc[i].x - n) + Math.abs(bc[i].y - m) <= bc[i].c) {
							ableArray[m][n].add(i);
						}
					}
				}

			}

			int totalP = 0;

			int aRow = 1, aCol = 1, bRow = 10, bCol = 10;
			int[] moved;

			for (int i = 0; i <= M; i++) {
//				System.out.println("a : " + ableArray[aRow][aCol]);
//				System.out.println("b : " + ableArray[bRow][bCol]);
				if (ableArray[aRow][aCol].size() == 1) {
					if (ableArray[bRow][bCol].size() == 1) {
						// BC 1개씩 존재
						if (ableArray[aRow][aCol].get(0) == ableArray[bRow][bCol].get(0)) {
							// 같은 BC라면
							totalP += bc[ableArray[aRow][aCol].get(0)].p; // 1개만큼만
						} else {
							// 다른 BC라면
							totalP += bc[ableArray[aRow][aCol].get(0)].p;
							totalP += bc[ableArray[bRow][bCol].get(0)].p;
						}
					} else if (ableArray[bRow][bCol].size() > 1) {
						int maxB = 0;
						boolean sameFlag = false;
						for (int k = 0; k < ableArray[bRow][bCol].size(); k++) {
							if (ableArray[bRow][bCol].get(k) == ableArray[aRow][aCol].get(0)) {
								// 둘이 같은 BC가 있다면
								sameFlag = true;
								break;
							}
							maxB = maxB > bc[ableArray[bRow][bCol].get(k)].p ? maxB
									: bc[ableArray[bRow][bCol].get(k)].p;
							if (k == ableArray[bRow][bCol].size() - 1) {
								// 없다면
								totalP += bc[ableArray[aRow][aCol].get(0)].p; // a 더하고
								totalP += maxB; // b 더함
							}
						}
						if (sameFlag) {
							maxB = 0;
							for (int k = 0; k < ableArray[bRow][bCol].size(); k++) {
								if (ableArray[bRow][bCol].get(k) == ableArray[aRow][aCol].get(0))
									continue;
								maxB = maxB > bc[ableArray[bRow][bCol].get(k)].p ? maxB
										: bc[ableArray[bRow][bCol].get(k)].p;
							}
							totalP += bc[ableArray[aRow][aCol].get(0)].p; // a 더하고
							totalP += maxB;
						}
					} else {
						// b가 없다면
						totalP += bc[ableArray[aRow][aCol].get(0)].p;
					}
				}

				if (ableArray[bRow][bCol].size() == 1) {
					// a와 b 모두 한 개 일 때는 이미 처리함

					if (ableArray[aRow][aCol].size() > 1) {
						int maxA = 0;
						boolean sameFlag = false;
						for (int k = 0; k < ableArray[aRow][aCol].size(); k++) {
							if (ableArray[aRow][aCol].get(k) == ableArray[bRow][bCol].get(0)) {
								// 둘이 같은 BC가 있다면
								sameFlag = true;
								break;
							}
							maxA = maxA > bc[ableArray[aRow][aCol].get(k)].p ? maxA
									: bc[ableArray[aRow][aCol].get(k)].p;
							if (k == ableArray[aRow][aCol].size() - 1) {
								// 없다면
								totalP += bc[ableArray[bRow][bCol].get(0)].p; // a 더하고
								totalP += maxA; // b 더함
							}
						}
						if (sameFlag) {
							maxA = 0;
							for (int k = 0; k < ableArray[aRow][aCol].size(); k++) {
								if (ableArray[aRow][aCol].get(k) == ableArray[bRow][bCol].get(0))
									continue;
								maxA = maxA > bc[ableArray[aRow][aCol].get(k)].p ? maxA
										: bc[ableArray[aRow][aCol].get(k)].p;
							}
							totalP += bc[ableArray[bRow][bCol].get(0)].p; // b 더하고
							totalP += maxA;
						}
					} else if (ableArray[aRow][aCol].size() == 0) {
						// a가 없다면
						totalP += bc[ableArray[bRow][bCol].get(0)].p;
					}
				}

				int maxValue = 0;
				if (ableArray[aRow][aCol].size() > 1) {
					if (ableArray[bRow][bCol].size() > 1) {
						for (int m = 0; m < ableArray[aRow][aCol].size(); m++) {
							for (int n = 0; n < ableArray[bRow][bCol].size(); n++) {
								if (ableArray[aRow][aCol].get(m) == ableArray[bRow][bCol].get(n)) {
									maxValue = maxValue > bc[ableArray[aRow][aCol].get(m)].p ? maxValue
											: bc[ableArray[aRow][aCol].get(m)].p;
								}else {
									maxValue = maxValue > bc[ableArray[aRow][aCol].get(m)].p
											+ bc[ableArray[bRow][bCol].get(n)].p ? maxValue
													: bc[ableArray[aRow][aCol].get(m)].p
															+ bc[ableArray[bRow][bCol].get(n)].p;
								}
							}
						}
						totalP += maxValue;
					}else if(ableArray[bRow][bCol].size() == 0){
						for (int m = 0; m < ableArray[aRow][aCol].size(); m++) {
							maxValue = maxValue > bc[ableArray[aRow][aCol].get(m)].p ? maxValue
									: bc[ableArray[aRow][aCol].get(m)].p;
						}
						totalP += maxValue;
					}
				}
				
				if (ableArray[bRow][bCol].size() > 1) {
					if(ableArray[aRow][aCol].size() == 0){
						for (int n = 0; n < ableArray[bRow][bCol].size(); n++) {
							maxValue = maxValue > bc[ableArray[bRow][bCol].get(n)].p ? maxValue
									: bc[ableArray[bRow][bCol].get(n)].p;
						}
						totalP += maxValue;
					}
				}

//				System.out.println(totalP);

				if (i == M)
					break;
				moved = move(aMove[i], aRow, aCol);
				aRow = moved[0];
				aCol = moved[1];

				moved = move(bMove[i], bRow, bCol);
				bRow = moved[0];
				bCol = moved[1];
			}
			sb.append(totalP).append("\n");
		}

		System.out.println(sb);
	}

	static int[] move(int mode, int row, int col) {
		switch (mode) {
		case 0:
			break;
		case 1:
			row--;
			break;
		case 2:
			col++;
			break;
		case 3:
			row++;
			break;
		case 4:
			col--;
			break;
		default:
			break;
		}

		return new int[] { row, col };
	}

}
