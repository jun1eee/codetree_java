import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int sum = (A-11)*24*60 + (B-1)*60 + C - 10*60 -11;
        System.out.println(sum);
        // Please write your code here.
    }
}