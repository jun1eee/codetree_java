import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[N][N];
		dp[0][0] = arr[0][0];
		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.max(arr[i][0], arr[i-1][0]);
		}
		for (int j = 1; j < N; j++) {
			dp[0][j] = Math.max(arr[0][j], arr[0][j-1]);
		}
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				int up = Math.max(dp[i-1][j], arr[i][j]);
				int down = Math.max(dp[i][j-1], arr[i][j]);
				dp[i][j] = Math.min(up, down);
			}
		}
		System.out.println(dp[N-1][N-1]);
		
		
	}
}
