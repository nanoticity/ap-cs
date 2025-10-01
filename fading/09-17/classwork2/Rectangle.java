public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double l, double w) {
        length = l;
        width = w;
    }

    public Rectangle() {
        length = 0;
        width = 0;
    }

    public void printVariables() {
        System.out.println("length: " + length);
        System.out.println("width: " + width);
    }

    public void printArea() {
        System.out.println("rect area: " + (length * width));
    }


}
