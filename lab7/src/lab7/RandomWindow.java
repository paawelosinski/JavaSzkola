package lab7;

import java.awt.Dimension;
import java.nio.charset.MalformedInputException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class RandomWindow extends JFrame implements Runnable {
	Panelik panel;
	Thread object;
	ButtonLiczacy but;

	public RandomWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setTitle("okno");
		this.setMinimumSize(new Dimension(600, 400));
		this.setMaximumSize(new Dimension(1200, 800));
		this.setVisible(true);

		object = new Thread(this);
		this.StartThread();
		panel = new Panelik();
		but = new ButtonLiczacy();
		panel.add(but);
		this.add(panel);
		but.StartThread();
		panel.StartThread();

		// TODO Auto-generated constructor stub
	}

	public static void exit() {
		System.exit(0);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new RandomWindow().setVisible(true);
		});

	}
	public void StartThread() {
		object.start();
	}

	@Override
	public void run() {

		while (true) {
			try {
				this.setTitle("zmieniam");
				Thread.sleep(1000);
				this.setTitle("tytuł");
				Thread.sleep(1000);
				
				this.setTitle("co sekunde");
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub

	}

}
