import java.util.Scanner;

class Person {
    String id;
    int level;

    public Person(){
        this.id = null;
        this.level = 0;
    }

    public Person(String id, int level){
        this.id = id;
        this.level = level;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int level = sc.nextInt();
        
        Person person1 = new Person();
        Person person2 = new Person(id, level);

        person1.id = "codetree";
        person1.level = 10;

        System.out.println("user " + person1.id + " lv " + person1.level);
        System.out.println("user " + person2.id + " lv " + person2.level);
    }
}