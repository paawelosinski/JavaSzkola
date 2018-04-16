package program;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class PanelRysowania extends JPanel implements Runnable {
	Thread watek;
	public BufferedImage image;
	public boolean wartosc = true;
	public static  int zmienna;
	File imageFile;

	private static final long serialVersionUID = 1L;
	static List<Prostokat> prostakaty = new ArrayList<Prostokat>();

	public PanelRysowania() {
		

		// domyslny konstruktor
	}

	public void dodajLosowyProstokat() {
		
		wartosc = true;
		Random r = new Random();
		watek = new Thread(this);

		Prostokat p = new Prostokat();
		p.setX(r.nextInt(550));
		p.setY(r.nextInt(550));
		p.setWidth(r.nextInt(80));
		p.setHeight(r.nextInt(80));
		p.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		p.setvx(ThreadLocalRandom.current().nextInt(-10, 10));
		p.setvy(ThreadLocalRandom.current().nextInt(-10, 10));
		zmienna=r.nextInt(20);

		prostakaty.add(p);
	}

	public void dodajProstokat(int x, int y, int width, int height, Color c) {

		Prostokat p = new Prostokat();
		p.setX(x);
		p.setY(y);
		p.setWidth(width);
		p.setHeight(height);
		p.setColor(c);
		p.setvx(ThreadLocalRandom.current().nextInt(-10, 10));
		p.setvy(ThreadLocalRandom.current().nextInt(-10, 10));
		

		prostakaty.add(p);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int x = 0; x < prostakaty.size(); x++) {
			if (x != zmienna) {
				wartosc = true;
				prostakaty.get(x).paint(g, this, wartosc);
			} else {
				wartosc = false;
				prostakaty.get(x).setWidth(Prostokat.image.getWidth());
				prostakaty.get(x).setHeight(Prostokat.image.getHeight());
				
				prostakaty.get(x).paint(g, this, wartosc);
 
			}

		}

	}
	public void image() {
	
		
		
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
		
	}

	public Dimension getPreferredSize() {
		return new Dimension(600, 600);
	}

	public void rysuj() {
		for (Prostokat pr : prostakaty) {
			pr.setX(pr.getX() + pr.getvx());
			pr.setY(pr.getY() + pr.getvy());

			if (pr.getX() <= 0) {
				pr.setvx(pr.getvx() * (-1));
			}
			if (pr.getY() <= 0) {
				pr.setvy(pr.getvy() * (-1));
			}
			if (pr.getX() + pr.getWidth() >= MainClass.Width) {

				pr.setvx(pr.getvx() * (-1));
			}
			if (pr.getY() + pr.getHeight() >= MainClass.Height) {
				pr.setvy(pr.getvy() * (-1));
			}
		}

		repaint();
	}

	@Override
	public void run() {
		while (true) {
			try {

				rysuj();
				Thread.sleep(100);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Toolkit.getDefaultToolkit().sync();

			// TODO Auto-generated method stub

		}
	}

	public void StartThread() {
		watek.start();
	}
}
