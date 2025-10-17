import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Screen extends JPanel implements ActionListener{
  private JTextField pinInput;
  private JButton loginButton; 
  private Bank customer = new Bank("John", 100.99, 1234);
  private boolean loggedIn = false;

  private final String PIN_PLACEHOLDER = "Enter PIN";
  private final String AMOUNT_PLACEHOLDER = "Amount";

  private JTextField amountInput;
  private JButton depositButton;
  private JButton withdrawButton;
  private JButton logoutButton;

  public Screen(){
    setLayout(null);

    pinInput = new JTextField();
    pinInput.setBounds(50, 250, 100, 30);
    // placeholder
    pinInput.setText(PIN_PLACEHOLDER);
    pinInput.setForeground(Color.LIGHT_GRAY);
    pinInput.addFocusListener(new java.awt.event.FocusAdapter() {
      @Override
      public void focusGained(java.awt.event.FocusEvent e) {
        if (pinInput.getText().equals(PIN_PLACEHOLDER)) {
          pinInput.setText("");
          pinInput.setForeground(Color.BLACK);
        }
      }
      @Override
      public void focusLost(java.awt.event.FocusEvent e) {
        if (pinInput.getText().isEmpty()) {
          pinInput.setText(PIN_PLACEHOLDER);
          pinInput.setForeground(Color.LIGHT_GRAY);
        }
      }
    });
    add(pinInput);

    loginButton = new JButton("Login");
    loginButton.setBounds(50, 300, 100, 30);
    loginButton.addActionListener(this);
    add(loginButton);

    amountInput = new JTextField();
    amountInput.setBounds(200, 250, 100, 30);
    // placeholder
    amountInput.setText(AMOUNT_PLACEHOLDER);
    amountInput.setForeground(Color.LIGHT_GRAY);
    amountInput.addFocusListener(new java.awt.event.FocusAdapter() {
      @Override
      public void focusGained(java.awt.event.FocusEvent e) {
        if (amountInput.getText().equals(AMOUNT_PLACEHOLDER)) {
          amountInput.setText("");
          amountInput.setForeground(Color.BLACK);
        }
      }
      @Override
      public void focusLost(java.awt.event.FocusEvent e) {
        if (amountInput.getText().isEmpty()) {
          amountInput.setText(AMOUNT_PLACEHOLDER);
          amountInput.setForeground(Color.LIGHT_GRAY);
        }
      }
    });
    add(amountInput);

    depositButton = new JButton("Deposit");
    depositButton.setBounds(200, 300, 100, 30);
    depositButton.addActionListener(this);
    add(depositButton);

    withdrawButton = new JButton("Withdraw");
    withdrawButton.setBounds(320, 300, 100, 30);
    withdrawButton.addActionListener(this);
    add(withdrawButton);

    logoutButton = new JButton("Logout");
    logoutButton.setBounds(440, 300, 100, 30);
    logoutButton.addActionListener(this);
    add(logoutButton);

  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == loginButton) {
      String pinText = pinInput.getText();
      try {
        int pin = Integer.parseInt(pinText.trim());
        loggedIn = customer.checkPin(pin);
        if (!loggedIn) {
          JOptionPane.showMessageDialog(this, "Incorrect PIN");
        }
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Please enter a numeric PIN");
      }
      repaint();

    } else if (e.getSource() == depositButton) {
      if (!loggedIn) {
        JOptionPane.showMessageDialog(this, "Please login first");
        return;
      }
      String amt = amountInput.getText();
      try {
        double val = Double.parseDouble(amt.trim());
        if (val <= 0) {
          JOptionPane.showMessageDialog(this, "Enter a positive amount");
        } else {
          customer.deposit(val);
        }
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Enter a valid number");
      }
      repaint();

    } else if (e.getSource() == withdrawButton) {
      if (!loggedIn) {
        JOptionPane.showMessageDialog(this, "Please login first");
        return;
      }
      String amt = amountInput.getText();
      try {
        double val = Double.parseDouble(amt.trim());
        if (val <= 0) {
          JOptionPane.showMessageDialog(this, "Enter a positive amount");
        } else if (val > customer.getBalance()) {
          JOptionPane.showMessageDialog(this, "Insufficient funds");
        } else {
          customer.withdraw(val);
        }
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Enter a valid number");
      }
      repaint();

    } else if (e.getSource() == logoutButton) {
      customer.logout();
      loggedIn = false;
      repaint();
    }
  }

  public Dimension getPreferredSize() {
    return new Dimension(800, 600);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);    
    g.setColor(Color.BLACK);
    if (loggedIn) {
      String name = customer.getName();
      String balanceText = customer.getBalance() + "";
      g.drawString("Name: " + name, 50, 50);
      g.drawString("Balance: $" + balanceText, 50, 70);
      g.drawString("(Enter amount and press Deposit or Withdraw)", 50, 90);
    } else {
      g.drawString("Please enter PIN and press Login", 50, 50);
    }
  }
}
