import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JPanel implements ActionListener {
    private JButton submitButton;
    private JTextField betField;

    private SlotMachine slotMachine = new SlotMachine(100);

    public Screen() {
        this.setLayout(null);
        submitButton = new JButton("spin");
        submitButton.setBounds(400, 100, 200, 40);
        submitButton.addActionListener(this);
        this.add(submitButton);

        betField = new JTextField(20);
        betField.setBounds(400, 50, 100, 30);
        betField.addActionListener(this);
        this.add(betField);

        JLabel betLabel = new JLabel("Bet Amount:");
        betLabel.setBounds(400, 25, 100, 20);
        this.add(betLabel);

        this.setFocusable(true);
    }

    public Dimension getPreferredSize() {
        return new Dimension(650    , 300);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        slotMachine.drawMe(g);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            int bet = Integer.parseInt(betField.getText());
            if (bet > 0 && bet <= slotMachine.getBalance()) {
                slotMachine.spin(bet);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid bet amount.");
            }
            repaint();
        }
    }

    
}
