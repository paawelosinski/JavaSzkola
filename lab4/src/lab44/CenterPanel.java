package lab44;



	import java.awt.BasicStroke;
	import java.awt.Dimension;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.Polygon;

	import javax.swing.JPanel;

	public class CenterPanel extends JPanel {
		
		MainClass parent;
		Polygon polygon;
		public static int lineWidth = 1;
		
		public CenterPanel(MainClass parentArg) {
			this.parent = parentArg;
			setBackground(parent.bottomPanel.getBgColor());
			setPreferredSize(new Dimension(parent.width, parent.height));
			
			setPolygon();
		}
		
		void setPolygon() {
			int length = parent.rightPanel.getVertices().size();
			int[] xArray = new int[length];
			int[] yArray = new int[length];
			for(int i = 0; i < length; i++) {
				xArray[i] = (int) parent.rightPanel.getVertices().get(i).getX();
				yArray[i] = (int) parent.rightPanel.getVertices().get(i).getY();
			}
			polygon = new Polygon(xArray, yArray, length);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(parent.bottomPanel.getLnColor());
			((Graphics2D) g).setStroke(new BasicStroke(lineWidth));
			g.drawPolygon(polygon);
		}
		
	}


