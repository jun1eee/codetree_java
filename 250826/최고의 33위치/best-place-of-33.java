import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n-3; i++) {
            for (int j = 0; j <= n-3; j++) {
                int sum = 0;
                for(int k = i; k < i+3; k++) {
                    for(int l = j; l< j+3; l++){
                        sum+=grid[k][l];
                        max = Math.max(max, sum);
                    }
                }
            }
        }
        System.out.println(max);
    }
}