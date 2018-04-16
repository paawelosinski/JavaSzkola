package lab4nowe;

import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class NorthPanel extends JPanel implements ChangeListener {
	JTextField ilosc;
	JSlider pasek;
	JButton Draw;
	public  int iloscPunktow;
	public static int Starting;
	MainFrame parent;

	public NorthPanel(MainFrame parentarg) {
		this.parent=parentarg;
	
		ilosc=new JTextField();
		pasek = new JSlider(JSlider.HORIZONTAL, 3, 36, 24);
		pasek.setMajorTickSpacing(16);
		pasek.setPaintTicks(true);
		pasek.setPaintLabels(true);
		Starting=pasek.getValue();
		ilosc.setText("No of verticles: " + String.valueOf(pasek.getValue()));
		
		Draw=new JButton("Draw");
		Draw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int length = parent.east.getVertices().size();
				int[] xArray = new int[length];
				int[] yArray = new int[length];
				for(int i = 0; i < length; i++) {
					xArray[i] = Integer.parseInt(parent.east.getVertices().get(i).getxField().getText());
					yArray[i] = Integer.parseInt(parent.east.getVertices().get(i).getyField().getText());
				}
				parent.main.polygon = new Polygon(xArray, yArray, length);
				parent.main.repaint();
			
				
				// TODO Auto-generated method stub
				
			}
		});
		pasek.addChangeListener(this);
		this.add(ilosc);
		this.add(pasek);
		this.add(Draw);
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		iloscPunktow=pasek.getValue();
		// TODO Auto-generated method stub
		ilosc.setText("No of verticles: " + String.valueOf(pasek.getValue()));
		iloscPunktow = (short) pasek.getValue();
		parent.east.changeVertices();
		parent.main.setPolygon();
		ilosc.setText("No of Verticles: "+String.valueOf(pasek.getValue()));
		parent.main.repaint();
	}
		
}
