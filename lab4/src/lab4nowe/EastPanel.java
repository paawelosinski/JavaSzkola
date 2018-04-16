package lab4nowe;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class EastPanel extends JPanel {
	MainFrame parent;
	List<Coords> vertices;
	int radius;

	public EastPanel(MainFrame parentArg) {
		this.parent = parentArg;
		this.radius = (int) (0.8 * parent.height / 2);
		this.vertices = new ArrayList<Coords>();
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//this.setLayout(new GridLayout(36, 1));

		for (int i = 0; i < NorthPanel.Starting; i++) {
			vertices.add(new Coords(0, 0));
			// vertices.get(vertices.size()-1).insert(this);
		}
		// TODO Auto-generated constructor stub
	}

	private void calculate() {
		
		if (parent.west.getMode() == WestPanel.REGULAR) {
			System.out.println(parent.width);
			for (int i = 0; i < parent.north.iloscPunktow; i++) {
				vertices.get(i).setX(radius * Math.cos((Math.PI / 2 + 2 * Math.PI * (i + 1)) / parent.north.iloscPunktow)
						+ parent.width / 2);
				vertices.get(i).setY(radius * Math.sin((Math.PI / 2 + 2 * Math.PI * (i + 1)) / parent.north.iloscPunktow)
						+ parent.height / 2);
			}
		} if (parent.west.getMode() == WestPanel.RANDOM){
			Random gen = new Random();
			for (int i = 0; i < parent.north.iloscPunktow; i++) {
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

	public void changeVertices() {
		this.removeAll();
		vertices.clear();
		while (vertices.size() < parent.north.iloscPunktow) {
			vertices.add(new Coords(0, 0));
			vertices.get(vertices.size() - 1).insert(this);
		}
		this.revalidate();
		this.repaint();
		calculate();
	}

}
