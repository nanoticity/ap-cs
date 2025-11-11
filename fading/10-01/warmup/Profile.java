public class Profile {
    private String name;
    private int age;

    public Profile(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Profile() {
        this.name = "blank";
        this.age = 0;
    }

    public void printInfo() {
        System.out.println("Name: " + this.name + ", Age: " + this.age);
    }
}
