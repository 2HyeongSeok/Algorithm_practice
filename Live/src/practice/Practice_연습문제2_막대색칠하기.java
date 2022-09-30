package practice;

public class Practice_연습문제2_막대색칠하기 {
	public static void main(String[] args) {
		int[] dp = new int[7];
		dp[1] = 2;
		dp[2] = 5;
		
		for(int i = 3; i <= 6; i++) {
			// dp[i-1] x 2의 이유 : 길이 하나 짧은거에 파란색 or 노란색
			// dp[i-2]의 이유 : 길이 두개 짧은거에 빨간색 (파파 노노 노파 파노) => 이미 dp[i-1]에서 계산
			dp[i] = 2 * dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[6]);
	}
}
