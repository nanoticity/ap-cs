
// Husky Class extends BigDog
// Constructor
// + Husky(String) Sets up the instance variable by calling constructor of the parent. Make sure to use super.
// Methods
// + speak() : String - Return speak() from the parent concatenated with “+ howl!!!”. Make sure to use super.

public class Husky extends BigDog {
  public Husky(String name) {
    super(name);
  }

  public String speak() {
    return super.speak() + " + howl!!!";
  }
}