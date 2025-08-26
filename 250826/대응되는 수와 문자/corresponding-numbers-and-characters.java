import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] numToStr = new String[N+1];
		HashMap<String, Integer> strToNum = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			numToStr[i] = str;
			strToNum.put(str, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String q = br.readLine();
			
			if(Character.isDigit(q.charAt(0))) {
				int idx = Integer.parseInt(q);
				sb.append(numToStr[idx]).append('\n');
			} else {
				sb.append(strToNum.get(q)).append('\n');
			}
		}
		System.out.println(sb);
	}
}
