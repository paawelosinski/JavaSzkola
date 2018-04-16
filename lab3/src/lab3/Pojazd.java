package lab3;

public interface Pojazd {
	public void stop();
	public void start();
	public void ustawPredkosc(double[] v);
	default String nazwa() {
		return "Pojazd";
	}
	default float obliczPredkosc(float droga,float czas) {
		return droga*czas;
	}
	

}
