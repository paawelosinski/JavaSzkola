package lab44;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetLineWidthListener implements ActionListener {
	MainClass parent;

	@Override
	public void actionPerformed(ActionEvent e) {
		CenterPanel.lineWidth = Integer.parseInt(e.getActionCommand());
		
	}

}
