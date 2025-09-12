import java.util.*;

public class Main {
    static int N;
    static long cnt;

    static void f(int len) {
        if (len == N) { cnt++; return; }
        for (int step = 1; step <= 4; step++) {
            if (len + step <= N) f(len + step);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        f(0);
        System.out.println(cnt);
    }
}
