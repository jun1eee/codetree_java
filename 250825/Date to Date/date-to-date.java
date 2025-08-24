import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        
        int[] days = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        int days1 = d1;
        int days2 = d2;
        for (int i = 1; i < m1; i++) {
            days1 += days[i];
        }
        for (int i = 1; i < m2; i++) {
            days2 += days[i];
        }

        System.out.println(days2-days1+1);
        
    }
}