import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();

        int[] a = new int[2 * N];
        // 위 줄 N개
        for (int i = 0; i < N; i++) a[i] = sc.nextInt();
        // 아래 줄 N개
        for (int i = 0; i < N; i++) a[N + i] = sc.nextInt();

        int len = 2 * N;
        int shift = T % len;              // 오른쪽 회전 칸수
        int[] b = new int[len];

        // 오른쪽으로 shift만큼 회전
        // b[i] = a[(i - shift + len) % len]
        for (int i = 0; i < len; i++) {
            int from = i - shift;
            if (from < 0) from += len;
            b[i] = a[from];
        }

        StringBuilder sb = new StringBuilder();
        // 위 줄
        for (int i = 0; i < N; i++) {
            if (i > 0) sb.append(' ');
            sb.append(b[i]);
        }
        sb.append('\n');
        // 아래 줄
        for (int i = 0; i < N; i++) {
            if (i > 0) sb.append(' ');
            sb.append(b[N + i]);
        }
        System.out.print(sb.toString());
    }
}
