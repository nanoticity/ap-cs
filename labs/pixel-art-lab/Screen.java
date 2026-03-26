import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.PrintWriter;
import java.util.Scanner;

public class Screen extends JPanel {
  private static final int GRID_SIZE = 15;
  private static final int PIXEL_SIZE = 40;
  private static final int PALETTE_HEIGHT = 60;
  private static final int PALETTE_COLOR_SIZE = 40;

  private Node[][] grid;
  private int selectedColorR = 0;
  private int selectedColorG = 0;
  private int selectedColorB = 0;
  private JButton clearButton;
  private JButton saveButton;
  private JButton loadButton;

  public Screen() {
    grid = new Node[GRID_SIZE][GRID_SIZE];
    initializeGrid();
    setupMouseListener();
    setupButtons();
  }

  private void initializeGrid() {
    for (int i = 0; i < GRID_SIZE; i++) {
      for (int j = 0; j < GRID_SIZE; j++) {
        grid[i][j] = new Node(255, 255, 255);
      }
    }
  }

  private void setupMouseListener() {
    addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (mouseY < PALETTE_HEIGHT) {
          handlePaletteClick(mouseX, mouseY);
        } else {
          handleGridClick(mouseX, mouseY);
        }
        repaint();
      }
    });
    
    addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseDragged(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (mouseY >= PALETTE_HEIGHT) {
          handleGridClick(mouseX, mouseY);
          repaint();
        }
      }
    });
  }

  private void handlePaletteClick(int mouseX, int mouseY) {
    int paletteY = 10;
    int startX = 10;
    int spacing = PALETTE_COLOR_SIZE + 10;

    int[] colors = {
        255, 255, 255,
        0, 0, 0,
        255, 0, 0,
        0, 0, 255,
        255, 255, 0,
        0, 128, 0,
        128, 0, 128
    };

    for (int i = 0; i < colors.length; i += 3) {
      int colorX = startX + (i / 3) * spacing;
      if (mouseX >= colorX && mouseX < colorX + PALETTE_COLOR_SIZE &&
          mouseY >= paletteY && mouseY < paletteY + PALETTE_COLOR_SIZE) {
        selectedColorR = colors[i];
        selectedColorG = colors[i + 1];
        selectedColorB = colors[i + 2];
        return;
      }
    }
  }

  private void handleGridClick(int mouseX, int mouseY) {
    int gridStartY = PALETTE_HEIGHT + 10;
    int gridStartX = 10;

    int relativeX = mouseX - gridStartX;
    int relativeY = mouseY - gridStartY;

    int col = relativeX / PIXEL_SIZE;
    int row = relativeY / PIXEL_SIZE;

    if (col >= 0 && col < GRID_SIZE && row >= 0 && row < GRID_SIZE) {
      System.out.println("Row: " + row + ", Column: " + col);
      grid[row][col].setColor(selectedColorR, selectedColorG, selectedColorB);
    }
  }

  private void setupButtons() {
    setLayout(null);

    clearButton = new JButton("Clear");
    clearButton.setBounds(10, getHeight() - 50, 80, 30);
    clearButton.addActionListener(e -> clearGrid());
    add(clearButton);

    saveButton = new JButton("Save");
    saveButton.setBounds(100, getHeight() - 50, 80, 30);
    saveButton.addActionListener(e -> saveImage());
    add(saveButton);

    loadButton = new JButton("Load");
    loadButton.setBounds(190, getHeight() - 50, 80, 30);
    loadButton.addActionListener(e -> loadImage());
    add(loadButton);
  }

  private void clearGrid() {
    for (int i = 0; i < GRID_SIZE; i++) {
      for (int j = 0; j < GRID_SIZE; j++) {
        grid[i][j].setColor(255, 255, 255);
      }
    }
    repaint();
  }

  private void saveImage() {
    try (PrintWriter fw = new PrintWriter(new FileWriter("pixel_art.txt"))) {
      for (int i = 0; i < GRID_SIZE; i++) {
        for (int j = 0; j < GRID_SIZE; j++) {
          fw.print(grid[i][j].getColorCode());
          if (j < GRID_SIZE - 1)
            fw.print(" ");
        }
        fw.println();
      }
      JOptionPane.showMessageDialog(this, "Image saved to pixel_art.txt");
    } catch (IOException e) {
      JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage());
    }
  }

  private void loadImage() {
    try {
      File toload = new File("/Users/ari/Documents/ap-cs/pixel-art-lab/pixel_art.txt");
      Scanner scanner = new Scanner(toload);
      for (int i = 0; i < GRID_SIZE; i++) {
        for (int j = 0; j < GRID_SIZE; j++) {
          if (!scanner.hasNext()) {
            break;
          }
          int code = parseColorCode(scanner.next());
          Node.setColorFromCode(grid[i][j], code);
        }
      }
      scanner.close();
      repaint();
      JOptionPane.showMessageDialog(this, "Image loaded from pixel_art.txt");
    } catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(this, "File not found: pixel_art.txt");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Error loading file: " + e.getMessage());
      System.out.println("error message " + e.getMessage());
    }
  }

  private int parseColorCode(String token) {
    try {
      return Integer.parseInt(token);
    } catch (NumberFormatException e) {
      if (token.length() == 1) {
        int legacyCode = token.charAt(0);
        if (legacyCode >= 0 && legacyCode <= 6) {
          return legacyCode;
        }
      }
      throw e;
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawPalette(g);
    drawGrid(g);
    drawButtons();
  }

  private void drawPalette(Graphics g) {
    g.setColor(new Color(200, 200, 200));
    g.fillRect(0, 0, getWidth(), PALETTE_HEIGHT);

    int[] colors = {
        255, 255, 255,
        0, 0, 0,
        255, 0, 0,
        0, 0, 255,
        255, 255, 0,
        0, 128, 0,
        128, 0, 128
    };

    int startX = 10;
    int paletteY = 10;
    int spacing = PALETTE_COLOR_SIZE + 10;

    for (int i = 0; i < colors.length; i += 3) {
      int colorX = startX + (i / 3) * spacing;
      g.setColor(new Color(colors[i], colors[i + 1], colors[i + 2]));
      g.fillRect(colorX, paletteY, PALETTE_COLOR_SIZE, PALETTE_COLOR_SIZE);
      g.setColor(Color.BLACK);
      g.drawRect(colorX, paletteY, PALETTE_COLOR_SIZE, PALETTE_COLOR_SIZE);
    }

    g.setColor(new Color(selectedColorR, selectedColorG, selectedColorB));
    g.fillRect(startX + 7 * spacing, paletteY, PALETTE_COLOR_SIZE, PALETTE_COLOR_SIZE);
    g.setColor(Color.BLACK);
    g.drawString("Selected", startX + 7 * spacing, paletteY + PALETTE_COLOR_SIZE + 15);
  }

  private void drawGrid(Graphics g) {
    int gridStartY = PALETTE_HEIGHT + 10;
    int gridStartX = 10;

    for (int i = 0; i < GRID_SIZE; i++) {
      for (int j = 0; j < GRID_SIZE; j++) {
        int x = gridStartX + j * PIXEL_SIZE;
        int y = gridStartY + i * PIXEL_SIZE;
        grid[i][j].drawMe(x, y, PIXEL_SIZE, g);
      }
    }
  }

  private void drawButtons() {
    if (clearButton != null) {
      clearButton.setBounds(10, getHeight() - 50, 80, 30);
    }
    if (saveButton != null) {
      saveButton.setBounds(100, getHeight() - 50, 80, 30);
    }
    if (loadButton != null) {
      loadButton.setBounds(190, getHeight() - 50, 80, 30);
    }
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(700, 750);
  }
}
