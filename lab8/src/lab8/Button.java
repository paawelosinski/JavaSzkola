package lab8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;




public class Button extends JButton implements ActionListener{
	
	static List<String> list3;
	MainFrame parent;
	public Button(MainFrame parentArg, Editor editor) {
		list3 = new ArrayList<>();
		this.parent = parentArg;
		this.setText("SPRAWDZ POPRAWNOSC TEKSTU");
		this.addActionListener(e -> {
			String[] tab = editor.getText().split(" ");
			List<String> lista3 = Menu.checking(Menu.list, tab);
			int lista=lista3.size();
			
			
			JOptionPane.showMessageDialog(parent, "ilość błedów: "+lista+"   "+lista3.toString());
			
		});
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	
	
		
		
		
		
		
		// TODO Auto-generated method stub
		
	}
	

}
