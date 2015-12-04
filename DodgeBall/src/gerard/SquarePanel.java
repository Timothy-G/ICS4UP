package gerard;

import java.awt.Graphics;

public class SquarePanel extends MovingObject implements Runnable {
	
	private int length = 5;
	private int width = 2;

	
	public SquarePanel(double x, double y, int left, int right, int top, int bottom){
		super(x, y, left + 10, right - 10, top + 10, bottom - 10);
	}
	
	public void animateOneStep(){
		for(int i = 0; i <= 10; i++){
			length++;
			if (length > 15){
				length--;
				
			}
		}
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
}
