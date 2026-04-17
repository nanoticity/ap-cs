// BigDog Class extends Dog
// Constructor
// + BigDog(String) Sets up the instance variable by calling constructor of the parent. Make sure to use super.
// Methods
// + speak() : String - Return speak() from the parent concatenated with “!!!!”.  Make sure to use super.

public class BigDog extends Dog {
  public BigDog(String name) {
    super(name);
  }

  public String speak() {
    return super.speak() + "!!!!";
  }
}