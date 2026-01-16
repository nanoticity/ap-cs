public class Runner {
    public static void main(String[] args) {
        StringTest s = new StringTest("tom@mvla.net");

        System.out.println(s);
        System.out.println(s.countChar('m'));
        System.out.println(s.getDomain());
    }
}
