package paincik;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Gumka extends Ksztalt {
	MainFrame parent;

	public Gumka(MainFrame parentArg) {
		this.parent = parentArg;
	}

	@Override

	void draw(Graphics2D g2d) {
		for (int i = 0; i < xList.size() - 1; ++i) {
			g2d.setColor(parent.menu.getBgColor());
			g2d.setStroke(new BasicStroke(lineWidth));
			g2d.drawLine(xList.get(i), yList.get(i), xList.get(i + 1), yList.get(i + 1));
		}
	}

}
