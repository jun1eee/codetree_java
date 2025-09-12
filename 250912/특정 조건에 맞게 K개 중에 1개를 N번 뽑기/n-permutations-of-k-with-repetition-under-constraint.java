import java.util.*;
import java.io.*;

public class Main {
	public static int K, N;
	public static List<Integer> list;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		
		f(0);
		System.out.print(sb.toString());
	}
	private static void f(int n) {
		if (n == N) {
			for (int l : list) {
				sb.append(l).append(" ");
			}
			sb.append('\n');
			return;
		}
		for (int i = 1; i <= K; i++) {
			if (n >=2 && list.get(list.size()-1) == i && list.get(list.size()-2) == i) continue;
			list.add(i);
			f(n+1);
			list.remove(list.size()-1);
		}
	}
}