package lab7;

import javax.swing.JButton;

public class ButtonLiczacy extends JButton implements Runnable{
	Thread watek;
	public boolean czas = true;
	
	public ButtonLiczacy() {
		watek = new Thread(this);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void setTekst(int i) {
		this.setText("Do wyłaczenia programu zostało: "+i);
		
	}
	public void StartThread() {
		watek.start();
	}

	@Override
	public void run() {
		int i = 20;
		while (czas) {
			try {
			 
					Thread.sleep(1000);
					this.setTekst(i);
					i--;
				}
			 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		// TODO Auto-generated method stub
		
	}

}
