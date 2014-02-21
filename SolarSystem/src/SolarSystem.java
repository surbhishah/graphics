import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JApplet;
import java.awt.Point;

@SuppressWarnings("serial")
public class SolarSystem extends JApplet{
	public void paint(Graphics g){
		/* Setup the background and main axes	*/
		g.fillRect(0, 0, getWidth(), getHeight());
		Point center = new Point(400,400);
		AxesUtility.drawAxes(this,g,center,Color.red);
		
		
		/* Location of the sun is 0,0 in our coordinate system*/
		Point sun = new Point(0,0);
		/* Translate the location to adapt to the coordinate system of Java Graphics*/
		Point translated_sun=AxesUtility.translateAxes(sun,center);
		/* Draw the sun */
		Circle.drawCircle(g,translated_sun, 15,Color.yellow);
		Circle.fillCircle(g, translated_sun, 15, Color.yellow);
		
		
		/* Draw first planet Mercury and its orbit	*/
		Planet mercury = new Planet("Mercury",5,30,1,new Color(255,69,0));
		Runnable task1 = new ThreadPlanet(mercury,translated_sun,g);
		Thread mercuryThread = new Thread(task1);
		mercuryThread.run();
	
		
		/* Draw second planet Venus and its orbit	*/
		Planet venus = new Planet("Venus",6,60,2,new Color(255,69,0));
		Runnable task = new ThreadPlanet(venus,translated_sun,g);
		Thread venusThread = new Thread(task);
		venusThread.run();
		
	}
	
	
		

		
}
	

