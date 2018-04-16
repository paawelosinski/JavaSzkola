package lab4;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements ActionListener {

	public MainPanel() {
		this.setBackground(Color.white);
		// TODO Auto-generated constructor stub
	}

	public MainPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public MainPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public MainPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
