import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Student s1 = new Student("Henry", 34);
        Student s2 = new Student("Jose", 21);
        Student s3 = new Student("Carla", 21);
        Student s4 = new Student("Nancy", 19);

        ArrayList<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        int totalAge = 0;
        for (Student s : students) {
            totalAge += s.getAge();
        }
        System.out.println("Total age: " + totalAge);

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAge() == 21) {
                students.remove(i);
                i--;
            }
        }

        System.out.println("Students after removal:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
