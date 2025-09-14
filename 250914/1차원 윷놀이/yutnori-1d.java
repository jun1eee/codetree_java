import java.util.*;
import java.io.*;

public class Main {
	public static int N, M, K, ans;
	public static int[] nums;
	public static int[] pieces;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		pieces = new int[K];
		for (int i = 0; i < K; i++) {
			pieces[i] = 1;
		}

		dfs(0);
		System.out.print(ans);
	}

	private static void dfs(int n) {
		if (n == N) {
			int cnt = 0;
			for (int i = 0; i < K; i++) {
				if (pieces[i] >= M)
					cnt++;
			}
			ans = Math.max(ans, cnt);
            return;
		}
		
		for (int i = 0; i < K; i++) {
			
			pieces[i] += nums[n];
			dfs(n+1);
			pieces[i] -= nums[n];
		}
	}
}