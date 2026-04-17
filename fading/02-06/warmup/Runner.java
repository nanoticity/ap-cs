import java.util.ArrayList;

public class Runner {
    public static void main(String [] args) {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add (new Item("Cereal", 4.99));
        items.add (new Item("Milk", 3.99));
        items.add (new Item("Water", 0.99));


        int total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        System.out.println("Total price : " + total);

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getPrice() == 0.99) {  
                items.set(i, new Item(items.get(i).getName(), 1.25));
            }
        }

        for (Item item : items) {
            System.out.println(item);
        }

    }   
}
