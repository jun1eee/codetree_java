import java.util.Scanner;
class Person{
    char cName;
    int score;

    public Person(char cName, int score){
        this.cName = cName;
        this.score = score;
    }
}
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person[] people = new Person[5];

        for (int i = 0; i < 5; i++){
            char cName = sc.next().charAt(0);
            int score = sc.nextInt();
            people[i] = new Person(cName, score);
        }

        int minIndex = 0;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<5; i++){
            if (people[i].score < min){
                min = people[i].score;
                minIndex = i;
            }
        }
        System.out.println(people[minIndex].cName + " " + people[minIndex].score);
    }
}