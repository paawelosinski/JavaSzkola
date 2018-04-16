package paincik;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements MouseListener, MouseMotionListener {

	MainFrame parent;
	Graphics2D g2d;
	public static int x = 0;
	public static int y = 0;
	public static int lineWidth = 3;
	static List<Ksztalt> shapes;
	static Ksztalt shape = null;
	Color color = Color.black;
	BufferedImage image;
	int width, height;
	static Color lnColor = Color.BLACK;
	static Color bgColor = Color.WHITE;
	

	public MainPanel(MainFrame parentArg) {
		this.parent = parentArg;
		this.setBackground(Color.WHITE);

		shapes = new ArrayList<>();
		
		this.addMouseListener(this);

		this.addMouseMotionListener(this);
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				width = getWidth();
				height = getHeight();
			}
		});
		width = this.getWidth();
		height = this.getHeight();

		// TODO Auto-generated constructor stub
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;
		if (image != null)
			g2d.drawImage(image, (width - image.getWidth()) / 2, (height - image.getHeight()) / 2, this);

		for (Ksztalt k : shapes) {
			k.draw(g2d);
		}
		if (shape != null) {
			shape.draw(g2d);
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (ButtonPanel.zmienna == 1) {

			shape.setxy(e.getX(), e.getY());
			repaint();
		}
		if (ButtonPanel.zmienna == 2) {
			shape.xList.add(1);
			shape.yList.add(1);
			shape.xList.set(1, e.getX());
			shape.yList.set(1, e.getY());
			repaint();
		}
		if (ButtonPanel.zmienna == 3) {

			shape.setxy(e.getX(), e.getY());
			repaint();
		}
		if (ButtonPanel.zmienna == 4) {
			shape.xList.add(1);
			shape.yList.add(1);
			shape.xList.set(1, e.getX());
			shape.yList.set(1, e.getY());
			repaint();
		}
		if (ButtonPanel.zmienna == 5) {
			shape.xList.add(1);
			shape.yList.add(1);
			shape.xList.set(1, e.getX());
			shape.yList.set(1, e.getY());
			repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (ButtonPanel.zmienna == 1) {
			shape = new Line(parent);
			shape.setxy(e.getX(), e.getY());
			repaint();
		}
		if (ButtonPanel.zmienna == 2) {
			shape = new LiniaProsta(parent);
			shape.setxy(e.getX(), e.getY());

		}
		if (ButtonPanel.zmienna == 3) {
			// lineWidth=10;
			// color=Color.white;
			shape = new Gumka(parent);
			shape.setxy(e.getX(), e.getY());
			repaint();
		}
		if (ButtonPanel.zmienna == 4) {
			shape = new Prostokat(parent);
			shape.setxy(e.getX(), e.getY());

		}
		if (ButtonPanel.zmienna == 5) {
			shape = new Kolko(parent);
			shape.setxy(e.getX(), e.getY());

		}

		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (ButtonPanel.zmienna == 1) {
			shapes.add(shape);
			shape = null;
		}
		if (ButtonPanel.zmienna == 2) {
			shapes.add(shape);

			// shape = null;
			shape.setxy(e.getX(), e.getY());
			repaint();
		}
		if (ButtonPanel.zmienna == 3) {

			shapes.add(shape);
			shape = null;
		}
		if (ButtonPanel.zmienna == 4) {
			shapes.add(shape);

			// shape = null;
			shape.setxy(e.getX(), e.getY());
			repaint();
		}
		if (ButtonPanel.zmienna == 5) {
			shapes.add(shape);

			// shape = null;
			shape.setxy(e.getX(), e.getY());
			repaint();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void setBackgroudImage(BufferedImage image) {
		this.image = image;
		double imageRatio = (double) image.getWidth() / image.getHeight();

		int newWidth = width;
		int newHeight = height;

		if ((double) width / height > imageRatio)
			newWidth = (int) imageRatio * height;
		else
			newHeight = (int) (width / imageRatio);

		Image img = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		BufferedImage bgImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics2D bGr = bgImage.createGraphics();
		bGr.drawImage(img, 0, 0, null);
		bGr.dispose();
		image = bgImage;
		repaint();

	}

}
