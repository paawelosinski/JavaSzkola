package lab4nowe;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class SouthPanel extends JPanel {
	MainFrame parent;
	
	JButton chooseBgButton;
	JButton chooseLnButton;
	
	Color bgColor;
	Color lnColor;
	
	 public SouthPanel(MainFrame parentArg) {
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
            		parent.main.setBackground(parent.south.getBgColor());
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
            		parent.main.repaint();
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


