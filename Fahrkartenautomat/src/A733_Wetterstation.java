
public class A733_Wetterstation {

	public static void main(String[] args) {
		double[] wetterdaten = { -15.55, -2.55, -11.44, -8.6, -14.4, -5.17, 1.48, -3.47, 2.00, 2.14, 4.05, 7.45, 3.25, 5.04, 11.4, 7.67, 8.64, 13.28, 6.87, 15.54, 12.45, 16.55, 20.42, 22.38, 19.58, 18.85, 23.84, 24.42, 25.54, 28.35, 30.16, 32.44, 26.55, 22.13, 16.64, 13.33, 16.45, 17.34, 15.33, 11.13, 15.16, 11.44, 6.55, 2.13, 6.64, 3.33, 6.45, -1.34, 5.33, -11.15 };
		getAnzahl(wetterdaten);
		getDurchschnitt(wetterdaten);
		getMinimum(wetterdaten);
		getMaximum(wetterdaten);
		getUmschwung(wetterdaten);
	}
	
	public static void getAnzahl(double[] daten) {
		System.out.println("Anzahl Daten: " + daten.length);
	}
	
	public static void getDurchschnitt(double[] daten) {
		int anzahl = daten.length;
		double summe = 0;
		for(int i = 0; i < anzahl; i++) {
			summe += daten[i];
		}
		System.out.printf("Durchschnitt: %.2f\n", summe/anzahl);
	}
	
	public static void getMinimum(double[] daten) {
		double min = daten[0];
		int anzahl = daten.length;
		for(int i = 1; i<anzahl-1; i++) {
			if(daten[i]<min) {
				min = daten[i];
			}
		}
		System.out.println("Min: " + min);
	}
	
	public static void getMaximum(double[] daten) {
		double max = daten[0];
		int anzahl = daten.length;
		for(int i = 1; i<anzahl-1; i++) {
			if(daten[i]>max) {
				max = daten[i];
			}
		}
		System.out.println("Max: " + max);
	}
	
	public static void getUmschwung(double[] daten) {
		double max_umschwung = 0;
		double umschwung = 0;
		int day_a = 0;
		int day_b = 0;
		int anzahl = daten.length;
		for(int i = 0; i < anzahl-1; i++) {
			umschwung = Math.abs(daten [i] - daten [i+1]);
			if(umschwung>max_umschwung) {
				max_umschwung = umschwung;
				day_a = i;
				day_b = i+1;
			}
		}
		System.out.println("Umschwung: " + max_umschwung + " zwischen Tag " + day_a + " und Tag " + day_b); 
	}
	
	

}
