import java.util.ArrayList;
import java.util.Collections;

public class CardGame {
  private static String[] SUITS = { "clubs", "diamonds", "hearts", "spades" };
  private static String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
  private ArrayList<Card> deck = new ArrayList<>();
  private ArrayList<Card> playerOne = new ArrayList<>();
  private ArrayList<Card> playerTwo = new ArrayList<>();

  public CardGame() {
    buildDeck();
  }

  public void startRound() {
    buildDeck();
    Collections.shuffle(deck);
    playerOne.clear();
    playerTwo.clear();
    dealHands();
  }

  public ArrayList<Card> getHand(int playerIndex) {
    return playerIndex == 1 ? playerTwo : playerOne;
  }

  private void buildDeck() {
    deck.clear();
    for (String suit : SUITS) {
      for (String rank : RANKS) {
        deck.add(new Card(suit, rank));
      }
    }
  }

  private void dealHands() {
    for (int i = 0; i < 3; i++) {
      playerOne.add(deck.remove(deck.size() - 1));
      playerTwo.add(deck.remove(deck.size() - 1));
    }
  }

  public int[] evaluateHand(ArrayList<Card> hand) {
    int[] vals = new int[3];
    for (int i = 0; i < 3; i++) vals[i] = hand.get(i).rankValue();
    for (int i = 0; i < 2; i++) {
      for (int j = i + 1; j < 3; j++) {
        if (vals[j] > vals[i]) {
          int tmp = vals[i]; vals[i] = vals[j]; vals[j] = tmp;
        }
      }
    }

    boolean flush = hand.get(0).getSuit().equals(hand.get(1).getSuit())
                 && hand.get(1).getSuit().equals(hand.get(2).getSuit());
    boolean straight = (vals[0] - vals[1] == 1 && vals[1] - vals[2] == 1)
                    || (vals[0] == 14 && vals[1] == 3 && vals[2] == 2);

    if (straight && vals[0] == 14 && vals[1] == 3) {
      vals[0] = 3; vals[1] = 2; vals[2] = 1;
    }

    int handRank;
    if (straight && flush) handRank = 5;
    else if (vals[0] == vals[1] && vals[1] == vals[2]) handRank = 4;
    else if (straight) handRank = 3;
    else if (flush) handRank = 2;
    else if (vals[0] == vals[1] || vals[1] == vals[2]) handRank = 1;
    else handRank = 0;

    if (handRank == 1 && vals[1] == vals[2]) {
      int kicker = vals[0];
      vals[0] = vals[1];
      vals[1] = kicker;
      vals[2] = 0;
    }

    return new int[]{ handRank, vals[0], vals[1], vals[2] };
  }

  public String getHandName(ArrayList<Card> hand) {
    int[] eval = evaluateHand(hand);
    if (eval[0] == 5) return "Straight Flush";
    if (eval[0] == 4) return "Three of a Kind";
    if (eval[0] == 3) return "Straight";
    if (eval[0] == 2) return "Flush";
    if (eval[0] == 1) return "Pair";
    return "High Card";
  }

  public int compareHands() {
    int[] eval1 = evaluateHand(playerOne);
    int[] eval2 = evaluateHand(playerTwo);
    for (int i = 0; i < eval1.length; i++) {
      if (eval1[i] > eval2[i]) return 1;
      if (eval1[i] < eval2[i]) return 2;
    }
    return 0;
  }
}
