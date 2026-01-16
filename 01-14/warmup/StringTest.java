public class StringTest {
    private String email;

    public StringTest(String email) {
        this.email = email;
    }

    public String toString() {
        String num = String.valueOf(email.toCharArray().length);
        return email + " " + num;
    }

    public int countChar(char c) {
        int count = 0;
        for (char ch : email.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }

        return count;
    }

    public String getDomain() {
        int at = email.indexOf("@");
        int dot = email.lastIndexOf(".");

        return email.substring(at + 1, dot);
    }
}
