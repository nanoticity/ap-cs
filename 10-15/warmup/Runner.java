public class Runner {
    public static void main(String[] args) {
        Pythagorean pythagorean = new Pythagorean();
        double c = pythagorean.findC(5, 12);
        System.out.println("The length of the hypotenuse is: " + c);
    }
}
