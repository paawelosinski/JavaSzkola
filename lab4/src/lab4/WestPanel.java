package lab4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class WestPanel extends JPanel implements ActionListener {
	JRadioButton button1;
	JRadioButton button2;
	

	public WestPanel() {
		this.setLayout(new BorderLayout());
		button1=new JRadioButton("Random");
		button2=new JRadioButton("Regular");
		ButtonGroup group = new ButtonGroup();
        group.add(button1);
        group.add(button2);
        this.add(button1,BorderLayout.NORTH);
        this.add(button2,BorderLayout.PAGE_END);
      //Titled borders
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Polygon");
        this.setBorder(title);
        
        
		// TODO Auto-generated constructor stub
	}

	public WestPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public WestPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public WestPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
