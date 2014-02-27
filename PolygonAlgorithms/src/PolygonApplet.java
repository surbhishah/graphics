import exceptions.InvalidMatrixOperationException;
import geometricTransformations.GeometricTransformation;
import geometricTransformations.Reflection;
import geometricTransformations.Rotation;
import geometricTransformations.Scaling;
import geometricTransformations.Shearing;
import geometricTransformations.Translation;
import graphics.AxesUtility;
import graphics.Point;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

import lines.BresenhemAlgorithm;
import lines.Line;
import matrices.Matrix;
import shapes.Polygon;

@SuppressWarnings("serial")
public class PolygonApplet extends JApplet {
	@Override
	public void paint(Graphics g) {
		try {
			Point coordinateCenter = new Point(400, 400);
			AxesUtility.drawCoordinateSystem(this, g, Color.BLACK, 100,
					coordinateCenter);
			AxesUtility.drawAxes(this, g, coordinateCenter, Color.RED);
			Point vertices[] = new Point[3];
			vertices[0] = new Point(0, 0);
			vertices[1] = new Point(300, 0);
			vertices[2] = new Point(300, 100);
			Polygon polygon = new Polygon(vertices, Color.BLUE);
			polygon.draw(g, coordinateCenter);
			GeometricTransformation transformation;
			Matrix points = polygon.mapShapeToMatrix();
			// Translation
			transformation = new Translation(50, 0);
			Matrix newPoints = transformation.transform(points);
			Polygon translatedPolygon = new Polygon(newPoints, Color.GREEN);
			translatedPolygon.draw(g, coordinateCenter);
			
			// Rotation
			transformation = new Rotation(90, new Point(100,100));
			Matrix rotatedPoints = transformation.transform(points);
			Polygon rotatedPolygon = new Polygon(rotatedPoints, Color.GREEN);
			rotatedPolygon.draw(g, coordinateCenter);
			
			// Scaling
			transformation = new Scaling(2, 2);
			Matrix scaledPoints = transformation.transform(points);
			Polygon scaledPolygon = new Polygon(scaledPoints, Color.GREEN);
			scaledPolygon.draw(g, coordinateCenter);
			
			// Shearing
			transformation = new Shearing(0,0,2,-50);
			Matrix shearedPoints = transformation.transform(points);
			Polygon shearedPolygon = new Polygon(shearedPoints, Color.GREEN);
			shearedPolygon.draw(g, coordinateCenter);
				
			// Reflection
			Line line = new Line(new Point(100,0), new Point(300,150));
			line.drawLine(coordinateCenter, g, new BresenhemAlgorithm());
			transformation = new Reflection(line);
			Matrix reflectedPoints = transformation.transform(points);
			Polygon reflectedPolygon = new Polygon(reflectedPoints, Color.GREEN);
			reflectedPolygon.draw(g, coordinateCenter);
			
			
		} catch (InvalidMatrixOperationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
