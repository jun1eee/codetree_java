import java.util.*;

public class Main {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();  // 1 ~ K
        N = sc.nextInt();  // 길이 N
        arr = new int[N];

        dfs(0);
    }

    // 깊이 우선 탐색으로 수열 만들기
    static void dfs(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= K; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
    }
}
