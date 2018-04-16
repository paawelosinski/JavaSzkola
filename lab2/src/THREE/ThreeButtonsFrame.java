package THREE;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ThreeButtonsFrame extends JFrame implements ActionListener {
	JButton przycisk1=new JButton("zamknij program");
	JButton przycisk2=new JButton("czarne tło");
	JButton przycisk3=new JButton("zablokuj przycisk");
	JPanel main=new JPanel();

	public ThreeButtonsFrame() throws HeadlessException {
		this.setSize(600,300);
		this.add(main);
		main.add(przycisk1);
		main.add(przycisk2);
		main.add(przycisk3);
		przycisk1.addActionListener(this);
		przycisk2.addActionListener(this);
		przycisk3.addActionListener(this);
		
		
		// TODO Auto-generated constructor stub
	}

	public ThreeButtonsFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public ThreeButtonsFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public ThreeButtonsFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ThreeButtonsFrame okienko=new ThreeButtonsFrame();
		okienko.setVisible(true);
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(przycisk1==o) {
			System.exit(0);
		}
		if(przycisk2==o) {
			main.setBackground(Color.BLACK);
		}
		if(przycisk3==o) {
			przycisk3.setEnabled(false);
			
		}
		// TODO Auto-generated method stub
		
	}

}
