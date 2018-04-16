package paincik;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.management.modelmbean.ModelMBeanAttributeInfo;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Menu extends JMenuBar implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Color bgColor;
	public static Color lnColor;
	public static int size = 3;
	MainFrame parent;
	MainPanel main;

	JMenuBar menu;

	JMenu file;
	JMenuItem niu;
	JMenuItem open;
	JMenuItem save;

	JMenu edit;
	JMenuItem size2;
	JMenuItem size3;
	JMenuItem size4;

	JMenu view;
	JMenuItem zoom;

	JMenu image;
	JMenuItem rotate;

	JMenu colors;
	JMenuItem setBackground;
	JMenuItem setColor;
	JMenu help;
	JMenuItem about;
	JFileChooser choose;

	public Menu(MainFrame parentArg) {
		this.parent = parentArg;
		bgColor = Color.white;
		lnColor = Color.black;
		menu = new JMenuBar();

		file = new JMenu("file");
		niu = new JMenuItem("New");
		open = new JMenuItem("open");
		save = new JMenuItem("save");

		file.add(niu);
		file.add(open);
		file.add(save);
		this.add(file);
		niu.addActionListener(this);

		edit = new JMenu("grubość lini");
		size2 = new JMenuItem("2px");
		size3 = new JMenuItem("8px");
		size4 = new JMenuItem("12px");
		edit.add(size2);
		edit.add(size3);
		edit.add(size4);
		this.add(edit);
		size2.addActionListener(this);
		size3.addActionListener(this);
		size4.addActionListener(this);

		view = new JMenu("view");
		zoom = new JMenuItem("zoom");
		view.add(zoom);
		this.add(view);
		open.addActionListener(this);

		image = new JMenu("image");
		rotate = new JMenuItem("rotate");
		image.add(rotate);
		this.add(image);

		colors = new JMenu("colors");
		setBackground = new JMenuItem("setBackground");
		setBackground.addActionListener(this);
		setColor = new JMenuItem("set Color");
		colors.add(setBackground);
		colors.add(setColor);
		this.add(colors);
		rotate.addActionListener(this);
		help = new JMenu("help");
		about = new JMenuItem("about");
		about.addActionListener(this);
		help.add(about);
		this.add(help);
		save.addActionListener(this);
		setColor.addActionListener(this);
		parent.addWindowListener(exitListener);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == setBackground) {
			Color recievedColor = JColorChooser.showDialog(null, "Choose background color", bgColor);
			if (recievedColor != null) {
				bgColor = recievedColor;
				MainFrame.main.setBackground(parent.menu.getBgColor());
			}
		}
		if (ob == setColor) {

			Color recievedColor = JColorChooser.showDialog(null, "Choose line color", lnColor);
			if (recievedColor != null) {
				lnColor = recievedColor;
				parent.main.repaint();
			}
		}
		if (ob == rotate) {
			rotatePanel();
		}

		// TODO Auto-generated method stub

		if (ob == save) {

			BufferedImage img = new BufferedImage(1200, 800, BufferedImage.TYPE_INT_RGB);
			Graphics g = img.createGraphics();
			parent.main.paintComponent(g);

			choose = new JFileChooser();
			int wynik = choose.showDialog(null, "wybierz");
			choose.setDialogTitle("wybierz");
			if (wynik == JFileChooser.APPROVE_OPTION) {
				try {
					ImageIO.write(img, "png", choose.getSelectedFile());
					System.out.println("zapisano");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.print("PLIK NIE ZOSTAŁ ZAPISANY");
				}

			}
		}
		if (ob == size2) {
			MainPanel.lineWidth = 2;
			// repaint();
		}
		if (ob == size3) {
			MainPanel.lineWidth = 8;
			// repaint();

		}
		if (ob == size4) {
			MainPanel.lineWidth = 12;
			// repaint();

		}
		if (ob == open) {
			openFile();
		}

		if (ob == niu)

		{
			int choice = JOptionPane.showConfirmDialog(null, "Do u want save?", "Exit?", JOptionPane.YES_NO_OPTION);
			if (choice == 1) {
				resetColor(main);
				repaint();

			}

			else {

				BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
				Graphics g = img.createGraphics();
				paintComponent(g);
				choose = new JFileChooser();
				int wynik = choose.showDialog(null, "wybierz");
				choose.setDialogTitle("wybierz");
				if (wynik == JFileChooser.APPROVE_OPTION) {
					try {
						ImageIO.write(img, "png", choose.getSelectedFile());
						System.out.println("zapisano");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.print("PLIK NIE ZOSTAŁ ZAPISANY");
					}

				}
				repaint();

			}

		}
		if (ob == about) {
			JOptionPane.showMessageDialog(null, "Click on the tool button and draw :)");
		}
	}

	public Color getBgColor() {
		return bgColor;
	}

	public Color getLnColor() {
		return lnColor;
	}

	public static void resetColor(MainPanel drawPanel) {
		MainPanel.shapes.clear();
		MainPanel.shape = null;
		MainFrame.main.image = null;
		MainFrame.main.repaint();
	}

	// for (int x = 0; x < parent.main.shapes.size(); x++) {

	// }
	// 891 695

	public void rotatePanel() {

		BufferedImage image = new BufferedImage(MainFrame.main.getWidth(), MainFrame.main.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();
		g2d.rotate(Math.PI / 4, image.getWidth() / 2, image.getHeight() / 2);

		MainFrame.main.paintAll(g2d);
		resetColor(MainFrame.main);
		MainFrame.main.setBackgroudImage(image);
	}

	public void openFile() {
		final JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Graphic files", "jpg", "gif", "png");
		fc.addChoosableFileFilter(filter);
		int returnVal = fc.showDialog(null, "Open");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			BufferedImage image = null;
			try {
				image = ImageIO.read(fc.getSelectedFile());
				System.out.println("dzila");
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
			MainFrame.main.setBackgroudImage(image);
		}
	}

	WindowListener exitListener = new WindowAdapter() {

		@Override
		public void windowClosing(WindowEvent e) {
			int confirm = JOptionPane.showOptionDialog(null, "Czy chcesz zapisac przed wyjsciem?", "Exit Confirmation",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirm == 0) {
				BufferedImage img = new BufferedImage(1200, 800, BufferedImage.TYPE_INT_RGB);
				Graphics g = img.createGraphics();
				parent.main.paintComponent(g);

				choose = new JFileChooser();
				int wynik = choose.showDialog(null, "wybierz");
				choose.setDialogTitle("wybierz");
				if (wynik == JFileChooser.APPROVE_OPTION) {
					try {
						ImageIO.write(img, "png", choose.getSelectedFile());
						System.out.println("zapisano");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.print("PLIK NIE ZOSTAŁ ZAPISANY");
					}

				}

			}
		}
	};

}