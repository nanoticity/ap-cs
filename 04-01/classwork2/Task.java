public class Task {
    private int rank;
    private String name;

    public Task(int rank, String name) {
        this.rank = rank;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public String toString() {
        return rank + ":" + name;
    }
}
