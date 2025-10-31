public class Rectangle {
    private double area(double width, double height) {
        return width * height;
    }

    public double volRect(double width, double height, double depth) {
        return area(width, height) * depth;
    }
}
