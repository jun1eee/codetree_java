import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map, dist;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static class Pair {
        int r, c;
        Pair(int r, int c) { this.r = r; this.c = c; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 1: 이동 가능, 0: 벽
            }
        }

        dist = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], -1);

        // 시작점이 막혀있으면 바로 -1
        if (map[0][0] == 0) {
            System.out.println(-1);
            return;
        }

        bfs();
        System.out.println(dist[N-1][M-1]); // 도달 못하면 -1
    }

    static void bfs() {
        Deque<Pair> q = new ArrayDeque<>();
        dist[0][0] = 0;              // 이동 횟수 기준(시작 0)
        q.offer(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int r = cur.r, c = cur.c;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] == 0 || dist[nr][nc] != -1) continue;

                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new Pair(nr, nc));
            }
        }
    }
}
