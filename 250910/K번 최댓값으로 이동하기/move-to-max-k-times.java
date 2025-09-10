import java.io.*;
import java.util.*;

public class Main {
    private static int N, K;
    private static int[][] map;
    private static int[] ans = new int[2];
    private static boolean[][] visited;
    private static Queue<Pair> q;
    private static int[] dr = { -1, 1, 0, 0 };
    private static int[] dc = { 0, 0, -1, 1 };

    public static class Pair {
        int r, c;
        Pair(int r, int c) { this.r = r; this.c = c; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        ans[0] = Integer.parseInt(st.nextToken()) - 1;
        ans[1] = Integer.parseInt(st.nextToken()) - 1;

        visited = new boolean[N][N];
        q = new ArrayDeque<>();
        q.offer(new Pair(ans[0], ans[1]));
        visited[ans[0]][ans[1]] = true;

        for (int i = 0; i < K; i++) bfs();

        System.out.println((ans[0] + 1) + " " + (ans[1] + 1));
    }

    private static void bfs() {
        // ★ 최소 변경: 단계마다 큐/visited를 새로 시작점으로 초기화
        visited = new boolean[N][N];
        q = new ArrayDeque<>();
        q.offer(new Pair(ans[0], ans[1]));
        visited[ans[0]][ans[1]] = true;

        Pair maxNode = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        int maxValue = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int r = cur.r, c = cur.c;

            // 후보 갱신: 반드시 현재 위치 값보다 작은 칸만 고려
            if (maxValue < map[r][c] && map[ans[0]][ans[1]] > map[r][c]) {
                maxValue = map[r][c];
                maxNode.r = r; maxNode.c = c;
            } else if (maxValue == map[r][c] && map[ans[0]][ans[1]] > map[r][c]) { // ★ 조건 보강
                if (maxNode.r > r || (maxNode.r == r && maxNode.c > c)) {
                    maxNode.r = r; maxNode.c = c;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (map[ans[0]][ans[1]] > map[nr][nc] && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new Pair(nr, nc));
                }
            }
        }

        if (maxValue == Integer.MIN_VALUE) return; // 이동할 곳 없으면 그대로
        ans[0] = maxNode.r; ans[1] = maxNode.c;    // 다음 단계 시작점으로 이동
    }
}
