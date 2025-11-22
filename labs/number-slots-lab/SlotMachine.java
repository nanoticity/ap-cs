import java.awt.*;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class SlotMachine {

    private int num1, num2, num3;
    private int winnings;
    private int balance;

    public SlotMachine(int balance) {
        this.balance = balance;
    }

    private int calculateWinnings() {
        if (num1 == 7 && num2 == 7 && num3 == 7) {
            playWinSound();
            return 100;
        } else if (num1 == num2 && num2 == num3) {
            playWinSound();
            return 5;
        } else if (num1 == num2 || num2 == num3 || num1 == num3) {
            playWinSound();
            return 1;
        } else {
            playLoseSound();
            return 0;
        }
    }

    public void spin(int bet) {
        num1 = (int) (Math.random() * 10);
        num2 = (int) (Math.random() * 10);
        num3 = (int) (Math.random() * 10);

        balance -= bet;
        int points = calculateWinnings();
        int winAmount = points * bet * 3;
        winnings += winAmount;
        balance += winAmount;
    }

    public int getBalance() {
        return balance;
    }

    private void playWinSound() {
        try {
            URL url = this.getClass().getClassLoader().getResource("win.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    private void playLoseSound() {
        try {
            URL url = this.getClass().getClassLoader().getResource("lose.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
    
    public void drawMe(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(20, 20, 340, 240);

        g.setColor(Color.WHITE);
        g.fillRect(45, 60, 70, 70);
        g.fillRect(145, 60, 70, 70);
        g.fillRect(245, 60, 70, 70);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 36));
        g.drawString(String.valueOf(num1), 65, 110);
        g.drawString(String.valueOf(num2), 165, 110);
        g.drawString(String.valueOf(num3), 265, 110);

        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Balance: $" + balance, 30, 160);
        g.drawString("Winnings: $" + winnings, 30, 185);
        
        displayPayoutTable(g);
    }

    public void displayPayoutTable(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        g.drawString("PAYOUT TABLE:", 30, 220);
        g.drawString("777 = 100 points", 30, 240);
        g.drawString("3 of a kind = 5 points", 200, 220);
        g.drawString("2 of a kind = 1 point", 200, 240);
    }

}
