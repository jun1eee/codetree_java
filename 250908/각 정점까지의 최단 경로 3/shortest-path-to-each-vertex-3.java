import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }
    static class Node implements Comparable<Node> {
        int v, d;
        Node(int v, int d) { this.v = v; this.d = d; }
        public int compareTo(Node o) { return Integer.compare(this.d, o.d); }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g[a].add(new Edge(b, w)); // 단방향
        }

        final int INF = 1_000_000_000;
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.v]) continue;
            visited[cur.v] = true;

            for (Edge e : g[cur.v]) {
                if (dist[e.to] > cur.d + e.w) {
                    dist[e.to] = cur.d + e.w;
                    pq.offer(new Node(e.to, dist[e.to]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int v = 2; v <= N; v++) {
            sb.append(dist[v] == INF ? -1 : dist[v]).append('\n');
        }
        System.out.print(sb);
    }
}
