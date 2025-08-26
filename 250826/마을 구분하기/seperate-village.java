import java.io.*;
import java.util.*;

public class Main {
	static int N;
    static int[][] grid;
    static boolean[][] visited;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = { 0, 0,-1, 1};

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        grid = new int[N][N];
        visited = new boolean[N][N];

        // 입력 (공백 구분)
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        List<Integer> pNum = new ArrayList<>();
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					int cnt = dfs(i,j);
					pNum.add(cnt);
				}
			}
		}
        
        Collections.sort(pNum);
        StringBuilder sb = new StringBuilder();
        sb.append(pNum.size()).append('\n');
        for (int n : pNum) {
        	sb.append(n).append('\n');
        }
        
        System.out.println(sb.toString());
	}
	
	static int dfs(int i, int j) {
		visited[i][j] = true;
		int cnt = 1;
		
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if (grid[nr][nc] == 1 && !visited[nr][nc]) {
				cnt += dfs(nr,nc);
			}
		}
		return cnt;
	}
}
