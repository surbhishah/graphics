
@SuppressWarnings("serial")
public class FillApplet extends JApplet {
	@Override
	public void paint(Graphics g) {
		try {
			Point coordinateCenter = new Point(400, 400);
			AxesUtility.drawCoordinateSystem(this, g, Color.BLACK, 100,
					coordinateCenter);
			AxesUtility.drawAxes(this, g, coordinateCenter, Color.RED);
			Point vertices[] = new Point[3];
			vertices[0] = new Point(-5, 5);
			vertices[1] = new Point(5, 0);
			vertices[2] = new Point(0, -5);
			Polygon polygon = new Polygon(vertices, Color.BLUE);
			polygon.draw(g, coordinateCenter);
			BoundaryFillAlgorithm algo = new BoundaryFillAlgorithm();
			algo.fill(400, 400, g, Color.RED, Color.BLUE);
			
			
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
