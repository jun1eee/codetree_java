import java.util.*;
class Person {
    String name;
    int height;
    int weight;

    Person(){
        this.name = null;
        this.height = 0;
        this.weight = 0;
    }
    Person(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person[] p = new Person[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            p[i] = new Person(name, height, weight);
        }

        Arrays.sort(p, (a,b) -> Integer.compare(a.height, b.height));

        for (int i = 0; i < n; i++) {
            System.out.println(p[i].name + " " + p[i].height + " " + p[i].weight);
        }
    }
}