import java.awt.*;

public class MyStar extends MyDrawing {
	public MyStar(int xpt, int ypt) {
		super();
		setLocation(xpt, ypt);
	}
	
	public void draw(Graphics g) {
		int x = getX();
		int y = getY();
		int w = getW();
		int h = getH();
		
		int[] xPoints = new int[11];
		int[] yPoints = new int[11];
		double radius =  w / 2.0;
		
		//if the width or height is a negative number
		if(w < 0) {
			x += w;
			w *= -1;
		}
		
		if(h < 0) {
			y += h;
			h *= -1;
		}
		
		double x1, y1;
		double x2, y2;
		for(int k = 0; k <= 5; k++) {
			x1 = radius * Math.cos((Math.PI / 2) + (2 * Math.PI * k / 5));
			x2 = (x1 + (w / 2.0));  
			xPoints[2 * k] = (int) (x + x2);
			
			y1 = radius * (Math.sin((Math.PI / 2) + (2 * Math.PI * k / 5) ));
			y2 = (y1 + (h / 2.0));  
			yPoints[2 * k] = (int) (y + y2);
		}
		
		double radius2 = radius * (Math.sin(Math.PI / 10) / Math.cos(Math.PI / 4));
		
		for(int k = 0; k <= 4; k++) {
			x1 = radius2 * (Math.cos(( 3 * Math.PI / 4) + (2 * Math.PI * k / 5) ));
			x2 = (x1 + (w / 2.0));  
			xPoints[2 * k + 1] = (int) (x + x2);
			
			y1 = radius2 * (Math.sin((3 * Math.PI / 4) + (2 * Math.PI * k / 5) ));
			y2 = (y1 + (h / 2.0));  
			yPoints[2 * k + 1] = (int) (y + y2);
		}
		
		
		
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(getLineWidth()));
		g2.setColor(getFillColor());
		g2.fillPolygon(xPoints, yPoints, xPoints.length);
		g2.setColor(getLineColor());
		g2.drawPolygon(xPoints, yPoints, xPoints.length);
	}
}
