package zadania;

public class Kolo implements Figura {
	private double promien;
	public Kolo(double promien) {
		this.promien=promien;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public double obliczObwod() {
		return 2*PI*promien;
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public double obliczPole() {
		return PI*promien*promien;
		
	}

	

}
