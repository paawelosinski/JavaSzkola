package paincik;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame {
	public static MainPanel main;
	public ButtonPanel left;
	
	Menu menu;

	public MainFrame() throws IOException {
		this.setSize(1000, 800);
		this.setLayout(new BorderLayout());

		menu = new Menu(this);
		
		main=new MainPanel(this);
		this.add(main,BorderLayout.CENTER);
		this.setJMenuBar(menu);
		this.validate();
		this.repaint();
		left = new ButtonPanel(this);
		this.add(left,BorderLayout.WEST);
		
		//this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);		

		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		new MainFrame().setVisible(true);

	}

}
