import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int end, weight;
        Node (int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static final int INF = 100_000_000;
    static List<Node>[] list;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        for (int n = 1; n <= N; n++) {
            list[n] = new ArrayList<>();
        }
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        for (int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
            list[end].add(new Node(start, weight));
        }

        dijkstra(K);

        for (int i = 1; i <= N; i++){
            if (dist[i] >= INF) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (curNode.weight != dist[cur]) continue;
            if (dist[cur] == INF) continue;

            for (Node node : list[cur]) {
                if (dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}