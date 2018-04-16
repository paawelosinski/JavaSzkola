package lab44;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {
	
	MainClass parent;
	
	JButton chooseBgButton;
	JButton chooseLnButton;
	
	Color bgColor;
	Color lnColor;
	
	public BottomPanel(MainClass parentArg) {
		this.setLayout(new FlowLayout()); 
		
		this.parent = parentArg;
		bgColor = Color.white;
		lnColor = Color.black;
		
		chooseBgButton = new JButton("BG color");
		chooseBgButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color recievedColor = JColorChooser.showDialog(null, "Choose background color", bgColor);
            	if(recievedColor != null) {
            		bgColor = recievedColor;
            		parent.centerPanel.setBackground(parent.bottomPanel.getBgColor());
            	}
			}
		});
		this.add(chooseBgButton);
		
		chooseLnButton = new JButton("LN color");
		chooseLnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color recievedColor = JColorChooser.showDialog(null, "Choose line color", lnColor);
            	if(recievedColor != null) {
            		lnColor = recievedColor;
            		parent.centerPanel.repaint();
            	}
			}
		});
		this.add(chooseLnButton);
	}

	public Color getBgColor() {
		return bgColor;
	}

	public Color getLnColor() {
		return lnColor;
	}
}
