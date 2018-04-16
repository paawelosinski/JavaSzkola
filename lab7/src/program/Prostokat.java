package program;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Prostokat {
	File imageFile;
	private int xPos = 50;
	private int yPos = 50;
	private int width = 20;
	private int height = 20;
	private Color color = Color.BLACK;
	public int vx;
	public int vy;
	public static BufferedImage image;
	public int animacja = 0;

	public Prostokat() {
	}

	public int getX() {
		return xPos;
	}

	public void setX(int xPos) {
		this.xPos = xPos;
	}

	public void setY(int yPos) {
		this.yPos = yPos;
	}

	public int getY() {
		return yPos;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void paint(Graphics g, JPanel panel, boolean wartosc) {
		if (animacja == 5)
			animacja = 0;
		animacja++;
		if (PanelRysowania.prostakaty.get(PanelRysowania.zmienna).getvx() > 0) {
			if ((animacja == 1) || (animacja == 2))
				imageFile = new File("/home/paawel97/eclipse-workspace/lab6/src/images/gumka.jpeg");
			if ((animacja == 3) || (animacja == 4))
				imageFile = new File("/home/paawel97/eclipse-workspace/lab6/src/images/kolo.jpeg");
 
		} else {
			if ((animacja == 1) || (animacja == 2))
				imageFile = new File("/home/paawel97/eclipse-workspace/lab6/src/images/olowek.jpg");
			if ((animacja == 3) || (animacja == 4))
				imageFile = new File("/home/paawel97/eclipse-workspace/lab6/src/images/kwadrat.png");
		}
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub

		if (wartosc) {
			g.setColor(getColor());
			g.fillRect(xPos, yPos, getWidth(), getHeight());
		} else {
			g.drawImage(image, xPos, yPos, panel);
		}
	}

	public void setvx(int i) {
		this.vx = i;

	}

	public void setvy(int i) {
		this.vy = i;

	}

	public int getvx() {
		return vx;
	}

	public int getvy() {
		return vy;

	}

}
