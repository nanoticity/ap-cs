
public class DogWalker {

    /**
     * The maximum number of dogs this walker can walk simultaneously per hour
     */
    private int maxDogs;
    /**
     * The dog-walking company this dog walker is associated with
     */
    private DogWalkCompany company;

    /**
     * Assigns max to maxDogs and comp to company Precondition: max > 0
     */
    public DogWalker(int max, DogWalkCompany comp) {
        maxDogs = max;
        company = comp;
    }

    /**
     * Takes at least one dog for a walk during the time specified by hour, as
     * described in part (a) Preconditions: 0 <= hour <= 23
     * maxDogs > 0
     */
    public int walkDogs(int hour) {
        /* to be implemented in part (a) */
        int available = company.numAvailableDogs(hour);
        int dogsToWalk = Math.min(available, maxDogs);
        company.updateDogs(hour, dogsToWalk);
        return dogsToWalk;

    }

    /**
     * Performs an entire dog-walking shift and returns the amount earned, in
     * dollars, as described in part (b) Preconditions: 0 <= startHour <=
     * endHour <= 23
     * maxDogs > 0
     */
    public int dogWalkShift(int startHour, int endHour) {
        int totalEarned = 0;

        for (int hour = startHour; hour <= endHour; hour++) {
            int dogsWalked = walkDogs(hour);
            int hourlyPay = dogsWalked * 5;

            if (dogsWalked == maxDogs || (hour >= 9 && hour <= 17)) {
                hourlyPay += 3;
            }

            totalEarned += hourlyPay;
        }

        return totalEarned;
    }

    /* There may be instance variables, constructors,
    and methods that are not shown. */
}
