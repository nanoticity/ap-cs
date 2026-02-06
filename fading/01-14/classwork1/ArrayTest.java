class ArrayTest {
    private int[] numArray;
    private String[] stringArray;

  public ArrayTest() {
    numArray = new int[10];
    for (int i = 0; i < numArray.length; i++) {
      numArray[i] = (int) (Math.random() * (20 - 1 + 1)) + 1;
    }
    
    stringArray = new String[5];
    stringArray[0] = "dog";
    stringArray[1] = "cat";
    stringArray[2] = "horse";
    stringArray[3] = "rabbit";
    stringArray[4] = "fox";
    
  }

    public void printNumArray() {
        for (int i : numArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void printStringArray() {
        for (String i : stringArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void swapNumArray(int a, int b) {
        int temp = numArray[a];
        numArray[a] = numArray[b];
        numArray[b] = temp;
    }

    public void swapStringArray(int a, int b) {
        String temp1 = stringArray[a];
        stringArray[a] = stringArray[b];
        stringArray[b] = temp1;
    }

    public int searchString(String s) {
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] == s) {
                return i;
            }
        }
        return -1;
    }

    public int countLetter(char c) {
        int count = 0;
        for (int i = 0; i < stringArray.length; i++) {
            for (char ch : stringArray[i].toCharArray()) {
                if (ch == c) {
                    count++;
                }
            }
        }
        return count;
    }
}
