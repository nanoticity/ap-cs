public class Animal {
    private String animalType;
    private int age;

    public Animal(String animalType, int age) {
        this.animalType = animalType;
        this.age = age;
    }

    public Animal() {
        this.animalType = "blank";
        this.age = 0;
    }

    public void printInfo() {
        System.out.println("Animal type: " + animalType);
        System.out.println("Age: " + age);
    }
}
