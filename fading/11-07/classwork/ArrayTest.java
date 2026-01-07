public class ArrayTest {
    public void arrayDemo1() {
        System.out.println("Demo 1");
        int[] arr = new int[5];
        arr[0] = (int)(Math.random()*15+1);
        arr[1] = (int)(Math.random()*15+1);
        arr[2] = (int)(Math.random()*15+1);
        arr[3] = (int)(Math.random()*15+1);
        arr[4] = (int)(Math.random()*15+1);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);
    }

    public void arrayDemo2() {
        System.out.println("Demo 2");
        int[] arr = new int[25];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*9+1);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void arrayDemo3() {
        System.out.println("Demo 3");
        String[] words = {"apple", "table", "river", "light", "dream"};
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }

    public void arrayDemo4() {
        System.out.println("Demo 4");
        Profile[] profile = new Profile[5];
        profile[0] = new Profile("John");
        profile[1] = new Profile("Emma");
        profile[2] = new Profile("Liam");
        profile[3] = new Profile("Olivia");
        profile[4] = new Profile("Noah");
        for (int i = 0; i < profile.length; i++) {
            String name = profile[i].getName();
            System.out.println(name);
        }
    }
}

