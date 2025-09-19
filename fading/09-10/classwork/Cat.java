public class Cat {

    private String name = "Cato";

    private void drawMe() {
        System.out.println(" /\\_/\\");
        System.out.println("( o.o )");
        System.out.println(" > ^ <");   
    }

    private void speak() {
        System.out.println("Meow!");
    }

    public void myInfo() {
        System.out.println("Name: " + name);
        drawMe();
        speak();
    }
    
}
