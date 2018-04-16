package comboBox;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;

public class ComboBoxListener implements ItemListener {
	private JPanel panel;
	public ComboBoxListener(JPanel panel) {
		this.panel=panel;
		
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			String color =(String)e.getItem();
			switch(color) {
			case "red":
				panel.setBackground(Color.red);;
				break;
			case "green":
				panel.setBackground(Color.green);
				break;
			case "yellow":
				panel.setBackground(Color.yellow);
				break;
			case "orange":
				panel.setBackground(Color.orange);
				break;
			case "blue":
				panel.setBackground(Color.blue);
			}
		}
		// TODO Auto-generated method stub
		
	}
	
	
}
