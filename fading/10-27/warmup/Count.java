public class Count {
  public int getTotal(int n) {
    int r = 0;
    for (int i=2; i <=n; i += 2) {
      r += i;
    }
    return r;
  }
}
