import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("Serial")
public class Ball extends JPanel {
    //Initialize ball position
    int x = 0, y = 0, xVelocity = 1, yVelocity = 1;
    int width = 300, height = 400;
    int Diameter = 60;

    private void moveBall() {
        x = x + xVelocity;
        if (x >= width - Diameter){
            xVelocity = -1;
        }
        else if(x <= 0){
            xVelocity =+1;
        }
        
        y = y + yVelocity;
        if (y >= height - Diameter){
            yVelocity = -1;
        }
        else if(y <= 0){
            yVelocity =+1;
        }
    }

    @Override
    public void paint(Graphics g) {
        //This clears the screen before reprinting circle at new position
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        //Antialiasing makes the figure smoother
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Draws the circle at new position with same diameter
        g2d.fillOval(x, y, Diameter, Diameter);
    }
    
    public static void main(String[] args) throws InterruptedException {
        //Name of the window
        JFrame frame = new JFrame("Mini Tennis");
        Ball game = new Ball();
        // add the game object to the frame
        frame.add(game);
        // set window size (width, height)
        frame.setSize(game.width, game.height);
        // initially invisible  so needs to be made visible
        frame.setVisible(true);
        // close the frame when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.moveBall();
            game.repaint();

            /*tells the processor that the thread which is being
            run must sleep for 10 milliseconds. Bigger the number the slower
            the game moves*/
            Thread.sleep(2);
        }
    }
}