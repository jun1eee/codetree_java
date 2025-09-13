import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, -1, 1};
    static int[] dy = {-1, 1, 1, -1};
    static int[] kx = {1, 2};
    static int[] ky = {2, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n+1][n+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] start = new int[2];
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());
        int[] end = new int[2];
        end[0] = Integer.parseInt(st.nextToken());
        end[1] = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int count = current[2];

            if (currentX == end[0] && currentY == end[1]) {
                System.out.println(count);
            }

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    int nextX = currentX + kx[i] * dx[j];
                    int nextY = currentY + ky[i] * dy[j];

                    if (nextX < 1 || nextX > n || nextY < 1 || nextY > n || visited[nextX][nextY]) {
                        continue;
                    }

                    queue.add(new int[] {nextX, nextY, count+1});
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}
