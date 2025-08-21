import java.util.Scanner;

class Person {
    String sCode;
    char mPoint;
    int time;
    public Person(String sCode, char mPoint, int time){
        this.sCode = sCode;
        this.mPoint = mPoint;
        this.time = time;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sCode = sc.next();
        char mPoint = sc.next().charAt(0);
        int time = sc.nextInt();
        
        Person person1 = new Person(sCode, mPoint, time);

        System.out.println("secret code : " + person1.sCode);
        System.out.println("meeting point : " + person1.mPoint);
        System.out.println("time : " +person1.time);
    }
}