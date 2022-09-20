package programmers;

class Solution_파괴되지않은건물 {
	public int solution(int[][] board, int[][] skill) {
		int count = 0;
		int row = board.length;
		int col = board[0].length;
		int[][] map = new int[row + 1][col + 1];

		for (int i = 0; i < skill.length; i++) {
			int oper = skill[i][0];
			int degree = skill[i][5];

			if (oper == 1)
				degree = -degree;
			// 누적합을 위한 값 누적
			map[skill[i][1]][skill[i][2]] += degree;
			map[skill[i][1]][skill[i][4] + 1] -= degree;
			map[skill[i][3] + 1][skill[i][2]] -= degree;
			map[skill[i][3] + 1][skill[i][4] + 1] += degree;
		}

		// 가로 누적합
		for (int i = 0; i < row + 1; i++) {
			for (int j = 1; j < col + 1; j++) {
				map[i][j] += map[i][j - 1];
			}
		}

		// 세로 누적합
		for (int i = 0; i < col + 1; i++) {
			for (int j = 1; j < row + 1; j++) {
				map[j][i] += map[j - 1][i];
			}
		}

		// 카운팅
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] += map[i][j];
				if (board[i][j] > 0)
					count++;
			}
		}

		return count;
	}
}