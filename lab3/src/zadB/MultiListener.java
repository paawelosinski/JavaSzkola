package zadB;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.*;

import javafx.beans.value.ObservableValue;
import radioButtons.RadioButtonsFrame;

public class MultiListener extends JFrame implements ActionListener, ChangeListener{
	
	JButton wylacz;
	JPanel main;
	JPanel panel1;
	JPanel panel2;
	JSlider slider;
	JRadioButton button1;
	JRadioButton button2;
	JRadioButton button3;
	private static final String[] COLOR_NAMES = { "flaga polski", "flaga niemiec", "flaga ukrainy" };
	private static final Color[] COLORS = { Color.red, Color.green, Color.blue };
	private static final Color INIT_COLOR = COLORS[0];
	private JTextField textField;
	JPasswordField haslo;
	
	
	
	
	public MultiListener() {
		
		wylacz=new JButton("wyłacz");
		Akcje obiekt=new Akcje();
		slider=new  JSlider(JSlider.HORIZONTAL,0,50,25);
		main=new JPanel(new GridLayout(2, 1));
		slider.addChangeListener(this);
		panel1=new JPanel();
		panel2=new JPanel();
		panel2.setLayout(new GridLayout(2,1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(INIT_COLOR);
		this.setLayout(new GridLayout(2,1));
		textField=new JTextField();
		textField.addActionListener(obiekt);
		panel2.add(textField);
	
		button1 = new JRadioButton(COLOR_NAMES[0]);
		button1.setActionCommand("0");
		//button1.setBackground(INIT_COLOR);
		button1.setSelected(true);
		button1.addActionListener(this);
		panel1.add(button1);
		button2 = new JRadioButton(COLOR_NAMES[1]);
		button2.setActionCommand("1");
		//button2.setBackground(INIT_COLOR);
		button2.addActionListener(this);
		panel1.add(button2);
		button3 = new JRadioButton(COLOR_NAMES[2]);
		button3.setActionCommand("2");
		//button3.setBackground(INIT_COLOR);
		button3.addActionListener(this);
		panel1.add(button3);
		ButtonGroup group = new ButtonGroup();
		group.add(button1);
		group.add(button2);
		group.add(button3);
		panel1.add(slider);
		haslo=new  JPasswordField();
		haslo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("haslo="+haslo.getText());
				// TODO Auto-generated method stub
				
			}
			
			
			
		});
		panel2.add(haslo);
		
		
		
		
		
		panel2.add(wylacz);
		this.add(main);
		main.add(panel1);
		main.add(panel2);
		
		
		wylacz.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == button1) {
			this.getContentPane().setBackground(COLORS[0]);
			panel1.setBackground(Color.WHITE);
			panel2.setBackground(Color.WHITE);
			wylacz.setBackground(Color.WHITE);
			textField.setBackground(Color.WHITE);
			
			
		
			button1.setBackground(Color.WHITE);
			button2.setBackground(Color.WHITE);
			button3.setBackground(Color.WHITE);
		}
		if (ob == button2) {
			panel1.setBackground(Color.BLACK);
			panel2.setBackground(Color.RED);
			
			getContentPane().setBackground(Color.yellow);
			button1.setBackground(Color.BLACK);
			button2.setBackground(Color.BLACK);
			button3.setBackground(Color.BLACK);
			wylacz.setBackground(Color.RED);
			textField.setBackground(Color.RED);
			
		
		}
		if (ob == button3) {
			getContentPane().setBackground(Color.YELLOW);
			panel1.setBackground(Color.BLUE);
			panel2.setBackground(Color.BLUE);
			button1.setBackground(Color.BLUE);
			button2.setBackground(Color.BLUE);
			button3.setBackground(Color.BLUE);
			wylacz.setBackground(Color.BLUE);
			textField.setBackground(Color.BLUE);
			
		
		}
		
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new MultiListener().setVisible(true);
		// TODO Auto-generated method stub

	}
	
	private class Akcje implements ActionListener {

		

		@Override
		public void actionPerformed(ActionEvent e) {
			MultiListener.this.setTitle(textField.getText());
			// TODO Auto-generated method stub
			
		}
		

		
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JSlider source=(JSlider)e.getSource();
		if(!source.getValueIsAdjusting()) {
			int numer=(int)source.getValue();
			if(numer==0) {
				button1.setText("nie ma");
			}
			if(numer==1) {
				button1.setText("pozdrawiam");
			}
		}
		
		
	}



	
	
			
			
}
