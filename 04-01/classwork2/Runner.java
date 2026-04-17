import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) throws IOException {
        ArrayList<Task> tasks = new ArrayList<Task>();
        File saveFile = new File("save.dat");

        if (saveFile.exists()) {
            Scanner fileScanner = new Scanner(saveFile);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();

                if (!line.isEmpty() && line.contains(":")) {
                    String[] parts = line.split(":", 2);
                    int rank = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    tasks.add(new Task(rank, name));
                }
            }

            fileScanner.close();
        }

        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Display tasks");
            System.out.println("2. Add task");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");
            String choice = keyboard.nextLine();

            if (choice.equals("1")) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks saved.");
                } else {
                    for (Task task : tasks) {
                        System.out.println(task);
                    }
                }
            } else if (choice.equals("2")) {
                System.out.print("Enter task name: ");
                String name = keyboard.nextLine();

                System.out.print("Enter task rank: ");
                int rank = Integer.parseInt(keyboard.nextLine());

                tasks.add(new Task(rank, name));
                selectionSort(tasks);
                System.out.println("Task added.");
            } else if (choice.equals("3")) {
                PrintWriter writer = new PrintWriter(saveFile);

                for (Task task : tasks) {
                    writer.println(task);
                }

                writer.close();
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        keyboard.close();
    }

    public static void selectionSort(ArrayList<Task> tasks) {
        for (int i = 0; i < tasks.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < tasks.size(); j++) {
                if (tasks.get(j).getRank() < tasks.get(minIndex).getRank()) {
                    minIndex = j;
                }
            }

            Task temp = tasks.get(i);
            tasks.set(i, tasks.get(minIndex));
            tasks.set(minIndex, temp);
        }
    }
}
