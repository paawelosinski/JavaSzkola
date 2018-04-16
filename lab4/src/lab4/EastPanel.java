import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class EastPanel extends JPanel {
	
	MainFrame parent;
	List<Cords> vertices;
	int radius;

	public RightPanel(MainClass parentArg) {
		this.parent = parentArg;
		this.radius = (int) (0.8*parent.height/2);
		this.vertices = new ArrayList<Cords>();
		this.setLayout(new GridLayout(NorthPanel.maxVertices, 1));
		
		for(int i = 0; i < NorthPanel.startingVertices; i++) {
			vertices.add(new Cords(0, 0));
			vertices.get(vertices.size()-1).insert(this);
		}
		calculate();
	}

	public void changeVertices() {
		this.removeAll();
		vertices.clear();
		while(vertices.size() < NorthPanel.currentVertices) {
			vertices.add(new Cords(0, 0));
			vertices.get(vertices.size()-1).insert(this);
		}
		this.revalidate();
		this.repaint(); 
		calculate();
	}

	private void calculate() {
		if(parent.EastPanel.getMode() == EastPanel.REGULAR) {
			for(int i = 0; i < NorthPanel.currentVertices; i++) {
				vertices.get(i).setX(radius*Math.cos((Math.PI/2 + 2*Math.PI*(i+1))/NorthPanel.currentVertices) + parent.width/2);
				vertices.get(i).setY(radius*Math.sin((Math.PI/2 + 2*Math.PI*(i+1))/NorthPanel.currentVertices) + parent.height/2);
			}
		}
		else {
			Random gen = new Random();
			for(int i = 0; i < NorthPanel.currentVertices; i++) {
				vertices.get(i).setX(0.8*parent.width*gen.nextDouble());
				vertices.get(i).setY(0.8*parent.height*gen.nextDouble());
			}
		}
	}
	
	public List<Cords> getVertices() {
		return vertices;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}

}