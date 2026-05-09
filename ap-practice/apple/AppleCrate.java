public class AppleCrate
{
 private Apple[][] apples;


 public AppleCrate()
 {
    apples = new Apple[4][6];
    apples[0][0] = new Apple(0.3, false);
    apples[0][1] = new Apple(0.4, false);
    apples[0][2] = new Apple(0.35, false); 
    apples[0][3] = new Apple(0.5, false);
    apples[0][4] = new Apple(0.45, false);
    apples[0][5] = new Apple(0.4, true);
    apples[1][0] = new Apple(0.42, false);
    apples[1][1] = new Apple(0.38, false);
    apples[1][2] = new Apple(0.33, false);
    apples[1][3] = new Apple(0.4, false);
    apples[1][4] = new Apple(0.41, false);
    apples[1][5] = new Apple(0.44, false);
    apples[2][0] = new Apple(0.32, false);
    apples[2][1] = new Apple(0.44, false);
    apples[2][2] = new Apple(0.35, true);
    apples[2][3] = new Apple(0.49, false);
    apples[2][4] = new Apple(0.29, false);
    apples[2][5] = new Apple(0.32, false);
    apples[3][0] = new Apple(0.3, false);
    apples[3][1] = new Apple(0.4, false);
    apples[3][2] = new Apple(0.35, false);
    apples[3][3] = new Apple(0.5, false);
    apples[3][4] = new Apple(0.45, false);
    apples[3][5] = new Apple(0.4, false);


 }




 /**
 * Returns the number of pies that can be made from the 2D array
 * apples if each pie requires poundsPerPie pounds of apples.
 * If an apple is rotten, it cannot be used in a pie, nor can any
 * adjacent apple.
 * Preconditions: apples has at least two rows and at least two
 * columns.
 * No elements in apples are null.
 */
 public int numberOfPies(double poundsPerPie)
  { 
    boolean[][] unusable = new boolean[apples.length][apples[0].length];

    for (int row = 0; row < apples.length; row++) {
      for (int col = 0; col < apples[0].length; col++) {
        if (apples[row][col].isRotten()) {
          unusable[row][col] = true;

          if (row > 0) {
            unusable[row - 1][col] = true;
          }
          if (row < apples.length - 1) {
            unusable[row + 1][col] = true;
          }
          if (col > 0) {
            unusable[row][col - 1] = true;
          }
          if (col < apples[0].length - 1) {
            unusable[row][col + 1] = true;
          }
        }
      }
    }

    double usableWeight = 0.0;
    for (int row = 0; row < apples.length; row++) {
      for (int col = 0; col < apples[0].length; col++) {
        if (!unusable[row][col]) {
          usableWeight += apples[row][col].getWeight();
        }
      }
    }

    return (int) (usableWeight / poundsPerPie);
  }


 
 /* There may be instance variables, constructors,
 and methods that are not shown. */
}
