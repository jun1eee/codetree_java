import java.io.*;
import java.util.*;

public class Main {
	private static int N, K, cnt;
	private static int[][] map;
	private static boolean[][] visited;
	private static Queue<Pair> q;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static class Pair {
		int r, c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		visited = new boolean[N][N];
		q = new ArrayDeque<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			q.offer(new Pair(r, c));
			visited[r][c] = true;
			cnt++;
		}
		bfs();
		System.out.println(cnt);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if (map[nr][nc] == 0 && !visited[nr][nc]) {
					cnt++;
					visited[nr][nc] = true;
					q.offer(new Pair(nr, nc));
				}
			}
		}
	}
}