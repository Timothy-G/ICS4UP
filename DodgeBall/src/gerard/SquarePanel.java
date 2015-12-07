package gerard;

import java.awt.Graphics;

public class SquarePanel extends MovingObject implements Runnable {
	
	private int width = 150;
	private int length = 20;
	private boolean grow = false;
	private int delay = 0;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param left
	 * @param right
	 * @param top
	 * @param bottom
	 */
	public SquarePanel(double x, double y, int left, int right, int top, int bottom){
		super(x, y, left + 10, right - 10, top + 10, bottom - 10);
	}
	/**
	 * Makes the paddles grow and shrink
	 * @throws InterruptedException 
	 */
	public void animateOneStep(){
	
		if(delay % 1000 == 0){
			grow = !grow;
		for(int i = 0; i <= 10; i++){
			if(grow)
			width += 10;
			if(!grow) 
				width -= 10;
			}
		}
		delay++;
	}
	
	/**
	 * Draws the rectangle on the screen 
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		int drawX = (int) getX();
		int drawY = (int) getY();
		g.fillRect(drawX, drawY, length, width);
	}

	public int getwidth(){
		return width;
	}
	
}
