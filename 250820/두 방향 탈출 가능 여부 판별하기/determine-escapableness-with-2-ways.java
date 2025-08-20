import java.util.*;
public class Main {
    static int n, m;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {1,0};
    static int[] dy = {0,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        visited = new boolean[n][m];

        System.out.println(dfs(0, 0) ? 1 : 0);
    }

    public static boolean dfs(int x, int y){
        if (x == n-1 && y == m-1){
            return true;
        }

        visited[x][y] = true;

        for (int i = 0; i < 2; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx,ny) && !visited[nx][ny] && grid[nx][ny]==1){
                if (dfs(nx,ny)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValid(int x, int y){
        return x>=0 && y>=0 && x<n && y<m;
    }
}