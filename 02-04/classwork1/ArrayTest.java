import java.util.ArrayList;

public class ArrayTest {
    public void printList(ArrayList<Card> cardList){
        for (Card c : cardList) {
            System.out.println(c);
        }
    }

    public int findTotal(ArrayList<Card> cardList){
        int total = 0;
        for (Card c : cardList) {
            total += c.getValue();
        }
        return total;
    }

    public int scramble(ArrayList<Card> cardList){
        for (int i = 0; i < cardList.size(); i++) {
            int randomIndex = (int) (Math.random() * cardList.size());
            Card temp = cardList.get(i);
            cardList.set(i, cardList.get(randomIndex));
            cardList.set(randomIndex, temp);
        }
        return 0;
    }

    public void searchAndDelete(ArrayList<Card> cardList, int value){
        for (int i = 0; i < cardList.size(); i++) {
            if (cardList.get(i).getValue() == value) {
                cardList.remove(i);
                i--;
            }
        }
    }

    public void searchAndReplace(ArrayList<Card> cardList, int value){
        for (int i = 0; i < cardList.size(); i++) {
            if (cardList.get(i).getValue() == value) {
                cardList.set(i, new Card((int)(Math.random() * 9) + 1));
            }
        }
    }

    public void sort(ArrayList<Card> cardList){
        for (int i = 0; i < cardList.size() - 1; i++) {
            for (int j = 0; j < cardList.size() - 1 - i; j++) {
                if (cardList.get(j).getValue() > cardList.get(j + 1).getValue()) {
                    Card temp = cardList.get(j);
                    cardList.set(j, cardList.get(j + 1));
                    cardList.set(j + 1, temp);
                }
            }
        }
    }
}
