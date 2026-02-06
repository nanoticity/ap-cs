public class Runner {
    public static void main(String[] args) {
        ArrayTest at = new ArrayTest();
        at.printNumArray();
        at.swapNumArray(0, 9);
        at.printNumArray();
        at.printStringArray();
        at.swapStringArray(1, 2);
        at.printStringArray();
        at.searchString("horse");
        System.out.println(at.countLetter('e'));
        System.out.println(at.countLetter('a'));

    }
}