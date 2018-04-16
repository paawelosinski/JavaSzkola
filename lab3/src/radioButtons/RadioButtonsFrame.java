package radioButtons;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;

public class RadioButtonsFrame extends JFrame implements ActionListener {

	private static final String[] COLOR_NAMES = { "red", "green", "blue" };
	private static final Color[] COLORS = { Color.red, Color.green, Color.blue };
	private static final Color INIT_COLOR = COLORS[0];
	JRadioButton button1;
	JRadioButton button2;
	JRadioButton button3;
	
	
	public RadioButtonsFrame() {
		private JPanel panel;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(INIT_COLOR);
		this.setLayout(new FlowLayout());

		button1 = new JRadioButton(COLOR_NAMES[0]);
		button1.setActionCommand("0");
		button1.setBackground(INIT_COLOR);
		button1.setSelected(true);
		button1.addActionListener(this);
		this.add(button1);
		button2 = new JRadioButton(COLOR_NAMES[1]);
		button2.setActionCommand("1");
		button2.setBackground(INIT_COLOR);
		button2.addActionListener(this);
		this.add(button2);
		button3 = new JRadioButton(COLOR_NAMES[2]);
		button3.setActionCommand("2");
		button3.setBackground(INIT_COLOR);
		button3.addActionListener(this);
		this.add(button3);
		ButtonGroup group = new ButtonGroup();
		group.add(button1);
		group.add(button2);
		group.add(button3);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == button1) {
			this.getContentPane().setBackground(COLORS[0]);
			button1.setBackground(COLORS[0]);
			button2.setBackground(COLORS[0]);
			button3.setBackground(COLORS[0]);
		}
		if (ob == button2) {
			getContentPane().setBackground(COLORS[1]);
			button1.setBackground(COLORS[1]);
			button2.setBackground(COLORS[1]);
			button3.setBackground(COLORS[1]);
		}
		if (ob == button3) {
			getContentPane().setBackground(COLORS[2]);
			button1.setBackground(COLORS[2]);
			button2.setBackground(COLORS[2]);
			button3.setBackground(COLORS[2]);
		}
	}

	public static void main(String[] args) {
		new RadioButtonsFrame().setVisible(true);
		// TODO Auto-generated method stub

	}
	

	// TODO Auto-generated method stub

}
