import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[M + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= M; i++) {
			for (int coin : coins) {
				if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}
		System.out.println(dp[M]);
	}
}
