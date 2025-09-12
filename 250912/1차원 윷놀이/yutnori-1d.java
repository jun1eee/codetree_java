import java.util.*;
import java.io.*;

public class Main {

	private static int N, M, K, cntMax;
	private static int[] arrN, arr; // 순열 배열
	private static int[] moveArr; // 말위치 배열
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 턴 수
		M = Integer.parseInt(st.nextToken()); // 윳놀이 판 상태
		K = Integer.parseInt(st.nextToken()); // 말 수

		arrN = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}

		arr = new int[N]; // 순열 배열
		f(0);
		System.out.println(answer);
	}

	private static void f(int cnt) {
		if (cnt == N) {
			calculate();
			return;
		}

		for (int i = 0; i < K; i++) {
			arr[cnt] = i;
			f(cnt + 1);
		}
	}

	private static void calculate() {
		int score = 0;
		moveArr = new int[K + 1];
		
		for (int i = 0; i < N; i++) {
			moveArr[arr[i]] += arrN[i];
		}
		
		for (int i = 1; i <= K; i++) {
			if(moveArr[i] >= M-1) {
				score++;
			}
			
		}
		answer = Math.max(answer, score);
	}
}