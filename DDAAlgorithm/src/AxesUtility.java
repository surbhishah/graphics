import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D.Double;
import javax.swing.JApplet;
public class AxesUtility {

	
	public static Point translateAxes(Point p, Point center){
		return new Point(center.x+ p.x,center.y -p.y);	
	}
	
	
	public static Double translateAxes(Double p, Point center){
		return new Double(center.x+ p.x,center.y -p.y);	
	}
	
	
	public static void drawAxes(JApplet applet,Graphics g, Point center, Color color){
		g.setColor(color);
		g.drawLine(0,center.y,applet.getWidth(),center.x);
		g.drawLine(center.x,0,center.y,applet.getHeight());
	}
}
