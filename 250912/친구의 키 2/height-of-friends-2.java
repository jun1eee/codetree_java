import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] edges;
    static int[] indegree;
	private static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++){
            edges[i] = new ArrayList<>();
        }
        indegree = new int[n+1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            edges[a].add(b);
            indegree[b]++;
        }

        System.out.println(topologySort() ? "Consistent" : "Inconsistent");
    }

    private static boolean topologySort() {
    	Queue<Integer> q = new ArrayDeque<>();
    	
    	for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) q.add(i);
		}
    	int processed = 0;
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		processed++;
    		
    		for (int e : edges[cur]) {
    			indegree[e]--;
    			if (indegree[e] == 0) {
    				q.add(e);
    			}
    		}
    	}
    	
    	return processed == n;
	}
}