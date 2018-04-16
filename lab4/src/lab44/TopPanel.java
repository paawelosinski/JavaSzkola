package lab44;


import java.awt.FlowLayout;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TopPanel extends JPanel {
	JSlider numberOfVerticesSlider;
	JButton drawButton;
	
	static short maxVertices = 28;
	static short startingVertices = 4;
	static short currentVertices = startingVertices;
	JLabel napis=new JLabel("Number of Vertices");
	 
	MainClass parent;
	
	public TopPanel(MainClass parentArg) {
		this.parent = parentArg;
		
		numberOfVerticesSlider = new JSlider(JSlider.HORIZONTAL, 3, maxVertices, startingVertices);
		numberOfVerticesSlider.setMajorTickSpacing((maxVertices-3)/2);
		numberOfVerticesSlider.setPaintTicks(true);
		numberOfVerticesSlider.setPaintLabels(true);
		numberOfVerticesSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				currentVertices = (short) numberOfVerticesSlider.getValue();
				parent.rightPanel.changeVertices();
				parent.centerPanel.setPolygon();
				napis.setText("Number of Verticles: "+String.valueOf(numberOfVerticesSlider.getValue()));
				parent.centerPanel.repaint();
			}
		});
		
		drawButton = new JButton("Draw");
		drawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int length = parent.rightPanel.getVertices().size();
				int[] xArray = new int[length];
				int[] yArray = new int[length];
				for(int i = 0; i < length; i++) {
					xArray[i] = Integer.parseInt(parent.rightPanel.getVertices().get(i).getxField().getText());
					yArray[i] = Integer.parseInt(parent.rightPanel.getVertices().get(i).getyField().getText());
				}
				parent.centerPanel.polygon = new Polygon(xArray, yArray, length);
				parent.centerPanel.repaint();
			}
		});
		
		this.setLayout(new FlowLayout());
		napis.setText("Number of Verticles: "+String.valueOf(numberOfVerticesSlider.getValue()));
		this.add(napis);
		this.add(numberOfVerticesSlider);
		this.add(drawButton);
	}
}
