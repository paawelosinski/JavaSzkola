package Listener;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

import javax.swing.event.*;

public class InnerClassListenerFrame extends JFrame {
	private JLabel label;
	private JSlider slider;
	public static final int SLIDER_MIN=-100;
	public static final int SLIDER_MAX=100;
	public static final int SLIDER_INIT=0;

	public InnerClassListenerFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,50);
		label = new JLabel("0");
		slider = new JSlider(JSlider.HORIZONTAL,SLIDER_MIN,SLIDER_MAX,SLIDER_INIT);
		this.add(slider,BorderLayout.PAGE_START);
		this.add(label);
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				label.setText(slider.getValue()+"");
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
	}
	

	public static void main(String[] args) {
		new InnerClassListenerFrame().setVisible(true);
		// TODO Auto-generated method stub

	}

}
