package lab4nowe;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JPanel;

public class MainPanel extends JPanel {
	MainFrame parent;
	Polygon polygon;
	public  int lineWidth = 1;

	public MainPanel(MainFrame parentArg) {
		// TODO Auto-generated constructor stub

		this.parent = parentArg;

		setBackground(parent.south.getBgColor());
		setPreferredSize(new Dimension(parent.width, parent.height));

		setPolygon();
	}

	void setPolygon() {
		int length = parent.east.getVertices().size();
		int[] xArray = new int[length];
		int[] yArray = new int[length];
		
		for (int i = 0; i < length; i++) {
			xArray[i] = (int) parent.east.getVertices().get(i).getX();
			yArray[i] = (int) parent.east.getVertices().get(i).getY();
			
		}
		polygon = new Polygon(xArray, yArray, length);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.setColor(parent.south.getLnColor());
		g2d.drawPolygon(polygon);
	}

}
