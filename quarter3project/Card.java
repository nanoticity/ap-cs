public class Card {
  public String suit;
  public String rank;

  public Card(String suit, String rank) {
    this.suit = suit;
    this.rank = rank;
  }

  public String getSuit() { return suit; }
  public String getRank() { return rank; }

  public int rankValue() {
    if (rank.equals("A")) return 14;
    if (rank.equals("K")) return 13;
    if (rank.equals("Q")) return 12;
    if (rank.equals("J")) return 11;
    return Integer.parseInt(rank);
  }

  public String toString() {
    return rank + " of " + suit;
  }
}
