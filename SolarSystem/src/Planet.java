import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D.Double;
public class Planet {
	@SuppressWarnings("unused")
	private String name;
	private int radius;
	private int distanceFromSun;//Distance between the centers of the planet and sun
	private int speed;//in radians per second
	private Color color;
	public Planet(String name,int radius, int distanceFromSun, int speed, Color color){
		this.name=name;
		this.radius = radius;
		this.distanceFromSun=distanceFromSun;
		this.speed = speed;
		this.color=color;
		
	}
	public void drawPlanet(Graphics g, Point sun){
		Double orbit_point=new Double(this.distanceFromSun, 0) ;
		Double orbit_pt_translated;
		for(double theta = 0;/*theta<=2*Math.PI*/;theta += speed/20.0){
			try{
			drawOrbit(g,sun, Color.RED);
			orbit_point.x= this.distanceFromSun * Math.cos(theta) ;
			orbit_point.y= this.distanceFromSun * Math.sin(theta);
			orbit_pt_translated = AxesUtility.translateAxes(orbit_point, sun);
			Circle.drawCircle(g, orbit_pt_translated, this.radius, Color.black);
			Circle.fillCircle(g, orbit_pt_translated, radius, color);
			
			Thread.sleep(1000);
			Circle.fillCircle(g, orbit_pt_translated, radius, Color.black);
			
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		
		
	}
	public void drawOrbit(Graphics g, Point sun, Color color){
		Circle.drawCircle(g, sun, distanceFromSun,color);
	}
		
}
	

