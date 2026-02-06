public class StringTest {
    private String myTest;

    public StringTest(String str) {
        myTest = str;
    }

    private int getLength() {
        return myTest.length();
    }

    public void printInfo() {
        System.out.println("Text: " + myTest + " length: " + getLength());
    }

    public void printChar(int index) {
        System.out.println("Char at index " + index + " is " + myTest.charAt(index));
    }

    public void printLocation(String c) {
        System.out.println("Index of " + c + " is " + myTest.indexOf(c));
    }

    public int countChar(char ch) {
        int count = 0;
        for (char c : myTest.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(String str) {
        return (myTest.indexOf(str) >= 0) ? true : false;
    }

    public int countVowels() {
        int count = 0;

        count += countChar('a');
        count += countChar('e');
        count += countChar('i');
        count += countChar('o');
        count += countChar('u');

        return count;
    }
}
