import box.*; //Challenge: What does .* do?
/* or
import box.StandardBox;
import box.ShippingBox;
*/

public class Runner {
    public static void main(String[] args) {

        ShippingBox obj = new ShippingBox();
        obj.printInfo();

        System.out.println("\nRunning inside Runner: ");

        StandardBox obj2 = new StandardBox();

        // Answer the following...

        // (1) Does it print? why? yes, its public
        System.out.println(obj2.companyName);

        // (2) Does it print? why? no, its private
        // System.out.println( obj2.password );

        // (3) Does it print? why? no, it has protected access
        // System.out.println( obj2.address );

        // (4) What do you have import to access the StandardBox class?

        // (5) What folder is the StandardBox class in?

    }
}
