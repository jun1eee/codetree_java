import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		visited = new boolean[N+1];

		dfs(1);

	}

	static void dfs(int n) {
		StringBuilder sb = new StringBuilder();
		if (n == N + 1) {
			for (int i = 1; i <= N; i++) {
				sb.append(arr[i]).append(" ");
			}
			System.out.println(sb);
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			arr[n] = i;
			dfs(n+1);
			visited[i] = false;
		}
	}
}
