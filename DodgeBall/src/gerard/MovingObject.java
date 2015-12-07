package gerard;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Superclass for a generic moving object. This class takes care of the x and y
 * location (should be the centre of the object), the x and y speed, the color,
 * and the top, bottom, left, and right edges of the screen. <br>
 * <br>
 * 
 * The class implements a thread that updates the objects' position every 10 ms
 * (by default). At each step, the x and y position are updated based on the x
 * and y speed. Then collisions with the edge of the screen are checked, and the
 * x and y speeds are reversed if necessary.<br>
 * <br>
 * 
 * The class also calls animateOneStep() for each update. If the object designer
 * wishes, they can put code in this method that controls the appearance of the
 * object, causing it to morph in some way as it moves.<br>
 * <br>
 * 
 * <b>Requirements:</b> Object designers must create a subclass of
 * MovingObject. They must make use the MovingObject constructor (or no thread
 * will start). They must implement the draw() and animateOneStep() methods.<br>
 * <br>
 * 
 * @version November 2015.
 * 
 * @author Christina Kemp adapted from Sam Scott
 */
public abstract class MovingObject implements Runnable {

	/**
	 * The x location of the object.
	 */
	private double x;
	/**
	 * The y location of the object.
	 */
	private double y;
	/**
	 * The x speed of the object.
	 */
	private double xSpeed;
	/**
	 * The y speed of the object.
	 */
	private double ySpeed;
	/**
	 * The left edge for bouncing.
	 */
	private int left;
	/**
	 * The right edge for bouncing.
	 */
	private int right;
	/**
	 * The top edge for bouncing.
	 */
	private int top;
	/**
	 * The bottom edge for bouncing.
	 */
	private int bottom;
	/**
	 * Length of pause between position updates. Related to speed of object.
	 * (Defaults to 10).
	 */
	private int pauseDuration;
	/**
	 * Object color (defaults to black)
	 */
	protected Color color;
	/**
	 * Set to false to stop the thread.
	 */
	private boolean moving;

	/**
	 * Sets default color and pauseDuration values. Sets speed to 0. Starts
	 * thread. Every subclass of MovingObject must use this constructor.
	 * 
	 * @param x
	 *            Initial x position.
	 * @param y
	 *            Initial y position.
	 * @param left
	 *            Left edge for bouncing.
	 * @param right
	 *            Right edge for bouncing.
	 * @param top
	 *            Top edge for bouncing.
	 * @param bottom
	 *            Bottom edge for bouncing.
	 */
	public MovingObject(double x, double y, int left, int right, int top,
			int bottom) {
		this.pauseDuration = 40;
		this.xSpeed = 0;
		this.ySpeed = 0;
		this.color = Color.black;
		this.x = x;
		this.y = y;
		this.left = left;
		this.right = right;
		this.top = top;
		this.bottom = bottom;
		startThread();
	}

	/**
	 * Starts the movement thread.
	 */
	public void startThread() {
		moving = true;
		Thread t = new Thread(this);
		t.start();
	}

	/**
	 * Stops the movement thread by terminating the main loop in run().
	 */
	public void stopThread() {
		moving = false;
	}

	/**
	 * Updates the x and y values in an infinite loop. If object hits an edge, x
	 * or y speed is reversed as appropriate.
	 */
	public void run() {
		while (moving) {
			animateOneStep();
			x += xSpeed;
			y += ySpeed;
			if (y >= bottom | y <= top)
				ySpeed *= -1;
			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
			}
		}
	}

	/**
	 * Draws the object.
	 * 
	 * @param g
	 *            The graphics context
	 */
	abstract public void draw(Graphics g);

	/**
	 * Performs one step of animation.
	 */
	abstract public void animateOneStep();
	
	/**
	 * Returns the x location.
	 * 
	 * @return
	 *            the current x position.
	 */
	public double getX() {
		return x;
	}
	/**
	 *  getting the current position of the ball on right side of screen 
	 * @return
	 */
	
	public int getRight(){
		return right;
	}
	/**
	 *  getting the current position of the ball on left side of screen 
	 * @return
	 */
	public int getLeft(){
		return left;
	}

	/**
	 * Returns the y location.
	 * 
	 * @return
	 *            the current y position
	 */
	public double getY() {
		return y;
	}
	
	public double getXspeed(){
		return xSpeed;
	}
	
	public double getYspeed(){
		return ySpeed;
	}
	
	/**
	 * Sets the x speed.
	 * 
	 * @param xSpeed
	 *            New x speed.
	 */
	public void setXSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	/**
	 * Sets the y speed.
	 * 
	 * @param ySpeed
	 *            New y speed.
	 */
	public void setYSpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}

	/**
	 * Sets the x location.
	 * 
	 * @param x
	 *            New x location.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Sets the y location.
	 * 
	 * @param y
	 *            New y location.
	 */
	public void setY(int y) {
		this.y = y;
	}


	/**
	 * Sets color of object.
	 * 
	 * @param color
	 *            New color.
	 */
	public void setColor(Color color) {
		this.color = color;
	}
}
