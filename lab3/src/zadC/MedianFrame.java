package zadC;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.html.HTMLDocument.Iterator;

public class MedianFrame extends JFrame implements ActionListener {

	JTextField text1 = new JTextField();
	Font font1 = new Font("SansSerif", Font.BOLD, 20);
	
	JPanel main= new JPanel(new GridLayout(2, 1));
	JPanel pierwszy = new JPanel();
	JPanel drugi = new JPanel();
	JButton dodaj = new JButton("dodaj");
	JButton mediana = new JButton("mediana");
	JLabel liczby = new JLabel();
	ArrayList<Double> list = new ArrayList<Double>();
	JLabel medianatext = new JLabel();
	JButton reset=new JButton("reset");

	public MedianFrame() {
		super("MedianFrame");
		this.setLayout(new GridLayout(2, 1));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pierwszy.setLayout(new GridLayout(1, 5));
		text1.setFont(font1);

		this.setSize(500, 150);

		pierwszy.add(text1);
		pierwszy.add(dodaj);
		pierwszy.add(mediana);
		pierwszy.add(medianatext);
		drugi.add(liczby);
		pierwszy.add(reset);

		main.add(pierwszy);
		main.add(drugi);
		this.add(main);
		
		dodaj.addActionListener(this);
		mediana.addActionListener(this);
		reset.addActionListener(this);

		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		new MedianFrame().setVisible(true);

		// TODO Auto-generated method stub

	}

	public double obliczmediane(ArrayList<Double> list) {
		double tmp=0;
		int pos;
		int pos2;
		Collections.sort(list);
		if(list.size()%2==0) {
			pos=list.size()/2-1;
			pos2=list.size()/2;
			tmp=(list.get(pos)+list.get(pos2))/2;
		}
		else {
			pos = (list.size() / 2);
			tmp = list.get(pos);
		}

		return tmp;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (dodaj == ob) {
			try {
				double zmienna = Double.parseDouble(text1.getText());

				text1.setText("");

				list.add(zmienna);

				liczby.setText("Liczby: " + list.toString());
			} catch (NumberFormatException exception) {
				System.out.println("Podaj liczbe!");
				text1.setText("");
			}

		}
		if (mediana == ob) {
			Collections.sort(list);
			liczby.setText("Liczby: " + list.toString());
			double media2 = obliczmediane(list);
			// medianatext.setText("="+String.valueOf(media2));
			System.out.println(media2);
			System.out.println(list.size());
			medianatext.setText("="+String.valueOf(media2));
			

		}
		if(ob==reset) {
			list.clear();
			liczby.setText("Liczby: " + list.toString());
		}
		// TODO Auto-generated method stub

	}

}
