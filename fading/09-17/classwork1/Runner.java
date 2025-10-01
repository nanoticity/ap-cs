public class Runner {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.printVariables();
        r1.printArea();

        System.out.println();

        Rectangle r2 = new Rectangle(5, 3);
        r2.printVariables();
        r2.printArea();

        System.out.println();


        Triangle t1 = new Triangle();
        t1.printVariables();
        t1.printArea();

        System.out.println();

        Triangle t2 = new Triangle(5, 3);
        t2.printVariables();
        t2.printArea();

        System.out.println();

        Circle c1 = new Circle();
        c1.printVariables();
        c1.printArea();

        System.out.println();
        
        Circle c2 = new Circle(10);
        c2.printVariables();
        c2.printArea();
    }
}
