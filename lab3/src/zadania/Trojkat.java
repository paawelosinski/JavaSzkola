package zadania;

public class Trojkat implements Figura {
	private double bok1;
	private double bok2;
	private double bok3;
	
	public Trojkat(float bok1,float bok2,float bok3) {
		this.bok1=bok1;
		this.bok2=bok2;
		this.bok3=bok3;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double obliczObwod() {
		return bok1+bok2+bok3;
		
	}

	@Override
	public double obliczPole() {
		double obwod=obliczObwod()/2;
		return Math.sqrt(obwod*(obwod-bok1)*(obwod-bok2)*(obwod-bok3));
		
	}

}
