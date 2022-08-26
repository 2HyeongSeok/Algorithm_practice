package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {
	static int[][] magnets;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		magnets = new int[5][8];

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());

			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; j++) {
					magnets[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int magnet, dir, totScores = 0;

			for (int i = 0; i < K; i++) {
				visited = new boolean[5];
				st = new StringTokenizer(br.readLine(), " ");
				magnet = Integer.parseInt(st.nextToken());
				dir = Integer.parseInt(st.nextToken());
				
				turn(dir, magnet);
			}

			// 다 돈 후에 계산
			for(int k = 1; k <= 4; k++) {
				if(magnets[k][0] == 1) {
					totScores += (int)Math.pow(2, k-1); 
				}
			}
			
			sb.append("#").append(t).append(" ").append(totScores).append("\n");
		}
		
		System.out.println(sb);
	}

	static boolean isSame(int m1, int m2) {
		if (magnets[m1][6] == magnets[m2][2])
			return true;
		else
			return false;
	}

	static void turn(int dir, int magnet) {
		int temp;
		switch (magnet) {
		case 1:
			if (visited[magnet])
				break; // 이미 앞에서 돌렸다면 !!
			
			// 방문처리
			visited[magnet] = true;
			
			
			if (!isSame(magnet+1, magnet)) {
				// 돌아야함
				int newDir = -dir; // 지금 도는거의 반대 방향으로
				turn(newDir, magnet + 1);
			}

			if (dir == 1) {
				// 시계 방향
				temp = magnets[magnet][7];
				for (int k = 7; k > 0; k--)
					magnets[magnet][k] = magnets[magnet][k - 1];
				magnets[magnet][0] = temp;
			} else {
				// 반시계 방향
				temp = magnets[magnet][0];
				for (int k = 0; k < 7; k++)
					magnets[magnet][k] = magnets[magnet][k + 1];
				magnets[magnet][7] = temp;
			}
			break;
		case 2:
			if (visited[magnet])
				break; // 이미 앞에서 돌렸다면 !!
			
			// 방문처리
			visited[magnet] = true;
			
			if (!isSame(magnet+1, magnet)) {
				// 돌아야함
				int newDir = -dir; // 지금 도는거의 반대 방향으로
				turn(newDir, magnet + 1);
			} 
			if (!isSame(magnet, magnet-1)) {
				int newDir = -dir; // 지금 도는거의 반대 방향으로
				turn(newDir, magnet - 1);
			}

			if (dir == 1) {
				// 시계 방향
				temp = magnets[magnet][7];
				for (int k = 7; k > 0; k--)
					magnets[magnet][k] = magnets[magnet][k - 1];
				magnets[magnet][0] = temp;
			} else {
				// 반시계 방향
				temp = magnets[magnet][0];
				for (int k = 0; k < 7; k++)
					magnets[magnet][k] = magnets[magnet][k + 1];
				magnets[magnet][7] = temp;
			}
			break;
		case 3:
			if (visited[magnet])
				break; // 이미 앞에서 돌렸다면 !!

			// 방문처리
			visited[magnet] = true;
			
			if (!isSame(magnet+1, magnet)) {
				// 돌아야함
				int newDir = -dir; // 지금 도는거의 반대 방향으로
				turn(newDir, magnet + 1);
			}
			if (!isSame(magnet, magnet-1)) {
				int newDir = -dir; // 지금 도는거의 반대 방향으로
				turn(newDir, magnet - 1);
			}

			if (dir == 1) {
				// 시계 방향
				temp = magnets[magnet][7];
				for (int k = 7; k > 0; k--)
					magnets[magnet][k] = magnets[magnet][k - 1];
				magnets[magnet][0] = temp;
			} else {
				// 반시계 방향
				temp = magnets[magnet][0];
				for (int k = 0; k < 7; k++)
					magnets[magnet][k] = magnets[magnet][k + 1];
				magnets[magnet][7] = temp;
			}
			break;
		case 4:
			if (visited[magnet])
				break; // 이미 앞에서 돌렸다면 !!
			
			// 방문처리
			visited[magnet] = true;
			
			if (!isSame(magnet, magnet-1)) {
				// 돌아야함
				int newDir = -dir; // 지금 도는거의 반대 방향으로
				turn(newDir, magnet - 1);
			}

			if (dir == 1) {
				// 시계 방향
				temp = magnets[magnet][7];
				for (int k = 7; k > 0; k--)
					magnets[magnet][k] = magnets[magnet][k - 1];
				magnets[magnet][0] = temp;
			} else {
				// 반시계 방향
				temp = magnets[magnet][0];
				for (int k = 0; k < 7; k++)
					magnets[magnet][k] = magnets[magnet][k + 1];
				magnets[magnet][7] = temp;
			}
			break;
		}
	}
}
