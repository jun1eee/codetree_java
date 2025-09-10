import java.io.*;
import java.util.*;

public class Main {
	static int N, M, cnt;
	static int[][] map;
	static boolean[][] visited;
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				max = Math.max(max, map[i][j]);
			}
		}
		int bestK = 0, bestCnt = 0;
		for (int k = 0; k <= max; k++) {   // ★ 0부터 시작
    		cnt = 0;
    		visited = new boolean[N][M];
   			for (int i = 0; i < N; i++) {
        		for (int j = 0; j < M; j++) {
            		if (map[i][j] > k && !visited[i][j]) {
                		visited[i][j] = true;
                		cnt++;
                		dfs(i, j, k);
            		}
        		}
    		}
    		if (cnt > bestCnt || (cnt == bestCnt && k > bestK)) {
     		    bestCnt = cnt;
        		bestK = k;
    		}
		}

		sb.append(bestK).append(" ").append(bestCnt);
		System.out.println(sb.toString());
	}

	private static void dfs(int r, int c, int k) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			if (map[nr][nc] > k && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr,nc,k);
			}
		}
	}
}