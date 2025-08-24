import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); // 일
        int B = sc.nextInt(); // 시
        int C = sc.nextInt(); // 분

        // 기준 시각: 11일 11시 11분을 "분"으로 환산
        int base = (11 - 11) * 24 * 60 + 11 * 60 + 11;

        // 목표 시각: A일 B시 C분을 "분"으로 환산
        int target = (A - 11) * 24 * 60 + B * 60 + C;

        int diff = target - base;
        if (diff < 0) System.out.println(-1);
        else System.out.println(diff);
    }
}
