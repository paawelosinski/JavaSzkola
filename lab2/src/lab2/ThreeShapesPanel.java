package lab2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ThreeShapesPanel extends JPanel{
	private Random r = new Random();
	private int red = r.nextInt(255);
	private int green = r.nextInt(255);
	private int blue = r.nextInt(255);
	


	
	public ThreeShapesPanel(){
		this.setSize(580,300);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(red,green,blue));
	    g.fillRect(100, 100, 100, 100);
	    
			
		g.setColor(new Color(green,red,blue));
	 	g.fillOval(250, 250, 150, 150);
	 	
	 	g.setColor(new Color(blue,green,red));
	 	g.fillRoundRect(300,50,100,100,20,20);
	}

		

	public static void main(String[] args) {
		CloseableFrame frame = new CloseableFrame();
		JPanel panel2=new JPanel(/*new GridLayout(4,1)*/);
		
		ThreeShapesPanel panel = new ThreeShapesPanel();
		panel.setBackground(Color.black);
		
		frame.add(panel);
		frame.setVisible(true);

		// TODO Auto-generated method stub

	}

}
