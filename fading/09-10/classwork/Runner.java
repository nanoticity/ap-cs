public class Runner {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Bird bird = new Bird();

        dog.myInfo();
        System.out.println();
        cat.myInfo();
        System.out.println();
        bird.myInfo();
    }
}
