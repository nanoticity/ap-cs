public class Runner {
    public static void main(String[] args) {
        StringReview s = new StringReview();

        String hw = "Hello, World!";
        System.out.println(s.getChar(hw, 2));
        System.out.println(s.getChar(hw, 1));

        System.out.println(s.countChar(hw, 'o'));
        System.out.println(s.countChar(hw, 'l'));
        
    }
}
