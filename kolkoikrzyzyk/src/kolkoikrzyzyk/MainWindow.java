package kolkoikrzyzyk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainWindow extends JFrame implements ActionListener {
	private final int WIDTH = 400;
	private final int HEIGHT = 400;
	private DrawableButton[][] button = new DrawableButton[3][3];
	private JPanel panel1=new JPanel();
	private JPanel panel2=new JPanel();
	private JPanel panel3=new JPanel();
	private JLabel imie1=new JLabel();
	private JLabel imie2=new JLabel();
	private int score1=0;
	private int score2=0;
	String n1=JOptionPane.showInputDialog("Please enter ur name(player1 )");
	String n2=JOptionPane.showInputDialog("Please enter ur name(player1 )");
	Border border=BorderFactory.createLineBorder(Color.RED,5);
	private int counter;
	
	public MainWindow(int width, int height) {
		
		super("Kolko i Krzyzk");
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		;
		
		
		panel1.setLayout(new BorderLayout(2,1));
		panel2.setSize(20,20);
		panel1.add(panel2,BorderLayout.NORTH);
		panel3.setLayout(new GridLayout(3,3));
		
		
		imie1.setText(n1+ "  "+score1);
		imie1.setFont(new Font(n1,Font.BOLD,30));
		imie2.setText(" :"+ n2+" "+score2);
		imie2.setFont(new Font(n2,Font.BOLD,30));
		imie1.setBorder(border);
		panel2.add(imie1);
		panel2.add(imie2);
		
		
		
		

		for (int x = 0; x < 3; x++) {
			for (int z = 0; z < 3; z++) {
				button[x][z] = new DrawableButton();
				button[x][z].addActionListener(this);
				panel3.add(button[x][z]);
	
			}
			panel1.add(panel3,BorderLayout.CENTER);
			this.add(panel1);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}

	}

	public boolean checkwin(Content c) {
		for (int x = 0; x < 3; x++) {
			if ((button[x][0].getContent() == c) && (button[x][1].getContent() == c)
					&& (button[x][2].getContent() == c)) {
				System.out.println("koniec");
				return true;
			}
			if ((button[0][x].getContent() == c) && (button[1][x].getContent() == c)
					&& (button[2][x].getContent() == c)) {
				System.out.println("koniec");
				return true;
			

			}

		}
		if ((button[0][0].getContent() == c) && (button[1][1].getContent() == c)
				&& (button[2][2].getContent() == c)) {
			System.out.println("koniec");
			return true;
		}
		if ((button[2][0].getContent() == c) && (button[1][1].getContent() == c)
				&& (button[0][2].getContent() == c)) {
			System.out.println("koniec");
			return true;
		}
		
		return false;
	}

	// }

	@Override
	public void actionPerformed(ActionEvent e) {
		Content tmp=Content.CIRCLE;
		
		for(int x=0;x<3;x++) {
			for(int z=0;z<3;z++) {
				if(e.getSource()==button[x][z]) {
				
					button[x][z].draw();
					tmp=button[x][z].getContent();
					button[x][z].setEnabled(false);
					counter++;
					
				}}}
		if(tmp.equals(Content.CIRCLE)) {
			imie1.setBorder(null);
			imie2.setBorder(border);
		}
		else if(tmp.equals(Content.CROSS)) {
			imie1.setBorder(border);
			imie2.setBorder(null);
		
		}
		
		
		
			
		
		
					
			if(checkwin(tmp)){
				int choice=JOptionPane.showConfirmDialog(null, "Do u want play again?","You Won",JOptionPane.YES_NO_OPTION);
				if(choice==0) 
					reset();
					if(tmp.equals(Content.CIRCLE)) {
						score1++;
						imie1.setText(n1+ "  "+score1);
					}
						
					else {
						score2++;
						imie2.setText(n2+" "+score2);
					}
					
				
				if(choice==1)
					System.exit(1);
				
				
				}
			else if(counter==9) {
				int choice1=JOptionPane.showConfirmDialog(null, "Do u want play again?","DRAW!!!",JOptionPane.YES_NO_OPTION);
				if(choice1==0) 
					reset();
				if(choice1==1)
					System.exit(1);
				
				
			}
			
				
					
}
	public void reset() {
		counter=0;
		for(int x=0;x<3;x++) {
			for(int z=0;z<3;z++) {
				button[x][z].content=Content.EMPTY;
				button[x][z].setIcon(null);
				button[x][z].setEnabled(true);
			}
			}
		
	}
	

		// TODO Auto-generated method stub
		
	


}
