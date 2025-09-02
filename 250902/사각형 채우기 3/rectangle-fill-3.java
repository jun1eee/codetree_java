import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 0) { System.out.println(1); return; }
        if (n == 1) { System.out.println(2); return; }
        if (n == 2) { System.out.println(7); return; }

        long[] f = new long[n + 1];
        long[] S = new long[n + 1]; // S[i] = f[i] + f[i-1] + ... + f[0] (여기선 f[n-3]까지 쓸 예정)

        f[0] = 1;
        f[1] = 2;
        f[2] = 7;

        S[0] = f[0];
        S[1] = (S[0] + f[1]) % MOD;
        S[2] = (S[1] + f[2]) % MOD;

        for (int i = 3; i <= n; i++) {
            // f[i] = 2*f[i-1] + 3*f[i-2] + 2*(f[i-3] + ... + f[0])
            long tailSum = S[i - 3];               // f[i-3] + ... + f[0]
            f[i] = (2*f[i-1] + 3*f[i-2] + 2*tailSum) % MOD;

            S[i] = (S[i - 1] + f[i]) % MOD;        // 누적합 갱신
        }

        System.out.println(f[n] % MOD);
    }
}
