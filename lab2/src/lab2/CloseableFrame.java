package lab2;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class CloseableFrame extends JFrame {

	public CloseableFrame() throws HeadlessException {
		this.setSize(640,480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// TODO Auto-generated constructor stub
	}

	public CloseableFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public CloseableFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public CloseableFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	

	

}
