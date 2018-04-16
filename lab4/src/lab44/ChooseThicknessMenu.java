package lab44;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ChooseThicknessMenu extends JMenuBar {
	public ChooseThicknessMenu(String[] base) {
		JMenu thickness = new JMenu("Line width");
		for(int i = 0; i < base.length; i++) {
			JMenuItem it = new JMenuItem(base[i] + " px");
			it.setActionCommand(base[i]);
			it.addActionListener(new SetLineWidthListener());
			thickness.add(it);
		}
		add(thickness);
	}
}
 