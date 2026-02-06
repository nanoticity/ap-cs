public class Runner {
    public static void main(String[] args) {
        StringTest st = new StringTest("The quick brown fox jumps over the lazy dog");
        st.printInfo();
        st.printChar(0);
        st.printChar(5);
        st.printChar(10);
        st.printChar(15);
        st.printLocation("h");
        st.printLocation("e");
        st.printLocation("jumps");
        st.printLocation("dog");
        int count = st.countChar('o');
        System.out.println(count);
        boolean containsDog = st.contains("dog");
        System.out.println(containsDog);
        boolean containsJava = st.contains("java");
        System.out.println(containsJava);
        int vowels = st.countVowels();
        System.out.println(vowels);
    }
}
