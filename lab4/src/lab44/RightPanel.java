package lab44;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class RightPanel extends JPanel {

	MainClass parent;
	List<Coords> vertices;
	int radius;

	public RightPanel(MainClass parentArg) {
		this.parent = parentArg;
		this.radius = (int) (0.8 * parent.height / 2);
		this.vertices = new ArrayList<Coords>();
		this.setLayout(new GridLayout(TopPanel.maxVertices, 1));

		for (int i = 0; i < TopPanel.startingVertices; i++) {
			vertices.add(new Coords(0, 0));
			vertices.get(vertices.size() - 1).insert(this);
		}
		calculate();
	}

	public void changeVertices() {
		this.removeAll();
		vertices.clear();
		while (vertices.size() < TopPanel.currentVertices) {
			vertices.add(new Coords(0, 0));
			vertices.get(vertices.size() - 1).insert(this);
		}
		this.revalidate();
		this.repaint();
		calculate();
	}

	private void calculate() {
		if (parent.leftPanel.getMode() == LeftPanel.REGULAR) {
			for (int i = 0; i < TopPanel.currentVertices; i++) {
				vertices.get(i).setX(radius * Math.cos((Math.PI / 2 + 2 * Math.PI * (i + 1)) / TopPanel.currentVertices)
						+ parent.width / 2);
				vertices.get(i).setY(radius * Math.sin((Math.PI / 2 + 2 * Math.PI * (i + 1)) / TopPanel.currentVertices)
						+ parent.height / 2);
			}
		} else {
			Random gen = new Random();
			for (int i = 0; i < TopPanel.currentVertices; i++) {
				vertices.get(i).setX(0.8 * parent.width * gen.nextDouble());
				vertices.get(i).setY(0.8 * parent.height * gen.nextDouble());
			}
		}
	}

	public List<Coords> getVertices() {
		return vertices;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
