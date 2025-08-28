import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] edges;
	static int[] indegree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edges = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			edges[i] = new ArrayList<>();
		}
		indegree = new int[N + 1];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			edges[A].add(B);
			indegree[B]++;
		}

		topologySort();
	}

	public static void topologySort() {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i < N + 1; i++) {
			if(indegree[i] == 0) q.add(i);
		}	
		while(!q.isEmpty()) {
			int x = q.poll();
			sb.append(x).append(" ");
			
			for (int i = 0; i < edges[x].size(); i++) {
				int y = edges[x].get(i);
				indegree[y]--;
				if (indegree[y] == 0) q.add(y);
			}
			
		}
		System.out.println(sb);
	}
}
