package lab4;



	import java.awt.FlowLayout;

	import javax.swing.JPanel;
	import javax.swing.JTextField;

	public class Cords {
		
		double x, y;
		JTextField xField, yField;
		public Cords(double x, double y) {
			this.x = x;
			this.y = y;
			this.xField = new JTextField(String.valueOf(Math.round(x)));
			this.yField = new JTextField(String.valueOf(Math.round(y)));
			this.xField.setColumns(5);
			this.yField.setColumns(5);
		}
		
		void insert(EastPanel parent) {
			JPanel cnt = new JPanel();
			FlowLayout layout = (FlowLayout)cnt.getLayout();
			layout.setVgap(0);
			cnt.add(xField);
			cnt.add(yField);
			parent.add(cnt);
		}
		
		void delete(EastPanel parent) {
			parent.remove(xField);
			parent.remove(yField);
		}
		
		public double getX() {
			return x;
		}
		public void setX(double x) {
			this.x = x;
			xField.setText(String.valueOf(Math.round(x)));
		}
		public double getY() {
			return y;
		}
		public void setY(double y) {
			this.y = y;
			yField.setText(String.valueOf(Math.round(y)));
		}
		public JTextField getxField() {
			return xField;
		}
		public JTextField getyField() {
			return yField;
		}
		
	}


