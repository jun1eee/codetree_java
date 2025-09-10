import java.io.*;
import java.util.*;

public class Main {
    static int N, M, cnt;
    static int[][] map;
    static boolean[][] visited;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        int bestK = 1, bestCnt = 0;   // ★ K는 최소 1부터 시작
        for (int k = 1; k <= max; k++) {
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
            // ★ 동률일 경우 더 작은 k 유지
            if (cnt > bestCnt) {
                bestCnt = cnt;
                bestK = k;
            }
        }

        System.out.println(bestK + " " + bestCnt);
    }

    private static void dfs(int r, int c, int k) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if (map[nr][nc] > k && !visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc, k);
            }
        }
    }
}
