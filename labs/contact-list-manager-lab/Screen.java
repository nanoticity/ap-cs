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

/**
 * Screen panel for the contact list manager.
 *
 * - Uses a dynamic List<Contact> so contacts can be added at runtime.
 * - Provides a single search field and five search buttons (first, last,
 *   username, domain, extension).
 * - Adds new contacts through a sequence of JOptionPane input dialogs.
 * - Draws the full contact list on the left and search results on the right.
 *
 * Note: this class expects a Contact class with getFirstName(), getLastName(),
 * and getEmail() methods.
 */
public class Screen extends JPanel implements ActionListener {

  private static final long serialVersionUID = 1L;

  private JButton bFirst, bLast, bUser, bDomain, bExt, bNew;
  private JTextField t1;
  private String searchQuery = "";
  private String searchMode = "";
  private List<Contact> contacts;
  private List<Integer> results; // indices into contacts for matches

  public Screen() {
    // keep using manual layout to match existing drawing code but avoid overlaps
    setLayout(null);

    // Search field and placeholder
    t1 = new JTextField(20);
    t1.setBounds(50, 50, 350, 30);
    // TextPrompt is optional; if not present it won't compile — ensure class exists
    try {
      new TextPrompt("Enter your search term", t1);
    } catch (Throwable ignore) {
      // If TextPrompt is not available, ignore — field will just be plain.
    }
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

    // New contact button placed below the search field to avoid overlap
    bNew = new JButton("New Contact");
    bNew.setBounds(50, 90, 140, 30);
    bNew.addActionListener(this);
    add(bNew);

    // Initialize dynamic contact list
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

    // background
    g.setColor(Color.white);
    g.fillRect(0, 0, getWidth(), getHeight());

    Font font = new Font("Arial", Font.PLAIN, 18);

    // Left: full contacts list
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

    // Right: search results
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

  /**
   * Prompts the user for a new contact's first name, last name and email using
   * JOptionPane input dialogs. Validates input and appends the new Contact to
   * the dynamic list.
   */
  private void addNewContact() {
    String first = JOptionPane.showInputDialog(
      this,
      "First Name:",
      "New Contact",
      JOptionPane.PLAIN_MESSAGE
    );
    if (first == null) return; // user cancelled
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

    // All validations passed — add contact
    contacts.add(new Contact(first, last, email));

    // Clear previous results when a new contact is added
    results.clear();
    searchMode = "";

    // repaint to show the new contact
    repaint();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();
    searchQuery = t1.getText().trim().toLowerCase();

    // Clear previous results
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
