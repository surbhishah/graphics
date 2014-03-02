import fillAlgorithms.BoundaryFillAlgorithm;
import fillAlgorithms.FloodFillAlgorithm;
import graphics.AxesUtility;
import graphics.Point;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JApplet;

@SuppressWarnings("serial")
public class FillApplet extends JApplet {
	@Override
	public void paint(Graphics g) {
		try {
			checkBoundaryFill(g);
			g.clearRect(0, 0, this.getWidth(), this.getHeight());
			checkFloodFill(g);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void checkFloodFill(Graphics g){
		// Center of the coordinate system
		Point coordinateCenter = new Point(400, 400);
		Point vertices[] = new Point[3];
		// These vertices are with respect to the center of coordinate
		// center defined above
		vertices[0] = new Point(-50, 50);
		vertices[1] = new Point(50, 0);
		vertices[2] = new Point(0, -50);
		Point startingPoint = new Point(0, 0);
		Color outsideColor = Color.YELLOW;
		Color oldColor = Color.WHITE;
		Color fillColor = Color.RED;
		int xPoints[] = new int[vertices.length];
		int yPoints[] = new int[vertices.length];
		Point translated[] = new Point[vertices.length];
		for (int i = 0; i < vertices.length; i++) {
			translated[i] = vertices[i].translate(coordinateCenter);
			xPoints[i] = translated[i].x;
			yPoints[i] = translated[i].y;
		}

		BufferedImage img = new BufferedImage(this.getWidth(),
				this.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2D = img.createGraphics();
		g2D.setColor(outsideColor);
		g2D.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2D.setColor(Color.WHITE);
		g2D.fillPolygon(xPoints, yPoints, 3);
		startingPoint = startingPoint.translate(coordinateCenter);
		FloodFillAlgorithm algo = new FloodFillAlgorithm();
		algo.fill(img, startingPoint.x, startingPoint.y, fillColor,
				oldColor);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), 0, 0,
				this.getWidth(), this.getHeight(), null);
		AxesUtility.drawCoordinateSystem(this, g, Color.BLACK, 100, coordinateCenter);
		
	}
	private void checkBoundaryFill(Graphics g){
		// Center of the coordinate system
		Point coordinateCenter = new Point(400, 400);
		Point vertices[] = new Point[3];
		// These vertices are with respect to the center of coordinate
		// center defined above
		vertices[0] = new Point(-50, 50);
		vertices[1] = new Point(50, 0);
		vertices[2] = new Point(0, -50);
		Point startingPoint = new Point(0, 0);
		Color boundaryColor = Color.BLACK;
		Color fillColor = Color.GREEN;
		int xPoints[] = new int[vertices.length];
		int yPoints[] = new int[vertices.length];
		Point translated[] = new Point[vertices.length];
		for (int i = 0; i < vertices.length; i++) {
			translated[i] = vertices[i].translate(coordinateCenter);
			xPoints[i] = translated[i].x;
			yPoints[i] = translated[i].y;
		}

		BufferedImage img = new BufferedImage(this.getWidth(),
				this.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2D = img.createGraphics();
		g2D.setColor(Color.WHITE);
		g2D.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2D.setColor(boundaryColor);
		g2D.drawPolygon(xPoints, yPoints, 3);
		startingPoint = startingPoint.translate(coordinateCenter);
		BoundaryFillAlgorithm algo = new BoundaryFillAlgorithm();
		algo.fill(img, startingPoint.x, startingPoint.y, fillColor,
				boundaryColor);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), 0, 0,
				this.getWidth(), this.getHeight(), null);
		AxesUtility.drawCoordinateSystem(this, g, Color.BLACK, 100, coordinateCenter);
		
	}
}
