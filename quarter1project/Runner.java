import javax.swing.*;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Golden Gate Bridge");
        Scanner scan = new Scanner(System.in);

        System.out.println("Day or night? enter 1 or 2");
        int dayNum = scan.nextInt();

        System.out.println("Cloudy or clear? enter 1 or 2");
        int cloudyNum = scan.nextInt();

        System.out.println("Rainy or dry? enter 1 or 2");
        int rainyNum = scan.nextInt();

        boolean day = true;
        if (dayNum == 1) {
            day = true;
        } else {
            day = false;
        }

        boolean cloudy = true;
        if (cloudyNum == 1) {
            cloudy = true;
        } else {
            cloudy = false;
        }

        boolean rainy = true;
        if (rainyNum == 1) {
            rainy = true;
        } else {
            rainy = false;
        }

        scan.close();

        Scenery canvas = new Scenery(day, cloudy, rainy);
        
        canvas.generateClouds();
        canvas.generateRain();
        frame.add(canvas);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

        frame.pack();

        canvas.animate();
    }
}
