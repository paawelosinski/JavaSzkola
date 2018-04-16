package comboBox;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class OtherClassListener extends JFrame {
	public OtherClassListener() {
		super("JComboBox");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,100);
		String[] colors= {"wybierz color","red","green","blue","yellow","orange"};
		JComboBox<String> colorlist=new JComboBox<>(colors);
		this.add(colorlist,BorderLayout.PAGE_START);
		colorlist.addItemListener(new ComboBoxListener((JPanel)this.getContentPane()));
		
				
				
			}
			
			
		
	public static void main(String[] args) {
		new OtherClassListener().setVisible(true);
	}
	}


