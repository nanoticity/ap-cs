public class Square {
    private double sideLength;

    public Square(double l) {
        sideLength = l;
    }

    public Square() {
        sideLength = 0;
    }

    public void printVariables() {
        System.out.println("side length: " + sideLength);
    }

    public void printArea() {
        System.out.println("rect area: " + (sideLength * sideLength));
    }
}
