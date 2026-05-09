import java.util.ArrayList;

public class CubePair {

  private ArrayList<Cube> cubes = new ArrayList<>();

  public CubePair(String type) {
    cubes.add(new Cube(type));
    cubes.add(new Cube(type));
  }

  public CubePair(String one, String two) {
    cubes.add(new Cube(one));
    cubes.add(new Cube(two));
  }

  public String rollCubes() {
    String ret = "";
    for (Cube c : cubes) {
      ret += c.roll();
    }
    return ret;
  }
}
