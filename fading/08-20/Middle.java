public class Middle {
    public static void main(String[] args){
        int numOne = 5;
        int numTwo = 10;
        double doubleOne = 3.5;
        double doubleTwo = 7.5;
        double doubleThree = 10.5;

        System.out.println("numOne = " + numOne);
        System.out.println("numTwo = " + numTwo);

        int middle1 = (numOne + numTwo) / 2;
        System.out.println("middle1 = " + middle1);

        double middle2 = (numOne + numTwo) / 2;
        System.out.println("middle2 = " + middle2);
        
        double average = (doubleOne + doubleThree + doubleTwo) / 3.00;
        System.out.println("average = " + average);

    }
}
