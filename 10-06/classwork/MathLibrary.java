public class MathLIbrary {
    private double pi;
    public MathLibrary() {
        pi = 3.14;
    }
    public double circumference(double r) {
        return (2 * r * pi);
    }
    public double areaCircle(double r) {
        return (r * r * pi);
    }
    public double volCylinder(double r, double h) {
        double a = areaCircle(r);
        return (a * h);
    }
    public double volCone(double r, double h) {
        double a = areaCircle(r);
        return (a * h / 3.0);
    }
    public double volSphere(double r) {
        return (Math.pow(r, 3) * pi * 4.0 / 3.0);
    }
}