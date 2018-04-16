package lab44;

import java.awt.BorderLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainClass implements ComponentListener {

	public TopPanel topPanel;
	public LeftPanel leftPanel;
	public RightPanel rightPanel;
	public CenterPanel centerPanel;
	public BottomPanel bottomPanel;
	
	public int width = 600;
	public int height = 600;
	 
	public MainClass() {
		topPanel = new TopPanel(this);
		leftPanel = new LeftPanel(this);
		rightPanel = new RightPanel(this);
		bottomPanel = new BottomPanel(this);
		centerPanel = new CenterPanel(this);
		
		JFrame window = new JFrame("Polygon drawing");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new BorderLayout());
		window.addComponentListener(this);
		
		String[] thickness = {"1", "2", "5", "10", "15"};
		window.setJMenuBar(new ChooseThicknessMenu(thickness));
		window.add(topPanel, BorderLayout.NORTH);
		window.add(leftPanel, BorderLayout.WEST);
		window.add(centerPanel, BorderLayout.CENTER);
		window.add(rightPanel, BorderLayout.EAST);
		window.add(bottomPanel, BorderLayout.SOUTH);
		
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainClass();
			}
		});
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		width = centerPanel.getWidth();
		height = centerPanel.getHeight();
		rightPanel.setRadius((int) (0.8*height/2));
	}

	@Override
	public void componentHidden(ComponentEvent e) {
	}

	@Override
	public void componentMoved(ComponentEvent e) {
	}

	@Override
	public void componentShown(ComponentEvent e) {
	}

}
