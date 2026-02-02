import java.util.ArrayList;

public class Test {
    private void swap(ArrayList<String> list, int i1, int i2) { 
        String tempString = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, tempString);
    }
    
    public void scramble(ArrayList<String> a) {
        for (int i = 0; i < a.size(); i++) {
            int randomIndex = (int) (Math.random() * a.size());
            swap(a, i, randomIndex);
        }
    }

    public void changeNum(int i) {
        i = 99;
    }

}
