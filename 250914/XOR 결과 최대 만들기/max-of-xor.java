import java.io.*;
import java.util.*;

public class Main {
	static int N, M, ans;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0, 0);

		System.out.print(ans);
	}

	static void dfs(int idx, int cnt, int x) {
		if (idx == N) {
			if (cnt == M)
				ans = Math.max(ans, x);
			return;
		}

		if (cnt < M) {
			dfs(idx + 1, cnt + 1, x ^ arr[idx]);
			dfs(idx + 1, cnt, x);
		}
	}
}
