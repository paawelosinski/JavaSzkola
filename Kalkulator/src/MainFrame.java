import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.layout.Border;

import java.lang.Math;

public class MainFrame extends JFrame implements ActionListener {
	JButton[] buttons = new JButton[11];
	int rodzaj = 0;
	JLabel wyniki = new JLabel();
	JLabel wyniki2 = new JLabel();
	JLabel wyniki3 = new JLabel();
	public int porzadkowa = 1;
	JButton przycisk1 = new JButton("+");
	JButton przycisk2 = new JButton("-");
	JButton przycisk3 = new JButton("*");
	JButton przycisk4 = new JButton("/");
	JButton przycisk5 = new JButton("delete");
	JButton przycisk6 = new JButton("sqrt");
	JButton przycisk7 = new JButton(".");
	JButton przycisk = new JButton("=");
	JButton przycisk11 = new JButton("log10");
	JButton przycisk12 = new JButton("do potegi");

	public MainFrame() {
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		setFocusable(true);

		panel2.setLayout(new GridLayout(4, 3));

		for (int i = 1; i < 10; i++) {
			buttons[i] = new JButton(String.valueOf(i));
			panel2.add(buttons[i]);
			buttons[i].addActionListener(this);
		}
		buttons[10] = new JButton("0");

		panel3.setLayout(new GridLayout(4, 3));
		panel2.add(przycisk);
		panel2.add(buttons[10]);
		panel2.add(przycisk7);
		panel1.setSize(100, 800);
		panel3.add(przycisk1);
		panel3.add(przycisk2);
		panel3.add(przycisk3);
		panel3.add(przycisk4);
		panel3.add(przycisk6);
		panel3.add(przycisk5);
		panel3.add(przycisk11);
		panel3.add(przycisk12);
		
		buttons[10].addActionListener(this);
		przycisk1.addActionListener(this);
		przycisk2.addActionListener(this);
		przycisk3.addActionListener(this);
		przycisk4.addActionListener(this);
		przycisk5.addActionListener(this);
		przycisk7.addActionListener(this);
		przycisk.addActionListener(this);
		przycisk6.addActionListener(this);
		przycisk11.addActionListener(this);
		przycisk12.addActionListener(this);

		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		panel1.add(wyniki);
		panel1.add(wyniki2);
		panel1.add(wyniki3);
		this.add(panel3, BorderLayout.EAST);

		this.addKeyListener(new KeyListene(wyniki));

	}

	public static void main(String[] args) {
		new MainFrame().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(porzadkowa);

		Object ob = e.getSource();
		if (porzadkowa == 1) {
			for (int x = 1; x < 11; x++) {
				if (buttons[x] == ob)
					wyniki.setText(wyniki.getText() + buttons[x].getText());
			}
		} // String.valueOf(Float.parseFloat(buttons[x].getText()))

		if (porzadkowa == 2) {
			for (int x = 1; x < 11; x++) {
				if (buttons[x] == ob)
					wyniki3.setText(wyniki3.getText() + buttons[x].getText());
			}
		} // String.valueOf(Float.parseFloat(buttons[x].getText()))}

		if (przycisk1 == ob) {// dodawanie
			wyniki2.setText(przycisk1.getText());
			porzadkowa = 2;
			rodzaj = 1;
		}
		if (przycisk2 == ob) {// odejmowanie
			wyniki2.setText(przycisk2.getText());
			porzadkowa = 2;
			rodzaj = 2;
		}
		if (przycisk3 == ob) {// mnozenie
			wyniki2.setText(przycisk3.getText());
			porzadkowa = 2;
			rodzaj = 3;
		}
		if (przycisk4 == ob) {// dzielenie
			wyniki2.setText(przycisk4.getText());
			porzadkowa = 2;
			rodzaj = 4;
		}
		if (przycisk == ob) {// rowna sie
			if (rodzaj == 1) {// dodawanie
				float wynik = Float.parseFloat(wyniki.getText()) + Float.parseFloat(wyniki3.getText());
				wyniki.setText(String.valueOf(wynik));
			}
			if (rodzaj == 2) {// odejmowanie
				float wynik = Float.parseFloat(wyniki.getText()) - Float.parseFloat(wyniki3.getText());
				wyniki.setText(String.valueOf(wynik));
			}
			if (rodzaj == 3) {// mnozenie
				float wynik = Float.parseFloat(wyniki.getText()) * Float.parseFloat(wyniki3.getText());
				wyniki.setText(String.valueOf(wynik));
			}
			if (rodzaj == 4) {// dzielenie
				float wynik = Float.parseFloat(wyniki.getText()) / Float.parseFloat(wyniki3.getText());
				wyniki.setText(String.valueOf(wynik));
			}
			if (rodzaj == 6) {
				float wynik = Float.parseFloat(wyniki.getText());
				float wynik2 = Float.parseFloat(wyniki3.getText());
				double wyniczek = (float) wynik;
				double wyniczek1 = (float) wynik2;
				wyniczek = Math.pow(wyniczek, wyniczek1);
				wyniki.setText(String.valueOf(wyniczek));
			}
			wyniki2.setText("");
			wyniki3.setText("");
			porzadkowa = 0;
			rodzaj = 0;

		}

		if (przycisk5 == ob) {
			wyniki.setText("");
			wyniki2.setText("");
			wyniki3.setText("");
			porzadkowa = 1;
		}

		if (przycisk7 == ob) {
			if (porzadkowa == 1) {
				wyniki.setText(wyniki.getText() + przycisk7.getText());
			}
			if (porzadkowa == 2) {
				wyniki3.setText(wyniki3.getText() + przycisk7.getText());
			}

		}
		if (przycisk6 == ob) {
			if (rodzaj == 1) {// dodawanie
				float wynik = Float.parseFloat(wyniki.getText()) + Float.parseFloat(wyniki3.getText());
				double wyniczek = (float) wynik;
				wyniczek = Math.sqrt(wyniczek);
				wyniki.setText(String.valueOf(wyniczek));
			}
			if (rodzaj == 2) {// odejmowanie
				float wynik = Float.parseFloat(wyniki.getText()) - Float.parseFloat(wyniki3.getText());
				double wyniczek = (float) wynik;
				wyniczek = Math.sqrt(wyniczek);
				wyniki.setText(String.valueOf(wyniczek));
			}
			if (rodzaj == 3) {// mnozenie
				float wynik = Float.parseFloat(wyniki.getText()) * Float.parseFloat(wyniki3.getText());
				double wyniczek = (float) wynik;
				wyniczek = Math.sqrt(wyniczek);
				wyniki.setText(String.valueOf(wyniczek));
			}
			if (rodzaj == 4) {// dzielenie
				float wynik = Float.parseFloat(wyniki.getText()) / Float.parseFloat(wyniki3.getText());
				double wyniczek = (float) wynik;
				wyniczek = Math.sqrt(wyniczek);
				wyniki.setText(String.valueOf(wyniczek));
			}
			if (rodzaj == 6) {
				float wynik = Float.parseFloat(wyniki.getText());
				float wynik2 = Float.parseFloat(wyniki3.getText());
				double wyniczek = (float) wynik;
				double wyniczek1 = (float) wynik2;
				wyniczek = Math.pow(wyniczek, wyniczek1);
				wyniczek=Math.sqrt(wyniczek);
				wyniki.setText(String.valueOf(wyniczek));
			}
			if (rodzaj == 0) {
				float wynik = Float.parseFloat(wyniki.getText());
				double wyniczek = (float) wynik;
				wyniczek = Math.sqrt(wyniczek);

				wyniki.setText(String.valueOf(wyniczek));

			}
			wyniki2.setText("");
			wyniki3.setText("");
			porzadkowa = 0;
			rodzaj = 0;

		}
		if (przycisk12 == ob) {
			rodzaj = 6;
			wyniki2.setText("^");
			porzadkowa = 2;

		}
		if (przycisk11 == ob) {
			if (rodzaj == 1) {// dodawanie
				float wynik = Float.parseFloat(wyniki.getText()) + Float.parseFloat(wyniki3.getText());
				double wyniczek = (float) wynik;
				wyniczek = Math.log10(wyniczek);
				wyniki.setText(String.valueOf(wyniczek));
			}
			if (rodzaj == 2) {// odejmowanie
				float wynik = Float.parseFloat(wyniki.getText()) - Float.parseFloat(wyniki3.getText());
				double wyniczek = (float) wynik;
				wyniczek = Math.log10(wyniczek);
				wyniki.setText(String.valueOf(wyniczek));
			}
			if (rodzaj == 3) {// mnozenie
				float wynik = Float.parseFloat(wyniki.getText()) * Float.parseFloat(wyniki3.getText());
				double wyniczek = (float) wynik;
				wyniczek = Math.log10(wyniczek);
				wyniki.setText(String.valueOf(wyniczek));
			}
			if (rodzaj == 4) {// dzielenie
				float wynik = Float.parseFloat(wyniki.getText()) / Float.parseFloat(wyniki3.getText());
				double wyniczek = (float) wynik;
				wyniczek = Math.log10(wyniczek);
				wyniki.setText(String.valueOf(wyniczek));
			}
			if (rodzaj == 0) {
				float wynik = Float.parseFloat(wyniki.getText());
				double wyniczek = (float) wynik;
				wyniczek = Math.log10(wyniczek);

				wyniki.setText(String.valueOf(wyniczek));

			}
			wyniki2.setText("");
			wyniki3.setText("");
			porzadkowa = 0;
			rodzaj = 0;

		}

		MainFrame.this.setFocusable(true);
		requestFocus();

		// TODO Auto-generated method stub

	}

}
