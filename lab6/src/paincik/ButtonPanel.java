package paincik;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel implements ActionListener {
	JButton zaznaczanie;
	JButton gumka;
	JButton olowek;
	JButton linia;
	JButton kolo;
	JButton kwadrat;
	MainFrame parent;
	public static int zmienna;

	public ButtonPanel(MainFrame parentArg) throws IOException {
		this.parent = parentArg;

		ImageIcon gumka1 = new ImageIcon("/home/paawel97/eclipse-workspace/lab6/src/images/gumka.jpeg");

		ImageIcon kolo1 = new ImageIcon("/home/paawel97/eclipse-workspace/lab6/src/images/kolo.jpeg");
		ImageIcon prostokat1 = new ImageIcon("/home/paawel97/eclipse-workspace/lab6/src/images/kwadrat.png");
		ImageIcon kolorowanie1 = new ImageIcon("/home/paawel97/eclipse-workspace/lab6/src/images/kolorwanie.png");
		ImageIcon linia1 = new ImageIcon("/home/paawel97/eclipse-workspace/lab6/src/images/linia.png");
		ImageIcon olowek1 = new ImageIcon("/home/paawel97/eclipse-workspace/lab6/src/images/olowek.jpg");

		this.setLayout(new GridLayout(6, 1));

		zaznaczanie = new JButton(kolorowanie1); // kolorowanie

		gumka = new JButton(gumka1);
		olowek = new JButton(olowek1);
		linia = new JButton(linia1);
		kolo = new JButton(kolo1);
		kwadrat = new JButton(prostokat1);
		zaznaczanie.addActionListener(this);
		olowek.addActionListener(this);
		linia.addActionListener(this);
		kolo.addActionListener(this);
		kwadrat.addActionListener(this);
		gumka.addActionListener(this);

		this.add(zaznaczanie);
		this.add(gumka);
		this.add(olowek);
		this.add(linia);
		this.add(kolo);
		this.add(kwadrat);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == olowek) {
			zmienna = 1;

		}
		if (ob == linia) {
			zmienna = 2;

		}
		if (ob == gumka) {
			zmienna = 3;

		}
		if (ob == kwadrat) {
			zmienna = 4;

		}
		if (ob == kolo) {
			zmienna = 5;

		}
		if (ob == zaznaczanie) {
			zmienna = 6;

		}

		// TODO Auto-generated method stub

	}

}
