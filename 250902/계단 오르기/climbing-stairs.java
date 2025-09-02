import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int MOD = 10007;

        if (n == 2) {
            System.out.println(1);
            return;
        }
        if (n == 3) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[n+1];
        dp[2] = 1; // 2층 가는 방법: (2)
        dp[3] = 1; // 3층 가는 방법: (3)

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i-3]) % MOD;
        }

        System.out.println(dp[n]);
    }
}
