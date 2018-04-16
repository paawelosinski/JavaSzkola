package kolkoikrzyzyk;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class DrawableButton extends JButton{
	

	public Content content=Content.EMPTY;
	public ImageIcon circle =new ImageIcon(getClass().getResource("circle.png"));
	public ImageIcon cross =new ImageIcon(getClass().getResource("krzyzyk.png"));
	public static int move_count=0;
	

	
	
	
	public DrawableButton() {
		super();
		
		
		Image image=circle.getImage();
		Image newimg = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		circle=new ImageIcon(newimg);
		
		image=cross.getImage();
		newimg = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		cross=new ImageIcon(newimg);
		
		
		
		
		setLayout(new GridLayout(3,3));
		
		
		
		Border border = BorderFactory.createLineBorder(Color.black,3);
		setBorder(border);
		
	}
	
	public void draw() {
	
			
			if(Content.EMPTY==content) {
				//rysowanie ksztaltow 
				if(move_count%2==0) {
					System.out.println("circle");
					this.setIcon(circle);
					content=Content.CIRCLE;
					//kolko
					
					
				}
				else {
					this.setIcon(cross);
					System.out.println("cross");
					content=Content.CROSS;
				//krzyzk
					
					
				}
				move_count++;                                      
				
			
			}
		}
	public Content getContent(){
		return content;	
	
	}
}

