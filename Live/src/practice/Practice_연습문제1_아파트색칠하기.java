package practice;

public class Practice_연습문제1_아파트색칠하기 {
	public static void main(String[] args) {
		int[] dp = new int[9];
		dp[1] = 2;
		dp[2] = 3;
		
		for(int i = 3; i <= 8; i++) {
			// dp[i-1] -> 마지막 블록이 노란 블록일 때 -> 아래 아무거나 와도 됨
			// dp[i-2] -> 마지막 블록이 파란 블록일 때 -> 아래 노란블록 -> 그 아래는 아무거나 와도 됨
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[8]);
	}
}
