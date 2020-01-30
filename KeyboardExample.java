import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("Serial")
public class KeyboardExample extends JPanel {
    public KeyboardExample() {
        KeyListener listener = new KeyListener() {
            //keyTyped, keyPressed, keyReleased are all LOWERCASE k's
            @Override
            public void keyTyped(KeyEvent e) {
                /* KeyListener(){} must implement the inherited abstact 
                method KeyListener.keyTyped(KeyEvent)*/
            }

            @Override 
            public void keyPressed(KeyEvent e) {
                System.out.println("Key Release = "+ KeyEvent.getKeyText(e.getKeyCode()));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Key Release= "+ KeyEvent.getKeyText(e.getKeyCode()));
            }
        };
        addKeyListener(listener);
        setFocusable(true);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Keyboard");
        KeyboardExample keyboardExample = new KeyboardExample();
        frame.add(keyboardExample);
        frame.setSize(200, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}