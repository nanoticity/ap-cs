public class StringReview {
    public char getChar(String s, int i) {
        char c = s.charAt(i);
        return c;
    }

    public int countChar(String s, char c) {
        int i = 0;
        for (char cs : s.toCharArray()) {
            if (cs == c) {
                i++;
            }
        }
        
        return i;
    }
}