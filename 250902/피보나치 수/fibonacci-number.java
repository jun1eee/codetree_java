import java.util.Scanner;
public class Main {
    static int[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new int[n+1];
        for (int i = 1; i <= n; i++){
            memo[i] = -1;
        }
        System.out.println(Fibbo(n));
    }
    public static int Fibbo(int n){
        if (memo[n] != -1) return memo[n];
        if (n <= 2) memo[n] = 1;
        else {
            memo[n] = Fibbo(n-1) + Fibbo(n-2);
        }
        return memo[n];
    }
}