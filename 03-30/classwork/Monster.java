public abstract class Monster {
  private String name;
  private String favoriteFood;
  private static int count;
  private static int coins;

  public Monster(String name, String favoriteFood) {
    this.name = name;
    this.favoriteFood = favoriteFood;
    count++;
  }

  public String getFavFood() {
    return "Favorite food: " + favoriteFood;
  }

  public String getName() {
    return "My name is " + this.name;
  }
  
  public static int getCount() {
    return count;
  }

  public static void addCoins(int c) {
    coins += c;
  }

  public static int getCoins() {
    return coins;
  }

  public void getInfo() {
    System.out.println(getName());
    System.out.println(getFavFood());
  }

}
