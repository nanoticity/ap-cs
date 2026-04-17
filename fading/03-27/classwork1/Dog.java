// Dog Class
// Instance variables
// - name : String
// Constructor
// + Dog(String) Sets up the instance variable.
// Methods
// + speak() : String - Return the name concatenated with the word “: woof”.

public class Dog {
  private String name;

  public Dog(String name) {
    this.name = name;
  }

  public String speak() {
    return name + ": woof";
  }
}