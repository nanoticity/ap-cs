import java.util.ArrayList;

public class Runner {
    
    public static void main(String[] args) {
        ArrayTest at = new ArrayTest();
        ArrayList<Card> cardList = new ArrayList<Card>();
        for (int i = 0; i < 5; i++) {
            int randomValue = (int) (Math.random() * 9) + 1;
            cardList.add(new Card(randomValue));
        }

        System.out.println("Initial card list:");
        at.printList(cardList);

        int total = at.findTotal(cardList);
        System.out.println("Total value: " + total);

        at.scramble(cardList);
        System.out.println("Scrambled card list:");
        at.printList(cardList);

        System.out.println("Search and delete value 2:");
        at.searchAndDelete(cardList, 2);
        at.printList(cardList);

        System.out.println("Search and replace value 4:");
        at.searchAndReplace(cardList, 4);
        at.printList(cardList);

        at.sort(cardList);
        System.out.println("Sorted card list:");
        at.printList(cardList);
    }
}
