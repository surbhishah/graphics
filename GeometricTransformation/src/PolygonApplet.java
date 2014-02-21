import graphics.AxesUtility;
import graphics.Point;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

import shapes.Polygon;


@SuppressWarnings("serial")
public class PolygonApplet extends JApplet{
	@Override
	public void paint(Graphics g){
		Point coordinateCenter = new Point(400, 400);
		AxesUtility.drawCoordinateSystem(this, g, Color.BLACK, 100,
				coordinateCenter);
		AxesUtility.drawAxes(this, g, coordinateCenter, Color.RED);
		Point vertices[]= new Point[3];
		vertices[0]= new Point(0,0);
		vertices[1]= new Point(100,100);
		vertices[2]= new Point(50,200);
		Polygon polygon = new Polygon(vertices, Color.RED);
		polygon.draw(g, coordinateCenter);
		
	}
}
