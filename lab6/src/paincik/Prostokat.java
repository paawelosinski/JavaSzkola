package paincik;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Prostokat extends Ksztalt {
	MainFrame parent;
	public Prostokat(MainFrame parentArg) {
		this.parent = parentArg;
	}
	

	@Override
	void draw(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.drawRect(Math.min(xList.get(1), xList.get(0)), Math.min(yList.get(1), yList.get(0)),
				Math.abs(xList.get(1) - xList.get(0)), Math.abs(yList.get(1) - yList.get(0)));
		// TODO Auto-generated method stub

	}

}
