package lab44;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class LeftPanel extends JPanel implements ActionListener {
	
	MainClass parent;
	String mode;

	public static String REGULAR = "REGULAR";
	public static String RANDOM = "RANDOM";
	
	public LeftPanel(MainClass parentArg) {
		this.parent = parentArg;
		this.mode = REGULAR;
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Polygon"));
		setLayout(new GridLayout(2, 1));
		
		JRadioButton radioButton1 = new JRadioButton("Regular");
		radioButton1.setActionCommand(REGULAR);
		radioButton1.addActionListener(this);
		radioButton1.setSelected(true);
		this.add(radioButton1);
		
		JRadioButton radioButton2 = new JRadioButton("Random");
		radioButton2.setActionCommand(RANDOM);
		radioButton2.addActionListener(this);
		this.add(radioButton2);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(radioButton1);
		radioGroup.add(radioButton2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == REGULAR)
			mode = REGULAR;
		else if(e.getActionCommand() == RANDOM)
			mode = RANDOM;
	}
	
	public String getMode() {
		return mode;
	}
}
