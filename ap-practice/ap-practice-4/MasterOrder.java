import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MasterOrder {

  /**
   * The list of all cookie orders
   */
  private final List<CookieOrder> orders;

  /**
   * Constructs a new MasterOrder object.
   */
  public MasterOrder() {
    orders = new ArrayList<>();
  }

  /**
   * Adds theOrder to the master order.
   *
   * @param theOrder the cookie order to add to the master order
   */
  public void addOrder(CookieOrder theOrder) {
    orders.add(theOrder);
  }

  /**
   * @return the sum of the number of boxes of all of the cookie orders
   */
  public int getTotalBoxes() {
    /* to be implemented in part (a) */
    int totalBoxes = 0;
    for (CookieOrder order : orders) {
      totalBoxes += order.getNumBoxes();
    }
    return totalBoxes;
  }

  /**
   * Removes all cookie orders from the master order that have the same
   * variety of cookie as cookieVar and returns the total number of boxes that
   * were removed.
   *
   * @param cookieVar the variety of cookies to remove from the master order
   * @return the total number of boxes of cookieVar in the cookie orders
   *         removed
   */
  public int removeVariety(String cookieVar) {
    Iterator<CookieOrder> it = orders.iterator();
    int removedBoxes = 0;
    while (it.hasNext()) {
      CookieOrder nextCookieOrder = it.next();
      if (nextCookieOrder.getVariety().equals(cookieVar)) {
        removedBoxes += nextCookieOrder.getNumBoxes();
        it.remove();
      }
    }
    return removedBoxes;

  }

  public void printAllOrders() {
    for (CookieOrder each : orders) {
      System.out.println("\nVariety: " + each.getVariety());
      System.out.println("NumBoxes: " + each.getNumBoxes());
    }
  }
  // There may be instance variables, constructors, and methods that are not
  // shown.
}
