public class Card {
  String suit;
  String rank;

  public Card(String s, String r) {
    suit = s;
    rank = r;
  }

  public int getValue() {
    if (rank.equals("A"))
      return 14;
    if (rank.equals("K"))
      return 13;
    if (rank.equals("Q"))
      return 12;
    if (rank.equals("J"))
      return 11;
    return Integer.parseInt(rank);
  }

  public String toString() {
    return rank + " of " + suit;
  }
}
