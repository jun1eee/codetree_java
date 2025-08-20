import java.util.*;
public class Main {
    public static List<Integer>[] g;
    public static boolean[] visited;
    public static int cnt = 0;

    public static void dfs(int n){
        for (int num : g[n]){
            if (!visited[num]){
                visited[num] = true;
                cnt++;
                dfs(num);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] u = new int[m];
        int[] v = new int[m];
        for (int i = 0; i < m; i++) {
            u[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        g = new ArrayList[n+1];
        for (int i = 1; i <= n; i++){
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++){
            g[u[i]].add(v[i]);
            g[v[i]].add(u[i]);
        }

        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1);

        System.out.println(cnt);
        
    }
}