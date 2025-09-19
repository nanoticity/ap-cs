public class Runner {
    
    public static void main(String[] args) {
        Dog dog = new Dog();
        Student student = new Student();
        Toy toy = new Toy();

        System.out.println("Dog:");
        dog.speak();
        dog.sayname();
        System.out.println("\nStudent:");
        student.speak();
        student.sayID();
        System.out.println("\nToy:");
        toy.type();
        toy.maker();
        toy.price();
    }
}
