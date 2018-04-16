package lab4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class NorthPanel extends JPanel implements ChangeListener {
	private JSlider pasek;
	private JButton draw;
	JLabel tekst;

	public NorthPanel() {
		pasek = new JSlider(JSlider.HORIZONTAL, 3, 48, 24);
		pasek.setMajorTickSpacing(16);
		pasek.setPaintTicks(true);
		pasek.setPaintLabels(true);
		draw = new JButton("Draw");
		pasek.addChangeListener(this);
		tekst = new JLabel();
		tekst.setBorder(BorderFactory.createLineBorder(Color.blue));
		// draw.addChangeListener(this);
		this.add(tekst);
		this.add(pasek);
		this.add(draw);
		tekst.setText("NO of verticles: " + String.valueOf(pasek.getValue()));
		tekst.setSize(50, 50);

		// TODO Auto-generated constructor stub
	}

	public NorthPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public NorthPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public NorthPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void stateChanged(ChangeEvent e) {

		// TODO Auto-generated method stub
		tekst.setText("NO of verticles: " + String.valueOf(pasek.getValue()));
	}

}
