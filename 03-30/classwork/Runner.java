public class Runner {
  
  public static void main(String[] args) {
    Vampire dracula = new Vampire("Dracula");
    Mummy tutankhamun = new Mummy("Tutankhamun");
    Witch morgana = new Witch("Morgana");
    
    dracula.getInfo();
    tutankhamun.getInfo();
    morgana.getInfo();
    
    Monster.addCoins(50);
    Monster.addCoins(75);
    Monster.addCoins(100);
    
    System.out.println("Total monsters created: " + Monster.getCount());
    System.out.println("Total coins collected: " + Monster.getCoins());
  }
}
