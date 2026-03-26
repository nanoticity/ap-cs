public class Bird extends Animal {
  public Bird(String name) {
    super(name);
  }

  public void printInfo() {
    super.speak();
    System.out.println(getName());
    System.out.println("I make the sound ");
    this.speak();
  }

  public void speak() {
    System.out.println("tweet");
  }
}
