package paincik;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class LiniaProsta extends Ksztalt{
	MainFrame parent;
	public LiniaProsta(MainFrame parentArg) {
		this.parent = parentArg;
	}
	

	@Override
	void draw(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(lineWidth));
		
			g2d.drawLine(xList.get(0), yList.get(0), xList.get(1), yList.get(1));
		
	}

}
