// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HauntedHouseAnimation extends JPanel implements ActionListener {
    private int lightIntensity = 0;
    private Timer timer;

    public HauntedHouseAnimation() {
        timer = new Timer(500, this); // Timer for flickering light (500ms interval)
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawHauntedHouse(g);
    }

    private void drawHauntedHouse(Graphics g) {
        // Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // House
        g.setColor(Color.DARK_GRAY);
        g.fillRect(100, 200, 400, 300);

        // Roof
        int[] xPoints = {100, 300, 500};
        int[] yPoints = {200, 100, 200};

        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon(xPoints, yPoints, 3);

        // Door
        g.setColor(Color.DARK_GRAY);
        g.fillRect(275, 350, 100, 150);
        g.setColor(Color.BLACK);
        g.drawRect(275, 350, 100, 150);

        // Windows
        g.setColor(Color.GRAY);
        g.fillRect(150, 250, 80, 80);
        g.fillRect(370, 250, 80, 80);

        // Moon
        g.setColor(Color.WHITE);
        g.fillOval(500, 50, 80, 80);

        // Flickering light inside
        if (lightIntensity > 0) {
            g.setColor(Color.YELLOW);
            g.fillOval(300, 420, 40, 40);
        }
        // Chimeny
        g.setColor(Color.GRAY);
        g.fillRect(100, 100, 100, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lightIntensity = (lightIntensity == 0) ? 255 : 0; // Toggle light intensity
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Haunted House Animation");
        HauntedHouseAnimation animation = new HauntedHouseAnimation();
        frame.add(animation);
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

