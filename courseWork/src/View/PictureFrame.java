package View;
import java.awt.*;
import Controller.*;

import javax.swing.*;

import Model.*;

public class PictureFrame {
  public int[] reroll = null;
  Aardvark master = null;

  public class DominoPanel extends JPanel {
    private static final long serialVersionUID = 4190229282411119364L;
    public static final int rngColValue = 20;
    public static final int rngDrawValue = 30;

    public void drawGrid(Graphics g) {
      for (int are = 0; are < 7; are++) {
        for (int see = 0; see < 8; see++) {
          drawDigitGivenCentre(g, rngDrawValue + see * rngColValue, rngDrawValue + are * rngColValue, rngColValue,
              master.grid[are][see]);
        }
      }
    }

    public void drawGridLines(Graphics g) {
      g.setColor(Color.LIGHT_GRAY);
      for (int are = 0; are <= 7; are++) {
        g.drawLine(rngColValue, rngColValue + are * rngColValue, 180, rngColValue + are * rngColValue);
      }
      for (int see = 0; see <= 8; see++) {
        g.drawLine(rngColValue + see * rngColValue, rngColValue, rngColValue + see * rngColValue, 160);
      }
    }

    public void drawHeadings(Graphics g) {
      for (int are = 0; are < 7; are++) {
        fillDigitGivenCentre(g, 10, rngDrawValue + are * rngColValue, rngColValue, are+1);
      }

      for (int see = 0; see < 8; see++) {
        fillDigitGivenCentre(g, rngDrawValue + see * rngColValue, 10, rngColValue, see+1);
      }
    }

    public void drawDomino(Graphics g, Domino d) {
      if (d.placed) {
        int y = Math.min(d.ly, d.hy);
        int x = Math.min(d.lx, d.hx);
        int w = Math.abs(d.lx - d.hx) + 1;
        int h = Math.abs(d.ly - d.hy) + 1;
        g.setColor(Color.WHITE);
        g.fillRect(rngColValue + x * rngColValue, rngColValue + y * rngColValue, w * rngColValue, h * rngColValue);
        g.setColor(Color.RED);
        g.drawRect(rngColValue + x * rngColValue, rngColValue + y * rngColValue, w * rngColValue, h * rngColValue);
        drawDigitGivenCentre(g, rngDrawValue + d.hx * rngColValue, rngDrawValue + d.hy * rngColValue, rngColValue, d.high,
            Color.BLUE);
        drawDigitGivenCentre(g, rngDrawValue + d.lx * rngColValue, rngDrawValue + d.ly * rngColValue, rngColValue, d.low,
            Color.BLUE);
      }
    }

    void drawDigitGivenCentre(Graphics g, int x, int y, int diameter, int n) {
      int radius = diameter / 2;
      g.setColor(Color.BLACK);
      // g.drawOval(x - radius, y - radius, diameter, diameter);
      FontMetrics fm = g.getFontMetrics();
      String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
    }

    void drawDigitGivenCentre(Graphics g, int x, int y, int diameter, int n,
        Color c) {
      int radius = diameter / 2;
      g.setColor(c);
      // g.drawOval(x - radius, y - radius, diameter, diameter);
      FontMetrics fm = g.getFontMetrics();
      String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
    }

    void fillDigitGivenCentre(Graphics g, int x, int y, int diameter, int n) {
      int radius = diameter / 2;
      g.setColor(Color.GREEN);
      g.fillOval(x - radius, y - radius, diameter, diameter);
      g.setColor(Color.BLACK);
      g.drawOval(x - radius, y - radius, diameter, diameter);
      FontMetrics fm = g.getFontMetrics();
      String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
    }

    protected void paintComponent(Graphics g) {
      g.setColor(Color.YELLOW);
      g.fillRect(0, 0, getWidth(), getHeight());

      if (master.mode == 1) {
        drawGridLines(g);
        drawHeadings(g);
        drawGrid(g);
        master.drawGuesses(g);
      }
      if (master.mode == 0) {
        drawGridLines(g);
        drawHeadings(g);
        drawGrid(g);
        master.drawDominoes(g);
      }
    }

    public Dimension getPreferredSize() {
      return new Dimension(202, 182);
    }
  }

  public DominoPanel dp;

  public void PictureFrame(Aardvark sf) {
    master = sf;
    if (dp == null) {
      JFrame f = new JFrame("Abominodo");
      dp = new DominoPanel();
      f.setContentPane(dp);
      f.pack();
      f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      f.setVisible(true);
    }
  }

  public void reset() {
   

  }

}
