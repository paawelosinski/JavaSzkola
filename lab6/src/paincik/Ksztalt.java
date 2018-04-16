package paincik;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public abstract class Ksztalt extends JPanel{
	protected List<Integer> xList; // Lista współrzędnych x
	protected List<Integer> yList; // Lista współrzędnych y
	int lineWidth;
	Color color;

	public Ksztalt() {
		xList = new ArrayList<Integer>();
		yList = new ArrayList<Integer>();
		this.lineWidth=MainPanel.lineWidth;
		this.color=Menu.lnColor;
	}

	public void setxy(int x,int y) {
		xList.add(x);
		yList.add(y);
	}

	

	 abstract void draw(Graphics2D g2d);

}
