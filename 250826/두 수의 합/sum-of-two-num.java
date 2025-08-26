import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		long[] arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		long cnt = 0;
		HashMap<Long, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			long need = K - arr[i];
			if (map.containsKey(need)) {
				cnt += map.get(need);
			}
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		
		System.out.println(cnt);
		
	}
}
