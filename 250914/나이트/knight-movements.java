import java.io.*;
import java.util.*;

public class Main {
	static int N, startR, startC, endR, endC;
	static boolean[][] visited;
	static int[] dr = { -1, -2, -1, -2, 1, 2, 1, 2 };
	static int[] dc = { -2, -1, 2, 1, -2, -1, 2, 1 };

	public static class Pair {
		int r;
		int c;
		int num;

		Pair(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken()) - 1;
		startC = Integer.parseInt(st.nextToken()) - 1;
		endR = Integer.parseInt(st.nextToken()) - 1;
		endC = Integer.parseInt(st.nextToken()) - 1;
		visited = new boolean[N][N];
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(startR, startC, 0));
		visited[startR][startC] = true;
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			if (cur.r == endR && cur.c == endC) return cur.num;
			for (int i = 0; i < 8; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if (visited[nr][nc]) continue;
				visited[nr][nc] = true;
				q.add(new Pair(nr, nc, cur.num + 1));
			}
		}
		return -1;
	}
}