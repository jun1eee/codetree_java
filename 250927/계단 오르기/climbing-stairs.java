import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 1;
		if (N <= 4) {
			System.out.println(dp[N]);
		} else {
			for (int i = 5; i <= N; i++) {
				dp[i] = dp[i-2] + dp[i-3] % 10007;
			}
			System.out.println(dp[N]);
		}
	}
}
