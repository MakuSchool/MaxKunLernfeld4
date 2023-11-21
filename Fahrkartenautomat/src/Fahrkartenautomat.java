import java.util.Scanner;

/*
 * Maximilian Kunick
 * MTS 32
 * A2.6 Fahrkartenautomat kommentieren
 * A3.3: Ausgabe des Fahrkartenautomaten anpassen 
 * A3.2 Anzahl der Tickets hinzufügen 
 * A4.1 PQ-Fomel
 * A4.1 Tageszeit
 * A4.1 Schaltjahr
 * A4.2: Ticketgrenzen im Fahrkartenautomat implementieren
 * A4.3: Geldeingabe überprüfen
 * A5.1: Schleifen
 * A6.3: Methoden
 */

class Fahrkartenautomat {
	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);

		double zuZahlenderBetrag;
		double eingezahlterGesamtbetrag;
		double eingeworfeneMuenze;
		double rueckgabebetrag;
		double nochZuZahlen;
		
		//Begruessung
		begruessung();

		// Geldbetrag eingeben
		zuZahlenderBetrag = fahrkartenbestellungsErfassung(tastatur);

		// Geldeinwurf
		eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur, zuZahlenderBetrag);
		
		// Fahrscheinausgabe
		fahrkartenAusgeben();
		
		// Rückgeldberechnung und -ausgabe
		rueckgeldAusgeben(zuZahlenderBetrag, eingezahlterGesamtbetrag);
		
		tastatur.close();
	}
	
	public static void begruessung() {
		System.out.println("Herzlich Willkommen!\n");
	}
	
	public static double fahrkartenbestellungsErfassung(Scanner tastatur) {
		
		double zuZahlenderBetrag;
		int anzahlTickets;
		
		System.out.print("Zu zahlender Betrag (Euro): ");
		zuZahlenderBetrag = tastatur.nextDouble();
				
		if(zuZahlenderBetrag < 0){
			System.out.println("Fehlerhafte Eingabe: Der Ticketpreis muss positiv sein!\nTicketprei wird auf 1€ gesetzt");
			zuZahlenderBetrag = 1;
		}
				
		// Anzahl Tickets eingeben
		// Testen auf korrekten Wert
		System.out.print("Ticketanzahl: ");
		anzahlTickets = tastatur.nextInt();
				
		if(anzahlTickets <= 0 || anzahlTickets > 10){
			System.out.println("Fehlerhafte Eingabe: Die anzahl Tickets ist negativ oder größer 10!\nTicketanzahl wird auf 1 gesetzt");
			zuZahlenderBetrag = 1;
		}
				
		// Ticketanzahl mal Ticketpreis
		zuZahlenderBetrag *= anzahlTickets;  
		
		return zuZahlenderBetrag;
	}
	
	public static double fahrkartenBezahlen(Scanner tastatur, double zuZahlenderBetrag) {
		double eingezahlterGesamtbetrag = 0.0;
		double nochZuZahlen = 0.0;
		double eingeworfeneMuenze;
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.printf("Noch zu zahlen: %.2f Euro\n", nochZuZahlen);
			System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro): ");
			eingeworfeneMuenze = tastatur.nextDouble();
			if(eingeworfeneMuenze == 0.05 || eingeworfeneMuenze == 0.10 || eingeworfeneMuenze == 0.20 || eingeworfeneMuenze == 0.50 || eingeworfeneMuenze == 1.00 || eingeworfeneMuenze == 2.00 || eingeworfeneMuenze == 5.00 || eingeworfeneMuenze == 10.00 || eingeworfeneMuenze == 20.00) {
				eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
			} else {
				System.out.println("Der eingezahlte Betrag ist ungültig");
			}
		}
		return eingezahlterGesamtbetrag;
	}
	
	public static void fahrkartenAusgeben() {
		System.out.println("\nFahrschein wird ausgegeben");
		for (int i = 0; i < 8; i++) {
			System.out.print("=");
			try {
				Thread.sleep(200);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n\n");
	}
	
	public static void rueckgeldAusgeben(double zuZahlenderBetrag, double eingezahlterGesamtbetrag) {
		
		double rueckgabebetrag;
		
		rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
		if (rueckgabebetrag > 0.0) {
			System.out.printf("Der Rückgabebetrag in Höhe von %.2f Euro\n", rueckgabebetrag);
			System.out.println("wird in folgenden Münzen ausgezahlt:");

			while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
				System.out.println("2 Euro");
				rueckgabebetrag = rueckgabebetrag - 2.0;
			}
			while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
				System.out.println("1 Euro");
				rueckgabebetrag = rueckgabebetrag - 1.0;
			}
			while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
				System.out.println("50 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.5;
			}
			while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
				System.out.println("20 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.2;
			}
			while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
				System.out.println("10 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.1;
			}
			while (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
				System.out.println("5 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.05;
			}
		}

		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");

	}
}
