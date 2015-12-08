package Model;


import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/*
This class is used for creating the main CatcherIcon character
*/
public class CatcherIcon extends GameIcon {
    
    private int x_position;
    private int y_position;
    
    final int DEFAULT_X_POSITION = 25;
    final int DEFAULT_Y_POSITION = 100;
    
    public CatcherIcon() {
        x_position = DEFAULT_X_POSITION;    // default x-position of catcher
        y_position = DEFAULT_Y_POSITION;   // default y-position of catcher
    }
    
    /**
     * Creates the body of the catcher 
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        
        Graphics2D g2 = (Graphics2D) g;
        
        drawHead(g2);
        drawEyes(g2);
        drawBody(g2);
        drawArms(g2);
        drawLegs(g2);
        
    }
    
    // Draws the head of the catcher
    private void drawHead(Graphics2D g2) {
        
        Ellipse2D.Double head = new Ellipse2D.Double(x_position+10, y_position+10, 30, 20);
        
        g2.setColor(Color.BLACK);
        g2.fill(head);
    }
     
    // Draws the eyes of the catcher
    private void drawEyes(Graphics2D g2) {
        
        Ellipse2D.Double leftEye = new Ellipse2D.Double(x_position+19, y_position+19, 2, 2);
        Ellipse2D.Double rightEye = new Ellipse2D.Double(x_position+30, y_position+19, 2, 2);
        
        g2.setColor(Color.WHITE); 
        g2.fill(leftEye);
        g2.fill(rightEye);
    }
    
    // Draws the body of the catcher
    private void drawBody(Graphics2D g2) {
        Rectangle2D.Double body = new Rectangle2D.Double(x_position+22, y_position+25, 6, 35);
        
        g2.setColor(Color.BLACK);
        g2.fill(body);
    }
    
    // Draws the arms of the catcher
    private void drawArms(Graphics2D g2) {
        Line2D.Double upperArm = new Line2D.Double(x_position+28, y_position+40, x_position+40, y_position+40);
        Line2D.Double lowerArm1 = new Line2D.Double(x_position+28, y_position+40, x_position+15, y_position+50);
        Line2D.Double lowerArm2 = new Line2D.Double(x_position+15, y_position+50, x_position+30, y_position+50);
        
        g2.setColor(Color.BLACK);
        g2.draw(upperArm);
        g2.draw(lowerArm1);
        g2.draw(lowerArm2);
    }
    
    // Draws the legs of the catcher
    private void drawLegs(Graphics2D g2) {
    	
    	Line2D.Double leftLeg = new Line2D.Double(x_position+22, y_position+60, x_position+20, y_position+80);
    	Line2D.Double rightLeg = new Line2D.Double(x_position+28, y_position+60, x_position+30, y_position+80);
    	
    	g2.setColor(Color.BLACK);
    	g2.draw(leftLeg);
    	g2.draw(rightLeg);
    }

    @Override
    public int getIconWidth() {
        return 50;
    }

    @Override
    public int getIconHeight() {
        return 100;
    }
    
    // Returns the x_position of the catcher
    public int getX() {
    	return x_position;
    }
    
    // Returns the y_position of the catcher
    public int getY() {
    	return y_position;
    }
    
    // Sets the x_position to x
    public void setX(int x) {
    	x_position = x;
    }
    
    // Sets the y_position to y
    public void setY(int y) {
    	y_position = y;
    }
    
    /**
     * Checks to see if the CatcherIcon caught a candy
     * @param candy CandyIcon to check if caught.
     * @return true if caught, false otherwise
     */
    public boolean caughtCandy(GameIcon candy) {
    	
    	int x = candy.getX();
    	int y = candy.getY() + candy.getIconHeight()/2;
    	
    	if (x > x_position+20 && x < x_position+60) {
    		if (y > y_position+10 && y < y_position+80) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
}
