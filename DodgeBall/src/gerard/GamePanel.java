package gerard;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is the beginning of a simple game. You should expand it into a dodgeball
 * game, where the user controls an object with the mouse or keyboard, and tries
 * to avoid the balls flying around the screen. If they get hit, it's game over.
 * If they survive for 20 seconds (or some other fixed time), they go on to the
 * next level. <br>
 * <br>
 * Should be run at around 500x300 pixels.<br>
 * <br>
 * @version Nov. 2015
 * 
 * @author Christina Kemp adapted from Sam Scott
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener {


	int width = 1000;
	int height = 600;

	/**
	 * The number of balls on the screen.
	 */
	final int numBalls = 1;
	/**
	 * Paddle number 1
	 */
	final int numPaddles = 2;
	/**
	 * The pause between repainting (should be set for about 30 frames per
	 * second).
	 */
	final int pauseDuration = 50;
	/**
	 * An array of balls.
	 */
	FlashingBall[] ball = new FlashingBall[numBalls];
	/**
	 * An array of paddles.
	 */
	SquarePanel[] paddel = new SquarePanel[numPaddles];

	/** main program (entry point) */
	public static void main(String[] args) {

		// Set up main window (using Swing's Jframe)
		JFrame frame = new JFrame("Dodgeball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 300));
		frame.setAutoRequestFocus(false);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		c.add(new GamePanel());
		frame.pack();


	}

	public GamePanel(){
		// Start the ball bouncing (in its own thread)
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.BLACK);
		
		for (int i = 0; i < numBalls; i++) {
			ball[i] = new FlashingBall(500, 300, 0, width, 0, height);
			ball[i].setXSpeed(16-4);
			ball[i].setYSpeed(Math.random() * 16-4);
			ball[i].setColor(new Color((int) (Math.random() * 256), (int) (Math
					.random() * 256), (int) (Math.random() * 256)));
		}

			//places 1 of the paddles on the screen
			paddel[0] = new SquarePanel(20, 20, 0, width, 0, height);	
			paddel[0].setYSpeed(Math.random() * 16-4);	
			//places 1 of the paddles on the screen
			paddel[1] = new SquarePanel(960, 20, 0, width, 0, height);
			paddel[1].setYSpeed(Math.random() * 16-4);	
		
		Thread gameThread = new Thread(this);
		gameThread.start();

	}

	/**
	 * Repaints the frame periodically.
	 */
	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
			}
		}
	}

	/**
	 * Clears the screen and paints the balls.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < numBalls; i++) {
			ball[i].draw(g);
		}
		/**
		 * Clears the screen and paints the paddles.
		 */
		for (int i = 0; i < numPaddles; i++) {
			paddel[i].draw(g);
			g.setColor(Color.ORANGE);
		}
		/**
		 * Clears the screen and paints the paddles.
		 */
		for (int i = 0; i < numPaddles; i++) {
			paddel[i].draw(g);
			g.setColor(Color.RED);
		}
	}
	
char key = ' ';
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	 /**
	    * 
	    * @param e Thekeyboard event
	    **/
	    public void keyReleased (KeyEvent e)
	    {
		key = ' ';
		repaint ();
	    }


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
