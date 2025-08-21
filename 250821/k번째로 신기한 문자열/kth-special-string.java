import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();

        List<String> list = new ArrayList<>(); 
        int m = 0; // 매칭된 단어 수

        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            if (temp.startsWith(t)) {
                list.add(temp);   
            }
        }
        Collections.sort(list);
        System.out.println(list.get(k-1));
    }
}
