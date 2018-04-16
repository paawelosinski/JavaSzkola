import java.awt.event.KeyEvent;

import javax.swing.JLabel;

public class KeyListene implements java.awt.event.KeyListener {
	JLabel wyniki;
	public KeyListene(JLabel label) {
		this.wyniki=label;
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		
		
		
		
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_6 )
			wyniki.setText(wyniki.getText()+e.getKeyChar());
		if(e.getKeyCode() == KeyEvent.VK_1 )
			wyniki.setText(wyniki.getText()+e.getKeyChar());
		if(e.getKeyCode() == KeyEvent.VK_2 )
			wyniki.setText(wyniki.getText()+e.getKeyChar());
		if(e.getKeyCode() == KeyEvent.VK_3 )
			wyniki.setText(wyniki.getText()+e.getKeyChar());
		if(e.getKeyCode() == KeyEvent.VK_4 )
			wyniki.setText(wyniki.getText()+e.getKeyChar());
		if(e.getKeyCode() == KeyEvent.VK_5 )
			wyniki.setText(wyniki.getText()+e.getKeyChar());
		if(e.getKeyCode() == KeyEvent.VK_7 )
			wyniki.setText(wyniki.getText()+e.getKeyChar());
		if(e.getKeyCode() == KeyEvent.VK_8 )
			wyniki.setText(wyniki.getText()+e.getKeyChar());
		if(e.getKeyCode() == KeyEvent.VK_9 )
			wyniki.setText(wyniki.getText()+e.getKeyChar());
		if(e.getKeyCode() == KeyEvent.VK_0 )
			wyniki.setText(wyniki.getText()+e.getKeyChar());
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE ) {
			
			wyniki.setText("");
		}
		 
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
		// TODO Auto-generated method stub
		
	}

}
