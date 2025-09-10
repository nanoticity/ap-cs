public class Bird {
    
    private String name = "Birdie";

    private void drawMe() {
        System.out.println(" /\\ /\\");
        System.out.println("((ovo))");
        System.out.println(" ()::();");
    }

    private void speak() {
        System.out.println("Chirp!");
    }

    public void myInfo() {
        System.out.println("Name: " + name);
        drawMe();
        speak();
    }

}
