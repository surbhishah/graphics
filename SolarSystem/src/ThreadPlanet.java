import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
public class ThreadPlanet implements Runnable{
	Planet planet;
	Point sun;
	Graphics g;
	public ThreadPlanet(Planet planet, Point sun, Graphics g){
		this.planet=planet;
		this.sun = sun;
		this.g = g;
	}
	public void run(){
		planet.drawOrbit(g, sun,Color.red);
		planet.drawPlanet(g, sun);
	}
}
