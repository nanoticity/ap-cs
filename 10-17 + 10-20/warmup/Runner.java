public class Runner {
    public static void main(String[] args) {
        Number number = new Number();
        boolean isOdd = number.checkOdd(5);
        double area = number.areaTriangle(4.5, 4.0);

        System.out.println("Is 5 odd? " + isOdd);
        System.out.println("Area of triangle: " + area);
    }
}
