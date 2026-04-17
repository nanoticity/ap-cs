import java.util.ArrayList;

// Runner
// Instantiate Dog with the name of "Fido" with the object variable d1.
// Call speak() print the result from d1.
// Cast d1 to BigDog to the variable d2. Does this work and why?

// Instantiate BigDog with the name of “Biggy” with the object variable bd1.
// Call speak() print the result from bd1.
// Cast bd1 to Dog to the variable bd2.
// Call speak() print the result from bd2.

// Instantiate Husky with the name of “Snow” with the object variable h1.
// Call speak() print the result from h1.
// Cast h1 to Dog to the variable h2.
// Call speak() print the result from h2.
// Cast h2 back to Husky calling it h3.
// Call speak() from h3
// Cast h1 to BigDog calling it h4. Does this work and why?

// Instantiate SmallDog with the name of “Tiny” with the object variable sm.
// Call speak() print the result from sm.
// Cast sm to Dog to the variable d3.
// Call speak() print the result from d3.
// Cast sm to BigDog to the variable bd3.  Does this work and why?

// Create an ArrayList of Dog.  Add a Dog object, a BidDog object, a Husky object, and a SmallDog object to it.  Use a for loop or for each loop to go through each object in the ArrayList and call speak().

public class Runner {
  public static void main(String[] args) {
    Dog d1 = new Dog("Fido");
    System.out.println(d1.speak());
    // BigDog d2 = (BigDog) d1;
    // This does NOT work. d1 is a Dog object, not a BigDog.
    // You cannot cast a parent object to a child type because
    // the Dog object doesn't have BigDog's properties.

    BigDog bd1 = new BigDog("Biggy");
    System.out.println(bd1.speak());
    Dog bd2 = bd1;
    System.out.println(bd2.speak());

    Husky h1 = new Husky("Snow");
    System.out.println(h1.speak());
    Dog h2 = h1;
    System.out.println(h2.speak());
    Husky h3 = (Husky) h2;
    System.out.println(h3.speak());
    BigDog h4 = h1;
    // This DOES work because Husky extends BigDog, so h1 IS-A BigDog.
    // Upcasting from a child to a parent type is always safe.

    SmallDog sm = new SmallDog("Tiny");
    System.out.println(sm.speak());
    Dog d3 = sm;
    System.out.println(d3.speak());
    // BigDog bd3 = (BigDog) sm;
    // This does NOT work. SmallDog extends Dog, not BigDog.
    // SmallDog and BigDog are siblings in the hierarchy, so you
    // cannot cast between them.

    ArrayList<Dog> dogs = new ArrayList<Dog>();
    dogs.add(new Dog("Generic"));
    dogs.add(new BigDog("Big"));
    dogs.add(new Husky("Husky"));
    dogs.add(new SmallDog("Small"));

    for (Dog dog : dogs) {
      System.out.println(dog.speak());
    }
  }
}