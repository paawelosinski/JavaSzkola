package paincik;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line extends Ksztalt{	
	MainFrame parent;
	public Line(MainFrame parentArg) {
		this.parent = parentArg;
	}
	

	@Override
	void draw(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(lineWidth));
		for (int i = 0; i < xList.size() - 1; ++i) {
			g2d.drawLine(xList.get(i), yList.get(i), xList.get(i + 1), yList.get(i + 1));
		}
	}



}
