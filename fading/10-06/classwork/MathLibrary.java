//public class MathLibrary {
//    private double pi;
//    public MathLibrary() {
//        pi = 3.14;
//    }
//    public double circumference(double r) {
//        return (2 * r * pi);
//    }
//    public double areaCircle(double r) {
//        return (r * r * pi);
//    }
//    public double volCylinder(double r, double h) {
//        double a = areaCircle(r);
//        return (a * h);
//    }
//    public double volCone(double r, double h) {
//        double a = areaCircle(r);
//        return (a * h / 3.0);
//    }
//    public double volSphere(double r) {
//        return (Math.pow(r, 3) * pi * 4.0 / 3.0);
//    }
//}

public class MathLibrary() {
    // Instance variable
    private double pi;

    // Constructor
    public MathLibrary() {
        // Sets pi to be 3.14
        this.pi = 3.14;
    }

    /**
     * Calculates the circumference of a circle.
     * @param radius The radius of the circle.
     * @return The circumference.
     */
    public double circumference(double radius) {
        // Circumference = 2 * pi * radius
        return 2 * this.pi * radius;
    }

    /**
     * Calculates the area of a circle.
     * @param radius The radius of the circle.
     * @return The area of the circle.
     */
    public double areaCircle(double radius) {
        // Area = pi * radius^2
        return this.pi * radius * radius;
    }

    /**
     * Calculates the volume of a cylinder.
     * @param radius The radius of the cylinder's base.
     * @param height The height of the cylinder.
     * @return The volume of the cylinder.
     */
    public double volCylinder(double radius, double height) {
        // Call areaCircle(double) to get the area of the base.
        double areaBase = areaCircle(radius);
        
        // Volume = Area of a Circle * height
        double volume = areaBase * height;
        
        return volume;
    }

    /**
     * Calculates the volume of a cone.
     * @param radius The radius of the cone's base.
     * @param height The height of the cone.
     * @return The volume of the cone.
     */
    public double volCone(double radius, double height) {
        // Call areaCircle(double) to get the area of the base.
        double areaBase = areaCircle(radius);
        
        // Volume = (Area of a circle * height) / 3.0
        double volume = (areaBase * height) / 3.0;
        
        return volume;
    }

    /**
     * Calculates the volume of a sphere.
     * @param radius The radius of the sphere.
     * @return The volume of the sphere.
     */
    public double volSphere(double radius) {
        // Volume = (4/3) * pi * radius^3
        return (4.0 / 3.0) * this.pi * radius * radius * radius;
    }
}
