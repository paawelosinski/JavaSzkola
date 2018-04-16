package lab4nowe;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MainFrame extends JFrame implements ActionListener, ComponentListener {
	private static final LookAndFeel NimbusLookAndFeel = null;
	NorthPanel north;
	SouthPanel south;
	EastPanel east;
	WestPanel west;
	MainPanel main;
	JMenuBar Menubar;
	JMenu menu;
	JMenuBar Bar;
	JMenuItem rozmiar1;
	JMenuItem rozmiar2;
	JMenuItem rozmiar3;
	JMenuItem wylacz;
	JMenuItem zapisz;
	JMenuItem look1;
	JMenuItem look2;

	public int width = 600;
	public int height = 600;

	public MainFrame() {

		setSize(800, 800);

		menu = new JMenu("Grubość Lini");
		JMenu opcje = new JMenu("Opcje");
		wylacz = new JMenuItem("exit");
		zapisz = new JMenuItem("zapisz");
		opcje.add(zapisz);
		opcje.add(wylacz);
		look1 = new JMenuItem("Wygląd1");
		look2 = new JMenuItem("wygląd2");
		JMenu wyglad = new JMenu("lookANDfeel");
		wyglad.add(look1);
		wyglad.add(look2);

		Menubar = new JMenuBar();
		rozmiar1 = new JMenuItem("1px");
		rozmiar2 = new JMenuItem("5px");
		rozmiar3 = new JMenuItem("10px");
		rozmiar1.addActionListener(this);
		rozmiar2.addActionListener(this);
		rozmiar3.addActionListener(this);
		wylacz.addActionListener(this);
		zapisz.addActionListener(this);
		look1.addActionListener(this);
		look2.addActionListener(this);

		menu.add(rozmiar1);
		menu.add(rozmiar2);
		menu.add(rozmiar3);
		Menubar.add(menu);
		Menubar.add(opcje);
		Menubar.add(wyglad);
		north = new NorthPanel(this);
		south = new SouthPanel(this);
		east = new EastPanel(this);
		west = new WestPanel();
		main = new MainPanel(this);
		this.setJMenuBar(Menubar);
		this.add(north, BorderLayout.NORTH);
		this.add(south, BorderLayout.SOUTH);
		this.add(east, BorderLayout.EAST);
		this.add(west, BorderLayout.WEST);
		this.add(main, BorderLayout.CENTER);

		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		new MainFrame().setVisible(true);

		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (rozmiar1 == source) {
			main.lineWidth = 1;
			main.repaint();
		}
		if (rozmiar2 == source) {
			main.lineWidth = 5;
			main.repaint();

		}
		if (rozmiar3 == source) {
			main.lineWidth = 10;
			main.repaint();
		}
		if (wylacz == source) {

			int choice = JOptionPane.showConfirmDialog(null, "czy na pewno chcesz wyłączyć", "REALLY??",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (choice == 0)
				System.exit(0);

		}

		else {

		}
		if (zapisz == source) {
			String choice1 = JOptionPane.showInputDialog("Podaj nazwe jak chcesz zapisac program xd");

			BufferedImage img = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
			Graphics g = img.createGraphics();
			main.paintComponent(g);

			try {
				ImageIO.write(img, "png", new File("/home/paawel97/Desktop//" + choice1 + "png"));
				System.out.println("zapisano");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.print("PLIK NIE ZOSTAŁ ZAPISANY");
			}
		}
		/*if (look1 == source) {
			try {
				UIManager.setLookAndFeel(NimbusLookAndFeel);
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (look2 == source) {

		}*/
		// System.exit(0);
	}
	// TODO Auto-generated method stub

	@Override
	public void componentResized(ComponentEvent e) {
		width = main.getWidth();
		height = main.getHeight();
		east.setRadius((int) (0.8 * height / 2));
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

}
