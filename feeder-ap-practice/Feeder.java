public class Feeder {

    /**
     * The amount of food, in grams, currently in the bird feeder; initialized
     * in the constructor and always greater than or equal to zero
     */
    private int currentFood;  // how much food is currently available

    // For testing purposes
    public Feeder(int currentFood) {
        this.currentFood = currentFood;
    }

    // for testing
    public int getCurrentFood() {
        return currentFood;
    }

    // for testing
    public void updateCurrentFood(int currentFood) {
        this.currentFood = currentFood;
    }

    /**
     * Simulates one day with numBirds birds or possibly a bear at the bird
     * feeder, as described in part (a) Precondition: numBirds > 0
     */
    public void simulateOneDay(int numBirds) {
        int random = (int) (Math.random() * 100);

        if (random < 95) {
            int foodPerBird = 10 + (int) (Math.random() * 41);
            int totalConsumed = numBirds * foodPerBird;

            if (totalConsumed >= currentFood) {
                currentFood = 0;
            } else {
                currentFood -= totalConsumed;
            }
        } else {
            currentFood = 0;
        }
    }

    /**
     * Returns the number of days birds or a bear found food to eat at the
     * feeder in this simulation, as described in part (b) Preconditions:
     * numBirds > 0, numDays > 0
     */
    public int simulateManyDays(int numBirds, int numDays) {
        int daysWithFood = 0;

        for (int day = 0; day < numDays; day++) {
            if (currentFood > 0) {
                simulateOneDay(numBirds);
                daysWithFood++;
            } else {
                break;
            }
        }

        return daysWithFood;
    }
}