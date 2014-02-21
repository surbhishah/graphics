import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D.Double;
public class Circle {
	
	public static void drawCircle(Graphics g, Point center,int radius, Color color){
		g.setColor(color);
		g.drawOval(center.x-radius, center.y-radius, 2*radius, 2*radius);
	}
	
	public static void drawCircle(Graphics g, Double center, double radius,Color color){
		g.setColor(color);
		g.drawOval((int)Math.round(center.x-radius),(int) Math.round(center.y-radius), (int)(2*radius), (int)(2*radius));
	}
	
	public static void fillCircle(Graphics g, Point center, int radius,Color c){
		g.setColor(c);
		g.fillOval(center.x-radius, center.y-radius, 2*radius, 2*radius);
	}
	
	public static void fillCircle(Graphics g, Double center, double radius,Color c){
		g.setColor(c);
		g.fillOval((int)Math.round(center.x-radius), (int)Math.round(center.y-radius), (int)(2*radius), (int)(2*radius));
	}
	
}
