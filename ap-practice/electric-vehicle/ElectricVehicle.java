public class ElectricVehicle {

  private String modelName;
  private int range;

  public ElectricVehicle(String modelName, int range) {
    this.modelName = modelName;
    this.range = range;
  }

  /**
   * Returns the range of the vehicle, which is the distance, in miles, that the
   * vehicle can travel on a fully charged battery
   */
  public int getRange() {
    return this.range;
  }

  /**
   * Returns the model name of the vehicle
   */
  public String getModelName() {
    return this.modelName;
  }

  /*
   * There may be instance variables, constructors, and methods that are not
   * shown.
   */

}
