package lab8;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar implements ActionListener {

	private JFileChooser chooser;
	JMenu file;
	JMenuItem niu;
	JMenuItem open;
	JMenuItem save;
	MainFrame parent;
	char ch = '?';
	public static List<String> list;
	public static List<String> list2;

	public Menu(MainFrame parentArg) {
		this.parent = parentArg;

		chooser = new JFileChooser();

		file = new JMenu("file");
		niu = new JMenuItem("New");
		open = new JMenuItem("open");
		save = new JMenuItem("save");

		file.add(niu);
		file.add(open);
		file.add(save);
		this.add(file);
		open.addActionListener(this);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// char c;
		int r = chooser.showOpenDialog(null);
		if (r == JFileChooser.APPROVE_OPTION) {
			String filePath = chooser.getSelectedFile().getPath();
			try {
				FileInputStream fr = new FileInputStream(filePath);
				InputStreamReader isr = new InputStreamReader(fr, "UTF-8");
				BufferedReader reader = new BufferedReader(isr);
				StringBuffer buffer = new StringBuffer();

				String line = null;
				list = new ArrayList<>();
				list2 = new ArrayList<>();
				/*
				 * private List<String> loadFile(String fileName) throws FileNotFoundException {
				 * List<String> list = new ArrayList<>(); Scanner s = new Scanner(new
				 * File(fileName), "utf-8"); while (s.hasNext()) { list.add(s.next()); }
				 * 
				 */
				Scanner s = new Scanner(new File(filePath));
				while (s.hasNext()) {

					list.add(s.next());

				}
				changeLetters(list, list2);

				// list.forEach(w -> System.out.println(w));
				reader.close();
				for (int x = 0; x < list2.size(); x++) {
					parent.panel.setText(parent.panel.getText() + list2.get(x) + " ");

				}

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		// TODO Auto-generated method stub

	}

	private List<String> changeLetters(List<String> list, List<String> list2) {
		for (int x = 0; x < list.size(); x++) {

			list2.add(list.get(x).replaceAll("ż", "?").replaceAll("rz", "?").replaceAll("u", "?").replaceAll("ch", "?")
					.replaceAll("ó", "?").replaceAll("h", "?"));

		}

		return list2;

	}

	public static List<String> checking(List<String> list, String[] list2) {
		int s = 0;
		List<String> lista3 = new ArrayList<>();
		for (int x = 0; x < list.size(); x++) {
			if (!list2[x].equals(list.get(x)))
				
			{
				System.out.println("lista->" + list.get(x) + " tablica>>" + list2[x]);

				lista3.add(list2[x]);
				s++;
			}
		}
		return lista3;
	}

}
