package kolkoikrzyzyk;

import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;;


public class DrawablePanel extends JPanel implements MouseListener {
	
	public Content content=Content.EMPTY;
	public ImageIcon circle =new ImageIcon(getClass().getResource("circle.png"));
	public ImageIcon cross =new ImageIcon(getClass().getResource("krzyzyk.png"));
	public static int move_count =0;
	
	JLabel label=new JLabel();
	
	
	
	public DrawablePanel(int width,int height) {
		super();
		setSize(width,height);
		
		Image image=circle.getImage();
		Image newimg = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		circle=new ImageIcon(newimg);
		
		image=cross.getImage();
		newimg = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		cross=new ImageIcon(newimg);
		
		
		label.addMouseListener(this);
		add(label);
		setLayout(new GridLayout(1,1));
		
		
		
		Border border = BorderFactory.createLineBorder(Color.black,3);
		setBorder(border);
		
	}
	
	public void draw() {
		
		if(Content.EMPTY==content) {
			//rysowanie ksztaltow 
			if(move_count%2==0) {
				System.out.println("circle");
				label.setIcon(circle);
				content=Content.CIRCLE;
				//kolko
				
				
			}
			else {
				label.setIcon(cross);
				System.out.println("cross");
				content=Content.CROSS;
			//krzyzk
				
				
			}
			move_count++;
			
		
		}
	}
	
	
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		draw();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
