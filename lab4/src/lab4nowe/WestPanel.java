package lab4nowe;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class WestPanel extends JPanel implements ActionListener {
	
	public static String mode="REGULAR";
	public static String REGULAR = "REGULAR";
	public static String RANDOM = "RANDOM";
	JRadioButton przycisk1;
	JRadioButton przycisk2;
	
	
	
	public WestPanel() {
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Polygon"));
		setLayout(new GridLayout(2, 1));
		przycisk1 = new JRadioButton("Regular");
		przycisk1.setActionCommand(REGULAR);
		przycisk1.addActionListener(this);
		przycisk1.setSelected(true);
		this.add(przycisk1);
		
		przycisk2 = new JRadioButton("Random");
		przycisk2.setActionCommand(RANDOM);
		przycisk2.addActionListener(this);
		this.add(przycisk2);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(przycisk1);
		radioGroup.add(przycisk2);
		
		// TODO Auto-generated constructor stub
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
