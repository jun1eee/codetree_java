import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String cmd = sc.next();

            switch (cmd) {
                case "push_front":
                    dq.addFirst(sc.nextInt());
                    break;

                case "push_back":
                    dq.addLast(sc.nextInt());
                    break;

                case "pop_front":
                    System.out.println(dq.isEmpty() ? -1 : dq.pollFirst());
                    break;

                case "pop_back":
                    System.out.println(dq.isEmpty() ? -1 : dq.pollLast());
                    break;

                case "size":
                    System.out.println(dq.size());
                    break;

                case "empty":
                    System.out.println(dq.isEmpty() ? 1 : 0);
                    break; // ★ 반드시 필요

                case "front":
                    System.out.println(dq.isEmpty() ? -1 : dq.peekFirst());
                    break;

                case "back":
                    System.out.println(dq.isEmpty() ? -1 : dq.peekLast());
                    break;
            }
        }
        sc.close();
    }
}
