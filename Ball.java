import java.awt.Graphics2D;
import java.awt.Rectangle;

class Ball{
    //initialize ball position and initial velocity
    int x = 0, y = 0, xa = 1, ya = 1;
    // Create ball size
    private static final int DIAMETER = 30;
    private Game game;

    public Ball(Game game) {
        this.game = game;
    }

    void move(){
        if (x + xa < 0)
            xa = game.speed;
        if (x + xa > game.getWidth() - DIAMETER)
            xa = -game.speed;
        if (y+ya < 0)
            ya = game.speed;
        if (y + ya > game.getHeight() - DIAMETER)
            game.gameOver();
        if (collision()){
            ya = -game.speed;
            y = game.paddle.getTopY() - DIAMETER;
            game.speed++;
        }
            // Move ball
        x = x + xa;
        y = y + ya;
        }

    public void paint(Graphics2D g){
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }
    private boolean collision(){
        // its going through the
        return game.paddle.getBounds().intersects(getBounds());
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}