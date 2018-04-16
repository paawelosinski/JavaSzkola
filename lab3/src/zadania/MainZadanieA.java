package zadania;

public class MainZadanieA {

	public static void main(String[] args) {
		Figura f1=new Kolo(10000);
		Figura f2=new Trojkat(3,5,4);
		System.out.println(f1.obliczObwod()+"  "+f1.obliczPole());
		System.out.println("Trojkat: "+f2.obliczObwod()+"  "+f2.obliczPole());
		// TODO Auto-generated method stub

	}

}
