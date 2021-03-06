import graphics.AxesUtility;
import graphics.Point;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JApplet;

import algorithms.BresenhemAlgorithm;
import algorithms.CircleDrawingAlgorithm;
import algorithms.DirectEquationUse;
import algorithms.MidPointAlgorithm;
import circle.Circle;

@SuppressWarnings("serial")
public class CircleApplet extends JApplet {

	@Override
	public void paint(Graphics g) {
		Point coordinateCenter = new Point(400, 400);
		AxesUtility.drawCoordinateSystem(this, g, Color.BLACK, 100,
				coordinateCenter);
		AxesUtility.drawAxes(this, g, coordinateCenter, Color.RED);
		
		/*****************************************/
		CircleDrawingAlgorithm algo = new DirectEquationUse();
		Point p = new Point(100, 50);
		p = p.translate(coordinateCenter);
		g.setColor(Color.MAGENTA);
		g.drawString("Direct Equation",p.x , p.y);
		perfEvaluate( algo, coordinateCenter, g);
		
		/*****************************************/
		algo = new MidPointAlgorithm();
		p = new Point(100, 250);
		p = p.translate(coordinateCenter);
		g.setColor(Color.MAGENTA);
		g.drawString("Mid Point Algorithm",p.x , p.y);
		perfEvaluate(algo, coordinateCenter, g);
		
		/*****************************************/
		algo = new BresenhemAlgorithm();
		p = new Point(100, -150);
		p = p.translate(coordinateCenter);
		g.setColor(Color.MAGENTA);
		g.drawString("Bresenhem Algorithm",p.x , p.y);
		perfEvaluate( algo, coordinateCenter, g);

	}

	void perfEvaluate(CircleDrawingAlgorithm algo,
			Point coordinateCenter, Graphics g) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(
					"/home/surbhi/Documents/PerfEvaluation.txt", true));
			long startTime, estimatedTime;
			Circle circle = new Circle(new Point(0,0), 50);
			for(int rad = 50; rad< 400 ; rad+= 50){
				startTime = System.nanoTime();
				circle = new Circle(new Point(0,0),rad );
				circle.drawCircle(algo, g, coordinateCenter);
				estimatedTime = System.nanoTime() - startTime;
				out.write("\n" + algo.getClass()+",radius="+circle.getRadius() + ",time=" + estimatedTime);
			}
					 
			out.close();

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
