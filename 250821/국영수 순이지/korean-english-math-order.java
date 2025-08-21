import java.util.*;
class Student {
    String name;
    int korean;
    int english;
    int math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        int[] korean = new int[n];
        int[] english = new int[n];
        int[] math = new int[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            korean[i] = sc.nextInt();
            english[i] = sc.nextInt();
            math[i] = sc.nextInt();
        }
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            students[i] = new Student(names[i],korean[i],english[i],math[i]);
        }
        Arrays.sort(students,
        	    Comparator.comparingInt((Student s) -> s.korean).reversed()
        	              .thenComparing(Comparator.comparingInt((Student s) -> s.english).reversed())
        	              .thenComparing(Comparator.comparingInt((Student s) -> s.math).reversed())
        );

        
        for (int i = 0; i < n; i++) {
        	System.out.println(students[i].name + " " + students[i].korean + " " + students[i].english + " " + students[i].math);
			
		}
    }
}