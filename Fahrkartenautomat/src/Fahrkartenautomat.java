import java.util.Scanner;

/*
 * Maximilian Kunick
 * MTS 32
 * A2.6 Fahrkartenautomat kommentieren
 * A3.3: Ausgabe des Fahrkartenautomaten anpassen 
 * A3.2 Anzahl der Tickets hinzufügen 
 * A3.3 Fehlerbeseitigung 
 * A4.1 PQ-Fomel
 * A4.1 Tageszeit
 * A4.1 Schaltjahr
 * A4.2: Ticketgrenzen im Fahrkartenautomat implementieren
 * A4.3: Geldeingabe überprüfen
 * A5.1: Schleifen
 * A5.3: Wiederholung der Eingabe der Ticketanzahl 
 * A5.4: Fahrkartenauswahl 
 * A5.5: Fahrkarten kombinieren
 * A6.3: Methoden
 * A6.4: Zusatzschleife
 * A7.4: Fahrkartenarray 
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
		
		double zuZahlenderBetrag = 0;
		int auswahl;
		int anzahlTickets;
		double zwischenBetrag = 0;
		
		String[] ticketNamen = {"Einzelfahrschein AB","Einzelfahrschein BC","Einzelfahrschein ABC","Kurzstrecke AB","Tageskarte AB","Tageskarte BC","Tageskarte ABC","4-Fahrten-Karte AB","4-Fahrten-Karte BC","4-Fahrten-Karte ABC","Kleingruppen-Tageskarte AB","Kleingruppen-Tageskarte BC","Kleingruppen-Tageskarte ABC"};
		double[] ticketPreise = {3.0, 3.5, 3.8, 2.0, 8.6, 9.2, 10.0, 9.4, 12.6, 13.8, 25.5, 26.0, 26.5}; 
		
		while(true) {
			
			System.out.print("Fahrkartenbestellvorgang:\r\n"
					+ "=========================\n\n");
			for(int i = 0; i < ticketNamen.length; i++) {
				System.out.printf("%s [%.2f €] (%d)\n", ticketNamen[i], ticketPreise[i], (i+1));
			}
			System.out.print("Bezahlen (14)\n");
			
			System.out.print("Ihre Wahl:");
			auswahl = tastatur.nextInt();
			
			if(auswahl == 14) {
				return zuZahlenderBetrag;
			}
			
			while(auswahl <= 0 || auswahl > 14) {
				System.out.println(">>falsche Eingabe<<");
				System.out.print("Ihre Wahl:");
				auswahl = tastatur.nextInt();
			}
			
			zwischenBetrag = 0;
		
			// Anzahl Tickets eingeben
			// Testen auf korrekten Wert
			System.out.print("Ticketanzahl: ");
			anzahlTickets = tastatur.nextInt();
					
			while(anzahlTickets <= 0 || anzahlTickets > 10) {
				System.out.println("Fehlerhafte Eingabe: Die anzahl Tickets ist negativ oder größer 10!\n");
				System.out.print("Ticketanzahl: ");
				anzahlTickets = tastatur.nextInt();
			}
					
			// Ticketanzahl mal Ticketpreis
			zwischenBetrag = ticketPreise[auswahl] * anzahlTickets;  
			zuZahlenderBetrag += zwischenBetrag;
			System.out.printf("Zwischensumme: %.2f Euro\n", zuZahlenderBetrag);
		}
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
		rueckgabebetrag = Math.ceil(rueckgabebetrag * 100) / 100; 
		if (rueckgabebetrag > 0.0) {
			System.out.printf("Der Rückgabebetrag in Höhe von %.2f Euro\n", rueckgabebetrag);
			System.out.println("wird in folgenden Münzen ausgezahlt:");

			//2 Euro
			rueckgabebetrag = muenzRueckgabe(rueckgabebetrag, 2.0, "2 Euro");
			//1 Euro
			rueckgabebetrag = muenzRueckgabe(rueckgabebetrag, 1.0, "1 Euro");
			//50 Cent
			rueckgabebetrag = muenzRueckgabe(rueckgabebetrag, 0.5, "50 Cent");
			//20 Cent
			rueckgabebetrag = muenzRueckgabe(rueckgabebetrag, 0.2, "20 Cent");
			//10 Cent
			rueckgabebetrag = muenzRueckgabe(rueckgabebetrag, 0.1, "10 Cent");
			//5 Cent
			rueckgabebetrag = muenzRueckgabe(rueckgabebetrag, 0.05, "5 Cent");
		}

		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");

	}
	
	public static double muenzRueckgabe(double rueckgabeWert, double muenzWert, String muenze) {
		while (rueckgabeWert >= muenzWert) {
			System.out.println(muenze);
			rueckgabeWert = rueckgabeWert - muenzWert;
		}
		return Math.ceil(rueckgabeWert * 100) / 100;
	}
}

