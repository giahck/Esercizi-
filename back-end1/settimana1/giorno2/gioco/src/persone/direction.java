import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class direction extends JFrame implements KeyListener {

    public direction() {
        setTitle("Direction");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.addKeyListener(this);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            direction example = new direction();
            example.setVisible(true);
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key typed");
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Tasto UP premuto!");
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Tasto DOWN premuto!");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Metodo non utilizzato per questo esempio
    }
}