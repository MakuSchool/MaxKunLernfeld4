import java.util.Scanner;
public class Zinszins {

	public static void main(String[] args) {
		double kapitalsumme;
		byte laufzeit;
		double zinssatz;
		Scanner input = new Scanner(System.in);
		
		//Eingabe Kapitalsumme
		System.out.print("Wie viel Kapital (in Euro) möchten Sie anlegen: ");;
		kapitalsumme = input.nextInt();
		System.out.println(" ");
		
		//Eingabe laufzeit
		System.out.print("Laufzeit (in Jahren) des Sparvertrags.........: ");
		laufzeit = input.nextByte();
		System.out.println(" ");
		
		//Eingabe Zinssatz
		System.out.print("Zinssatz (in Prozent).........................: ");
		zinssatz = input.nextDouble();
		System.out.println(" ");
		
		//Ausgabe Anfangskapital
		System.out.printf("Eingezahltes Kapital: %.2f Euro\n", kapitalsumme);
		
		//jaehrliche Zinsberechnung
		for(int i = 1; i <= laufzeit; i++) {
			kapitalsumme = kapitalsumme * (1 + (zinssatz/100.0));
		}
		
		//Ausgabe Endkapital
		System.out.printf("Ausgezahltes Kapital: %.2f Euro", kapitalsumme);

	}

}
