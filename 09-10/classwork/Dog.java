public class Dog {

    private String name = "Doggo";

    private void drawMe() {
        System.out.println("  / \\__");
        System.out.println(" (    @\\___");
        System.out.println(" /         O");
        System.out.println("/   (_____/");
        System.out.println("/_____/   U");
    }

    private void speak() {
        System.out.println("Woof!");
    }

    public void myInfo() {
        System.out.println("Name: " + name);
        drawMe();
        speak();
    }
    
}
