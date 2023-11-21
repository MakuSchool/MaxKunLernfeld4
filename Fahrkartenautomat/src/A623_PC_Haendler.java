import java.util.Scanner;

public class A623_PC_Haendler {

	public static void main(String[] args) {
		rechnungausgeben("Nudeln", 3, berechneNettopreis(3, 0.56), brechneBruttopreis(berechneNettopreis(3, 0.56), 0.4), 0.4);

	}
	
	public static String liesString(Scanner tastatur, String text) {
		System.out.println(text);
		return tastatur.next();
	}
	
	public static int liesInt(Scanner tastatur, String text) {
		System.out.println(text);
		return tastatur.nextInt();
	}
	
	public static double liesDouble(Scanner tastatur, String text) {
		System.out.println(text);
		return tastatur.nextDouble();
	}
	
	public static double berechneNettopreis(int anzahl, double nettopreis) {
		return anzahl*nettopreis;
	}
	
	public static double brechneBruttopreis(double nettogesamtpreis, double mwst) {
		return nettogesamtpreis * (1+mwst / 100);
	}
	
	public static void rechnungausgeben(String artikel, int anzahl, double nettogesamtpreis, double bruttogesamtpreis, double mwst) {
		System.out.print("\\Rechnung");
		System.out.printf("Netto: %-20s %6d %10.2f %n", artikel, anzahl, nettogesamtpreis);
		System.out.printf("Brutto: %-20s %6d %10.2f (%.1f%s)%n", artikel, anzahl, bruttogesamtpreis, mwst, "%");
	}

}
