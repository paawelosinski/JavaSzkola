package lab7;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panelik extends JPanel implements Runnable {
	private Color[] colors = { Color.GREEN, Color.BLUE, Color.RED };
	Thread watek;
	public long time;
	public long endtime;
	public static boolean Time = true;

	public Panelik() {
		watek = new Thread(this);

		// TODO Auto-generated constructor stub
	}

	public void ChangeColor() {
		
		int R = new Random().nextInt(256);
		int G = new Random().nextInt(256);
		int B = new Random().nextInt(256);
		Color color = new Color(R, G, B);
		this.setBackground(color);
	}

	public void StartThread() {
		watek.start();
	}

	@Override
	public void run() {
		time = System.currentTimeMillis();
		while (Time) {
			try {
				endtime = System.currentTimeMillis();
				if (time+ 20000<  endtime ) 
					RandomWindow.exit();
				else {
					Thread.sleep(1000);
					this.ChangeColor();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub

	}

}
