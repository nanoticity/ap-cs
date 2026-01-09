//Challenge: What does this do?
package box;

public class ShippingBox {
    public void printInfo() {
        System.out.println("Running inside ShippingBox: ");
        StandardBox b = new StandardBox();

        // Answer the following

        // (6) Does companyName print? why? yes, it is public
        System.out.println(b.companyName);

        // (7) Does password print? why? no, its private
        // System.out.println( b.password );

        // (8) Does address print? why? yes, its protected, therefore you can access it
        // inside the package box
        System.out.println( b.address );

    }
}
