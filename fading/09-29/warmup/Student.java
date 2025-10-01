public class Student {
    private String name;
    public Student(String name) {
        this.name = name;
    }

    public Student() {
        this.name = "none";
    }

    public void printName() {
        System.out.println(this.name);
    }

    public void printName(int age) {
        System.out.println(this.name + " is " + age + " years old.");
    }
}
