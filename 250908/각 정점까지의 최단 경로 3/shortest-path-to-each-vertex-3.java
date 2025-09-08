import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int index, dist;               // index: 도착 정점, dist: 간선 가중치(그래프에 저장할 때), 또는 최단거리(우선순위큐에서 사용X)
        Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }

    static class Element implements Comparable<Element> {
        int dist, index;               // dist: 시작점으로부터의 현재까지 최단 후보거리, index: 정점 번호
        Element(int dist, int index) {
            this.dist = dist;
            this.index = index;
        }
        @Override
        public int compareTo(Element o) {
            return this.dist - o.dist; // 오름차순
        }
    }

    static final int INF = (int)1e9;

    // 인접리스트, 우선순위큐, 최단거리배열 (네이밍 통일)
    static List<Node>[] graph;
    static PriorityQueue<Element> pq = new PriorityQueue<>();
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph[x].add(new Node(y, z));        // 단방향 x -> y (가중치 z)
        }

        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        // 시작 정점: 1
        dist[1] = 0;
        pq.add(new Element(0, 1));

        // 다익스트라 (lazy 삭제 방식)
        while (!pq.isEmpty()) {
            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            // 이미 더 짧은 경로로 방문된 기록이 있으면 스킵
            if (minDist != dist[minIndex]) continue;

            // 인접 정점 완화
            for (Node nxt : graph[minIndex]) {
                int targetIndex = nxt.index;
                int weight = nxt.dist;                 // 간선 가중치
                int newDist = dist[minIndex] + weight;

                if (dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(newDist, targetIndex));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int v = 2; v <= N; v++) {
            sb.append(dist[v] >= INF ? -1 : dist[v]).append('\n');
        }
        System.out.print(sb.toString());
    }
}
