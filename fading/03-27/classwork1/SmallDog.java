
// SmallDog Class extends Dog
// Constructor
// + SmallDog(String) Sets up the instance variable by calling constructor of the parent. Make sure to use super.
// Methods
// + speak() : String - Return speak() from the parent concatenated with “....”.  Make sure to use super.

public class SmallDog extends Dog {
  public SmallDog(String name) {
    super(name);
  }

  public String speak() {
    return super.speak() + "....";
  }
}