public class Runner {
    public static void main(String[] args) {
        ArrayTest a = new ArrayTest(5);

        a.print();
        System.out.println(a.search(5));    
        System.out.println(a.search(9));    
    }
}
