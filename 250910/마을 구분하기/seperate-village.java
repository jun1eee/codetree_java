import java.io.*;
import java.util.*;

public class Main {
	static int N, peopleNum;
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> peopleNums = new ArrayList<>();
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					peopleNum = 1;
					dfs(i, j);
					peopleNums.add(peopleNum);
				}
			}
		}
		Collections.sort(peopleNums);
		sb.append(peopleNums.size()).append('\n');
		for (int n : peopleNums) {
			sb.append(n).append('\n');
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int r, int c) {
		for (int index = 0; index < 4; index++) {
			int nr = r + dr[index];
			int nc = c + dc[index];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;
			if (map[nr][nc] == 1 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				peopleNum++;
				dfs(nr, nc);
			}
		}
	}
}
