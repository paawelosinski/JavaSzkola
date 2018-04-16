package lab8;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	MainFrame frame;
	Editor panel;
	Menu menu;
	Button button;
	public static JTextField mistakes;

	public MainFrame() {

		panel = new Editor();
		menu = new Menu(this);
		button = new Button(this,panel);
		mistakes = new JTextField();
		this.setSize(new Dimension(1200, 800));
		this.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.setTitle("Ortografia");
		this.setJMenuBar(menu);
		this.add(button, BorderLayout.SOUTH);
		this.add(mistakes, BorderLayout.EAST);
		mistakes.setText(Button.list3.toString());
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		new MainFrame().setVisible(true);

	}

}
