import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Screen extends JPanel implements ActionListener {

  private static final long serialVersionUID = 1L;

  private JButton bFirst, bLast, bUser, bDomain, bExt, bNew;
  private JTextField t1;
  private String searchQuery = "";
  private String searchMode = "";
  private List<Contact> contacts;
  private List<Integer> results;

  public Screen() {
    setLayout(null);

    t1 = new JTextField(20);
    t1.setBounds(50, 50, 350, 30);
    try {
      new TextPrompt("Enter your search term", t1);
    } catch (Throwable ignore) { }
    add(t1);

    int bx = 420;
    bFirst = new JButton("First");
    bFirst.setBounds(bx, 50, 100, 30);
    bFirst.addActionListener(this);
    add(bFirst);

    bLast = new JButton("Last");
    bLast.setBounds(bx + 110, 50, 100, 30);
    bLast.addActionListener(this);
    add(bLast);

    bUser = new JButton("Username");
    bUser.setBounds(bx + 220, 50, 120, 30);
    bUser.addActionListener(this);
    add(bUser);

    bDomain = new JButton("Domain");
    bDomain.setBounds(bx, 90, 120, 30);
    bDomain.addActionListener(this);
    add(bDomain);

    bExt = new JButton("Extension");
    bExt.setBounds(bx + 130, 90, 120, 30);
    bExt.addActionListener(this);
    add(bExt);

    bNew = new JButton("New Contact");
    bNew.setBounds(50, 90, 140, 30);
    bNew.addActionListener(this);
    add(bNew);

    contacts = new ArrayList<>();
    results = new ArrayList<>();

    contacts.add(new Contact("James", "Hall", "james.hall@gmail.com"));
    contacts.add(new Contact("Jane", "Smith", "jane.smith@gmail.com"));
    contacts.add(new Contact("John", "Doe", "john.doe@gmail.com"));
    contacts.add(new Contact("Mary", "Jane", "mary.jane@mit.edu"));
    contacts.add(new Contact("Bob", "Smith", "bob.smith@gmail.com"));

    setFocusable(true);
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(1000, 600);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setColor(Color.white);
    g.fillRect(0, 0, getWidth(), getHeight());

    Font font = new Font("Arial", Font.PLAIN, 18);

    g.setColor(Color.black);
    g.setFont(font);
    g.drawString("Contacts:", 50, 160);
    Font listFont = new Font("Monospaced", Font.PLAIN, 14);
    g.setFont(listFont);
    int startY = 185;
    for (int i = 0; i < contacts.size(); i++) {
      Contact c = contacts.get(i);
      String line =
        (i + 1) +
        ". " +
        c.getFirstName() +
        " " +
        c.getLastName() +
        " - " +
        c.getEmail();
      g.drawString(line, 50, startY + i * 20);
    }

    g.setFont(font);
    g.setColor(Color.MAGENTA.darker());
    g.drawString(
      "Search results (" + (searchMode.isEmpty() ? "none" : searchMode) + "):",
      420,
      160
    );
    g.setFont(listFont);
    int ry = 185;
    int hits = 0;
    if (!results.isEmpty()) {
      for (int idx : results) {
        if (idx >= 0 && idx < contacts.size()) {
          Contact c = contacts.get(idx);
          g.setColor(Color.black);
          g.drawString(
            (hits + 1) +
              ". " +
              c.getFirstName() +
              " " +
              c.getLastName() +
              " - " +
              c.getEmail(),
            420,
            ry + hits * 20
          );
          hits++;
        }
      }
    }
    if (hits == 0) {
      g.setColor(Color.gray);
      g.drawString("No matches", 420, ry);
    }
  }

  private void addNewContact() {
    String first = JOptionPane.showInputDialog(
      this,
      "First Name:",
      "New Contact",
      JOptionPane.PLAIN_MESSAGE
    );
    if (first == null) return;
    first = first.trim();
    if (first.isEmpty()) {
      JOptionPane.showMessageDialog(
        this,
        "First name cannot be empty.",
        "Input Error",
        JOptionPane.ERROR_MESSAGE
      );
      return;
    }

    String last = JOptionPane.showInputDialog(
      this,
      "Last Name:",
      "New Contact",
      JOptionPane.PLAIN_MESSAGE
    );
    if (last == null) return;
    last = last.trim();
    if (last.isEmpty()) {
      JOptionPane.showMessageDialog(
        this,
        "Last name cannot be empty.",
        "Input Error",
        JOptionPane.ERROR_MESSAGE
      );
      return;
    }

    String email = JOptionPane.showInputDialog(
      this,
      "Email (e.g. user@domain.com):",
      "New Contact",
      JOptionPane.PLAIN_MESSAGE
    );
    if (email == null) return;
    email = email.trim();
    if (
      email.isEmpty() ||
      !email.contains("@") ||
      email.startsWith("@") ||
      email.endsWith("@")
    ) {
      JOptionPane.showMessageDialog(
        this,
        "Please enter a valid email address.",
        "Input Error",
        JOptionPane.ERROR_MESSAGE
      );
      return;
    }

    contacts.add(new Contact(first, last, email));

    results.clear();
    searchMode = "";

    repaint();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();
    searchQuery = t1.getText().trim().toLowerCase();

    results.clear();

    if (src == bFirst) {
      searchMode = "first";
      if (!searchQuery.isEmpty()) {
        for (int i = 0; i < contacts.size(); i++) {
          if (
            contacts.get(i).getFirstName().toLowerCase().contains(searchQuery)
          ) results.add(i);
        }
      }
    } else if (src == bLast) {
      searchMode = "last";
      if (!searchQuery.isEmpty()) {
        for (int i = 0; i < contacts.size(); i++) {
          if (
            contacts.get(i).getLastName().toLowerCase().contains(searchQuery)
          ) results.add(i);
        }
      }
    } else if (src == bUser) {
      searchMode = "user";
      if (!searchQuery.isEmpty()) {
        for (int i = 0; i < contacts.size(); i++) {
          String eaddr = contacts.get(i).getEmail().toLowerCase();
          int at = eaddr.indexOf('@');
          if (at > 0) {
            String user = eaddr.substring(0, at);
            if (user.contains(searchQuery)) results.add(i);
          }
        }
      }
    } else if (src == bDomain) {
      searchMode = "domain";
      if (!searchQuery.isEmpty()) {
        for (int i = 0; i < contacts.size(); i++) {
          String eaddr = contacts.get(i).getEmail().toLowerCase();
          int at = eaddr.indexOf('@');
          int lastDot = eaddr.lastIndexOf('.');
          if (at >= 0 && lastDot > at) {
            String domain = eaddr.substring(at + 1, lastDot);
            if (domain.contains(searchQuery)) results.add(i);
          }
        }
      }
    } else if (src == bExt) {
      searchMode = "ext";
      if (!searchQuery.isEmpty()) {
        for (int i = 0; i < contacts.size(); i++) {
          String eaddr = contacts.get(i).getEmail().toLowerCase();
          int lastDot = eaddr.lastIndexOf('.');
          if (lastDot >= 0 && lastDot < eaddr.length() - 1) {
            String ext = eaddr.substring(lastDot + 1);
            if (ext.contains(searchQuery)) results.add(i);
          }
        }
      }
    } else if (src == bNew) {
      addNewContact();
    } else {
      searchMode = "";
    }

    repaint();
  }
}
