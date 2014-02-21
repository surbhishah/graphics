import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JApplet;
public class Line extends JApplet{
	public void paint(Graphics g){
		Point center = new Point(400,400);
		AxesUtility.drawAxes(this, g, center, Color.GREEN);
		Point point1 = new Point(0,0);
		Point point2 = new Point(50,100);
		Point point3 = new Point(-50,100);
		Point point4 = new Point(-50,-100);
		Point point5 = new Point(50,-100);
		point1 = AxesUtility.translateAxes(point1, center);
		point2 = AxesUtility.translateAxes(point2, center);
		point3 = AxesUtility.translateAxes(point3, center);
		point4 = AxesUtility.translateAxes(point4, center);
		point5 = AxesUtility.translateAxes(point5, center);
		g.setColor(Color.BLUE);
		drawLineDDA(point1.x, point1.y,point2.x, point2.y,g);
		g.setColor(Color.RED);
		drawLineDDA(point1.x, point1.y,point3.x, point3.y,g);
		g.setColor(Color.PINK);
		drawLineDDA(point1.x, point1.y,point4.x, point4.y,g);
		g.setColor(Color.YELLOW);
		drawLineDDA(point1.x, point1.y,point5.x, point5.y,g);
	}
	public void drawLineDDA(int x1, int y1, int x2, int y2, Graphics g){
		int dx = x2-x1;
		int dy = y2-y1;
		int steps;
		if(Math.abs(dx) > Math.abs(dy)){
			steps = Math.abs(dx);
		}
		else{
			steps = Math.abs(dy);
		}
		double xinc = dx/(float)steps;
		double yinc = dy/(float)steps;
		double x=x1,y=y1;
		g.drawLine((int)Math.round(x), (int)Math.round(y),(int)Math.round(x), (int)Math.round(y));
		for(int i=0;i<steps;i++){
			x +=  xinc;
			y +=  yinc;
			g.drawLine((int)Math.round(x), (int)Math.round(y),(int)Math.round(x), (int)Math.round(y));
		}		
	}
}
