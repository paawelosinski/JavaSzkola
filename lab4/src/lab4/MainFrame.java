package lab4;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;


public class MainFrame extends JFrame implements ActionListener {
	
	
	NorthPanel north;
	 EastPanel east;
	 WestPanel west;
	 public SouthPanel south;
	public MainPanel center;
	 
	 
	
	
	
	
	

	public MainFrame() throws HeadlessException {
		this.setLayout(new BorderLayout());
	
		
			
			
			
	
		
		
		north=new NorthPanel();
		west=new WestPanel();
		east=new EastPanel();
		south=new SouthPanel();
		center=new MainPanel();
		this.setSize(800,300);
		
		
		
		
		
		
		
		
		
		
		
		
		this.add(north,BorderLayout.NORTH);
		this.add(east, BorderLayout.EAST);
		this.add(center, BorderLayout.CENTER);
		this.add(south, BorderLayout.SOUTH);
		this.add(west, BorderLayout.WEST);
		
		
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		new MainFrame().setVisible(true);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



	

}
